import java.util.Scanner;

public class App {
    private static Project rootProject = new Project("Root Project");
    private static Project currentProject = rootProject;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Console-based To-Do Application!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Display list of incomplete items");
            System.out.println("2. Display list of completed items");
            System.out.println("3. Create a task");
            System.out.println("4. Create a project");
            System.out.println("5. Select items");
            System.out.println("6. Enter a project");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayIncompleteItems();
                    break;
                case 2:
                    displayCompletedItems();
                    break;
                case 3:
                    createTask(scanner);
                    break;
                case 4:
                    createProject(scanner);
                    break;
                case 5:
                    selectItems(scanner);
                    break;
                case 6:
                    enterProject(scanner);
                    break;
                case 7:
                    if (currentProject != rootProject) {
                        currentProject = currentProject.getParent();
                        System.out.println("Returning to parent project.");
                    } else {
                        System.out.println("Exiting the application...");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayIncompleteItems() {
        System.out.println("\nIncomplete Items:");
        currentProject.displayIncompleteItems(0);
    }

    private static void displayCompletedItems() {
        System.out.println("\nCompleted Items:");
        currentProject.displayCompletedItems(0);
    }

    private static void createTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        System.out.print("Enter priority (Low, Medium, High, None): ");
        String priority = scanner.nextLine();

        Task task = new Task(title, description, dueDate, priority);
        System.out.print("Save task? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            currentProject.addItem(task);
            System.out.println("Task created and saved successfully.");
        } else {
            System.out.println("Task creation discarded.");
        }
    }

    private static void createProject(Scanner scanner) {
        System.out.print("Enter project title: ");
        String title = scanner.nextLine();

        Project project = new Project(title);
        System.out.print("Save project? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            currentProject.addItem(project);
            project.setParent(currentProject);
            System.out.println("Project created and saved successfully.");
        } else {
            System.out.println("Project creation discarded.");
        }
    }

    private static void selectItems(Scanner scanner) {
        System.out.print("Enter the title of the item to select: ");
        String title = scanner.nextLine();
        Item item = currentProject.findItemByTitle(title);

        if (item != null) {
            System.out.println("Options:");
            System.out.println("1. Mark as Complete");
            System.out.println("2. Ignore");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    item.markAsComplete();
                    System.out.println("Item marked as complete.");
                    System.out.println("Keep as Completed or Delete Forever?");
                    System.out.println("1. Keep as Completed");
                    System.out.println("2. Delete Forever");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (subChoice == 2) {
                        item.deleteForever();
                        System.out.println("Item deleted forever.");
                    } else {
                        System.out.println("Item retained as completed.");
                    }
                    break;
                case 2:
                    System.out.println("Item ignored.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void enterProject(Scanner scanner) {
        System.out.print("Enter the title of the project to enter: ");
        String title = scanner.nextLine();
        Item item = currentProject.findItemByTitle(title);

        if (item instanceof Project) {
            currentProject = (Project) item;
            System.out.println("Entered project: " + title);
        } else {
            System.out.println("Project not found or is not a valid project.");
        }
    }
}
