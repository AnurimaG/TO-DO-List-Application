# TO-DO-List-Application 

## Overview
-----------
A simple console-based *To-Do List Application* built using Java. 
This application allows users to add, view, update, delete, and manage tasks efficiently. Tasks are stored persistently using file handling to ensure data is not lost between sessions.
This project is implemented as a console-based application and includes features such as task creation, viewing, updating (marking as completed), deletion, and filtering by completion status.

## Features
-----------
- **Add Task**: Users can add new tasks with unique titles.
- **Prevent Duplicates**: The system checks for duplicate titles and prompts users accordingly.
- **View All Tasks**: Displays all tasks with their ID, title, and status.
- **Mark Task as Completed**: Allows users to update a task’s status to "completed".
- **Delete Task**: Users can remove tasks by entering their ID.
- **View Completed Tasks**: Shows only the tasks marked as completed.
- **View Incomplete Tasks**: Shows only the tasks that are still pending.
- **Input Validation**:
                      - Prevents empty titles.
                      - Displays user-friendly messages for invalid input.
                      - Prompts users again if input is not correct.

## Technologies Used
--------------------
- **Java**
- **File Handling (for task persistence)**
- **Object-Oriented Programming Concepts (Encapsulation, Abstraction)**
- **Java Collections (List, ArrayList)**
- **Console-based Input(Scanner)**

## Project Structure

To_Do_List/ ├── Task.java ├── TaskManager.java ├── FileManager.java └── ToDoApp.java

## How to Run
1. Clone the repository:
   git clone https://github.com/your-username/To_Do_List.git

2. Open the project in any Java IDE (like IntelliJ, Eclipse).

3. Run ToDoApp.java.

## File Handling

All tasks are saved in a file so that even after exiting the program, data remains available during the next run. The FileManager class handles reading and writing data to a file.

**Sample Output**

~~~~TO-DO LIST MENU~~~~
1. Add Task
2. View All Tasks
3. Mark Task as Completed
4. Delete Task
5. View Completed Tasks
6. View Incomplete Tasks
7. Exit
Enter your choice: 1
Enter task title: Complete assignment
Task added.

**License**

This project is open source and available under the MIT License.

Author

Anurima Goswami
