
import java.util.*;
public class TO_DO_App
{
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        Task_Manager manager = new Task_Manager();
        boolean keepRunning = true;

        while(keepRunning)
        {
            System.out.println("\n~~~~TO-DO LIST~~~~");
            System.out.println("1.Add Tasks");
            System.out.println("2.View All Tasks");
            System.out.println("3.Mark Task As Completed");
            System.out.println("4.Delete Task");
            System.out.println("5.View Completed Tasks");
            System.out.println("6.View Incompleted Tasks");
            System.out.println("7.Exit");
            System.out.println("\nEnter your choice");
            int choice;
            choice = s.nextInt();
            s.nextLine();
            if(choice > 7)
            {
                System.out.println("Invalid input. Please enter the correct choice.");
                continue;
            }


            switch (choice)
            {
                case 1:
                    while(true){
                    System.out.println("\nEnter task title: ");
                    String title= s.nextLine().trim();
                    if(title.isEmpty())
                    {
                        System.out.println("Task title cannot be empty. Please enter a valid title");
                        continue;
                    }
                    boolean alreadyExists = manager.getAllTasks().stream().anyMatch(task -> task.getTitle().equalsIgnoreCase(title));
                    if(alreadyExists)
                    {
                        System.out.println("Task with this title is already exists. Please enter a unique title.");
                        continue;
                    }
                        manager.addTask(title);
                        System.out.println("Task added.");
                        break;
                    }
                    break;

                case 2:
                    List<Task> allTasks = manager.getAllTasks();
                    if(allTasks.isEmpty())
                    {
                        System.out.println("No tasks available.");
                    }
                    else
                    {
                        System.out.println("\n--- All Tasks ---");
                        for (Task t : allTasks) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter task ID to marks as completed");
                    int completeId = s.nextInt();
                    s.nextLine();
                    manager.markTaskCompleted(completeId);
                    System.out.println("Task marked as completed.");
                    break;

                case 4:
                    System.out.println("Enter task ID to delete: ");
                    int deleteId = s.nextInt();
                    s.nextLine();
                    manager.deleteTask(deleteId);
                    System.out.println("Task Deleted.");
                    break;

                case 5:
                    System.out.println("\n--- Completed Tasks ---");
                    for(Task t : manager.getCompletedTasks())
                    {
                        System.out.println(t);
                    }
                    break;

                case 6:
                    System.out.println("\n--- Incomplete Tasks ---");
                    for(Task t : manager.getIncompleteTasks())
                    {
                        if( t != null)
                        {
                            System.out.println(t);
                        }
                        else
                        {
                            System.out.println("Congratulations! You have completed your all tasks.");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Thank You for using the TO-DO App. ByeBye!");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            if( choice != 7)
            {
                System.out.println("\nDo you like to Continue or Exit ? (continue/exit): ");
                String input = s.nextLine();
                if(!input.equals("continue") && !input.equals("Continue") && !input.equals("CONTINUE") && !input.equals("C") && !input.equals("c"))
                {
                    System.out.println("Thank You for using the TO-DO App. GoodBye!");
                    keepRunning=false;
                }
            }
        }
        s.close();
    }
}
