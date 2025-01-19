package inxhinierisofti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountDatabase { //Krijon nje llogari te re perdoruesi duke shtuar te dhenat ne bazen e te dhenave
    public boolean createAccount(String username, String password) { //Query per te shtuar nje perdorues te ri ne tabelen "Users"
        String query = "INSERT INTO Users (username, password) VALUES (?, ?)"; //Krijojme nje lidhje me bazen e te dhenave dhe pergatisim deklaraten
        try (Connection connection = SQLiteManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username); //Vendosim vlerat e "username" dhe "password" ne query
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) { //Trajtojme gabimet qe ndodhin gjate ekzekutimit te query-t
            System.err.println("Error creating account: " + e.getMessage());
            return false;
        }
    }

    public boolean login(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?"; //Query per te verifikuar kredencialet ne tabelen "Users"
        try (Connection connection = SQLiteManager.getConnection(); // Krijojme nje lidhje data base dhe pergatisim deklaraten
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);   // Vendosim vlerat e "username" dhe "password" ne query
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
            return false;
        }
}
}