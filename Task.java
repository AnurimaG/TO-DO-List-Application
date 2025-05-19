
public class Task {
    private int id;
    private String title;
    private boolean isCompleted;

    public Task( int id, String title, Boolean isCompleted)
    {
        this.id=id;
        this.title=title;
        this.isCompleted=isCompleted;
    }

    public int getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }

    public boolean isCompleted()
    {
        return isCompleted;
    }
    public void markCompleted()
    {
        this.isCompleted=true;
    }

    @Override
    public String toString()
    {
        return id + " | " + title + " | " + (isCompleted ? "Completed" : "Pending");
    }

    public String toFileString()
    {
        return id + "," + title + "," + isCompleted;
    }

    public static Task fromFileString(String line)
    {
        String [] parts = line.split(",");
        int id=Integer.parseInt(parts[0]);
        String title = parts[1];
        boolean isCompleted = Boolean.parseBoolean(parts[2]);
        return new Task(id, title, isCompleted);
    }
}
