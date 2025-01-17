package inxhinierisofti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteManager {

    private static final String DB_URL = "jdbc:sqlite:calories_tracker.db";

    public static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            // Krijo tabelën Users
            String createUsersTable = """
                CREATE TABLE IF NOT EXISTS Users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL
                );
            """;
            statement.execute(createUsersTable);

            // Krijo tabelën FoodEntries
            String createFoodEntriesTable = """
                CREATE TABLE IF NOT EXISTS FoodEntries (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    date_time TEXT NOT NULL,
                    food_name TEXT NOT NULL,
                    calorie_value INTEGER NOT NULL,
                    price REAL NOT NULL,
                    user_id INTEGER NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES Users(id)
                );
            """;
            statement.execute(createFoodEntriesTable);

            // Krijo tabelën Expenditures
            String createExpendituresTable = """
                CREATE TABLE IF NOT EXISTS Expenditures (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    user_id INTEGER NOT NULL,
                    amount REAL NOT NULL,
                    date TEXT NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES Users(id)
                );
            """;
            statement.execute(createExpendituresTable);

            System.out.println("Database initialized successfully!");
        } catch (SQLException e) {
            System.err.println("Error initializing the database: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}

}
