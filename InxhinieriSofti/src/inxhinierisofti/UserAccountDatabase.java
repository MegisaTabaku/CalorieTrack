package inxhinierisofti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAccountDatabase {
    public boolean createAccount(String username, String password) {
        String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
        try (Connection connection = SQLiteManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error creating account: " + e.getMessage());
            return false;
        }
}
}