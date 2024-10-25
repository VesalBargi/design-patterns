import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Cell> cells = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Console-based Spreadsheet!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Set a cell value");
            System.out.println("2. Create a formula (Add or Multiply)");
            System.out.println("3. View cell value");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    setCellValue(scanner);
                    break;
                case 2:
                    createFormula(scanner);
                    break;
                case 3:
                    viewCellValue(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Set a value in a cell
    private static void setCellValue(Scanner scanner) {
        System.out.print("Enter cell name (e.g., A1): ");
        String cellName = scanner.next();
        System.out.print("Enter a numeric value: ");
        double value = scanner.nextDouble();
        Cell cell = findCell(cellName);
        if (cell != null) {
            cell.setValue(value);
            System.out.println("Value update successfully.");
            System.out.print("Dependents updated: ");
            for (Cell dependent : cell.getObservers()) {
                System.out.print(dependent.getName() + " ");
            }
            System.out.println();
        } else {
            cell = new Cell(cellName);
            cells.add(cell);
            cell.setValue(value);
            System.out.println("Value set successfully.");
        }
        // DONE: Please also print name of dependant cells which are updated
        // automatically by this change (if there is any)
    }

    // Create a formula using a list of cells and an operation
    private static void createFormula(Scanner scanner) {
        System.out.print("Enter the name of the cell to store the formula (e.g., B1): ");
        String formulaCellName = scanner.next();
        Cell formulaCell = new Cell(formulaCellName);
        addCell(formulaCell);
        System.out.print("Enter the list of operand cells (e.g., A1,C2,B3,D1,D2): ");
        String[] operandNames = scanner.next().split(",");
        for (String operandName : operandNames) {
            Cell operand = findCell(operandName);
            if (operand != null) {
                formulaCell.addDependent(operand);
            } else {
                System.out.println("Cell " + operandName + " does not exist.");
                return;
            }
        }

        System.out.println("Choose an operation: ");
        System.out.println("1. Add");
        System.out.println("2. Multiply");
        System.out.println("3. Min");
        System.out.println("4. Max");
        System.out.println("5. Average");
        int operationChoice = scanner.nextInt();

        Formula strategy = null;
        switch (operationChoice) {
            case 1:
                strategy = new Add();
                break;
            case 2:
                strategy = new Multiply();
                break;
            case 3:
                strategy = new Min();
                break;
            case 4:
                strategy = new Max();
                break;
            case 5:
                strategy = new Average();
                break;
            default:
                System.out.println("Invalid operation choice.");
                return;
        }
        formulaCell.setFormula(strategy);
        System.out.println("Formula created successfully.");
    }

    // View the value of a cell
    private static void viewCellValue(Scanner scanner) {
        System.out.print("Enter cell name to view value (e.g., A1): ");
        String cellName = scanner.next();
        Cell cell = findCell(cellName);
        if (cell != null) {
            System.out.println("Value of " + cellName + ": " + cell.getValue());
        } else {
            System.out.println("Cell does not exist.");
        }
    }

    private static boolean addCell(Cell cell) {
        if (findCell(cell.getName()) == null) {
            cells.add(cell);
            return true;
        } else {
            return false;
        }
    }

    private static Cell findCell(String name) {
        for (Cell cell : cells) {
            if (cell.getName().equals(name)) {
                return cell;
            }
        }
        return null;
    }
}
