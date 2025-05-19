
import java.io.*;
import java.util.*;
public class Task_Manager {
    private List<Task> tasks = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";
    private int nextId = 1;

    public Task_Manager()
    {
        loadTasksFromFile();
    }

    public void addTask(String title)
    {
        Task task = new Task(nextId++, title, false);
        tasks.add(task);
        saveTasksToFile();
    }

    public void deleteTask(int id)
    {
        tasks.removeIf(t -> t.getId() == id);
        saveTasksToFile();
    }

    public void markTaskCompleted(int id)
    {
        for(Task t :tasks)
        {
            if(t.getId() == id)
            {
                t.markCompleted();
                break;
            }
        }
        saveTasksToFile();
    }

    public List<Task> getAllTasks()
    {
        return tasks;
    }

    public List<Task> getCompletedTasks()
    {
        List<Task> completed = new ArrayList<>();
        for(Task t : tasks)
        {
            if(t.isCompleted())
            {
                completed.add(t);
            }
        }
        return completed;
    }

    public List<Task> getIncompleteTasks()
    {
        List<Task> pending = new ArrayList<>();
        for(Task t : tasks)
        {
            if(!t.isCompleted())
            {
                pending.add(t);
            }
        }
        return pending;
    }

    public void loadTasksFromFile()
    {
        File file = new File(FILE_NAME);
        if(!file.exists())
        {
            return;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            int maxId = 0;
            while((line = reader.readLine()) != null)
            {
                Task task = Task.fromFileString(line);
                tasks.add(task);
                if(task.getId() > maxId)
                {
                    maxId = task.getId();
                }
            }
            nextId = maxId + 1;
        }
        catch (IOException e)
        {
            System.out.println("Error loading tasks: "+ e.getMessage());
        }
    }

    public void saveTasksToFile()
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME)))
        {
            for(Task task : tasks)
            {
                writer.write(task.toFileString());
                writer.newLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error saving tasks: "+e.getMessage());
        }
    }
}
