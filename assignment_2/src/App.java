import java.util.Scanner;

public class App {
    private static Coffee coffee = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Coffee Shop!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Select a Base Coffee");
            System.out.println("2. Add Customizable Add-ons");
            System.out.println("3. View Final Order");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    selectBaseCoffee(scanner);
                    break;
                case 2:
                    addCustomizableAddons(scanner);
                    break;
                case 3:
                    viewFinalOrder(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewFinalOrder(Scanner scanner) {
        if (coffee == null) {
            System.out.println("No order placed yet.");
        } else {
            System.out.println("Your final order: " + coffee.getDescription());
            System.out.println("Total cost: $" + coffee.getCost());
        }
    }

    private static void addCustomizableAddons(Scanner scanner) {
        System.out.println("\nChoose an Add-on:");
        System.out.println("1. Milk");
        System.out.println("2. Whipped Cream");
        System.out.println("3. Vanilla Syrup");
        System.out.println("4. Extra Espresso Shot");
        int addonChoice = scanner.nextInt();
        switch (addonChoice) {
            case 1:
                coffee = new Milk(coffee);
                System.out.println("Added Milk.");
                break;
            case 2:
                coffee = new WhippedCream(coffee);
                break;
            case 3:
                coffee = new VanillaSyrup(coffee);
                break;
            case 4:
                coffee = new ExtraEspressoShot(coffee);
                break;
            default:
                System.out.println("Invalid add-on choice.");
                return;
        }
        System.out.println("Added: " + coffee.getDescription());
    }

    private static void selectBaseCoffee(Scanner scanner) {
        System.out.println("\nChoose a Base Coffee:");
        System.out.println("1. Espresso");
        System.out.println("2. Americano");
        System.out.println("3. Latte");
        int coffeeChoice = scanner.nextInt();
        CoffeeFactory factory = null;
        switch (coffeeChoice) {
            case 1:
                factory = new EspressoFactory();
                break;
            case 2:
                factory = new AmericanoFactory();
                break;
            case 3:
                factory = new LatteFactory();
                break;
            default:
                System.out.println("Invalid coffee choice.");
                return;
        }
        coffee = factory.createCoffee();
        System.out.println("You selected: " + coffee.getDescription());
    }
}
