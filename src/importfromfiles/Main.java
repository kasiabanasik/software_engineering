package importfromfiles;

import importfromfiles.service.Initializer;

import java.util.Scanner;

public class Main {

    private static ConsoleManager consoleManager = new ConsoleManager();
    private static Scanner scanner = new Scanner(System.in);
    private static DisplayManager displayManager = new DisplayManager();
    private static Initializer initializer = new Initializer();

    public static void main(String[] args) {
        initializer.initializeProductsFromFile();
        initializer.initializePricesFromFile();
        initializer.initializeStocksFromFile();

        while(true) {
            displayMenu();
        }
    }

    private static void displayMenu() {
        displayManager.displayMenu();
        int action = consoleManager.getAction();
        consoleManager.redirectAction(action);

        System.out.println("Wciśnij 9 by wrócić do menu");
        int userAction = Integer.parseInt(scanner.next());
        if (userAction == 9) {
            displayMenu();
        }
    }
}
