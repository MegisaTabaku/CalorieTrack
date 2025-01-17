package inxhinierisofti;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccount {
    // Metoda per te krijuar acc te ri
    public boolean createAccount(String username, String password) {
        String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
        try (Connection connection = SQLiteManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true; // accounti u krijua me sukses
        } catch (SQLException e) {
            System.err.println("Error creating account: " + e.getMessage());
            return false; // krijimi i acc deshtoi
        }
    }

    // Metoda per te bere validate user login
    public boolean login(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (Connection connection = SQLiteManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Login i suksesshem
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
            return false; // Login deshtoi
            // }
}
}