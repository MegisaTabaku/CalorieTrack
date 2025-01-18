package CombinedCaloriesApp;

import CombinedCaloriesApp.database.SQLiteManager;
import CombinedCaloriesApp.database.UserAccountDatabase;

import java.util.Scanner;

public class MainCompleteFinalUpdated {
    public static void main(String[] args) {
        SQLiteManager.initializeDatabase();
        Scanner scanner = new Scanner(System.in);
        UserAccountDatabase userAccountDb = new UserAccountDatabase();

        System.out.println("Welcome to the Calories Tracker App!");

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    if (userAccountDb.createAccount(username, password)) {
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Failed to create account. Username may already exist.");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();

                    if (userAccountDb.login(username, password)) {
                        System.out.println("Login successful! Welcome " + username);
                        userDashboard(scanner, username);
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void userDashboard(Scanner scanner, String username) {
        System.out.println("Welcome to your dashboard, " + username + "!");
        System.out.println("Dashboard functionality will be implemented in future steps.");
    }
}
