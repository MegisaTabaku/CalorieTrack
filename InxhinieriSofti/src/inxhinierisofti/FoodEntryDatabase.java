
package inxhinierisofti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FoodEntryDatabase {

    public List<FoodEntry> getAllFoodEntries() {
        List<FoodEntry> foodEntries = new ArrayList<>();
        String query = "SELECT * FROM FoodEntries";

        try (Connection connection = SQLiteManager.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                foodEntries.add(new FoodEntry(
                        rs.getTimestamp("date_time").toLocalDateTime(),
                        rs.getString("food_name"),
                        rs.getInt("calorie_value"),
                        rs.getDouble("price")



    public void addFoodEntry(FoodEntry entry, int userId) {
        String query = "INSERT INTO FoodEntries (date_time, food_name, calorie_value, price, user_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLiteManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, entry.getDateTime().toString());
            stmt.setString(2, entry.getFoodName());
            stmt.setInt(3, entry.getCalorieValue());
            stmt.setDouble(4, entry.getPrice());
            stmt.setInt(5, userId);
            stmt.executeUpdate();
            System.out.println("Food entry added successfully!");
        } catch (SQLException e) {
            System.err.println("Error adding food entry: " + e.getMessage());
        }
    }


    public List<FoodEntry> getAllFoodEntries(int userId) {
        List<FoodEntry> foodEntries = new ArrayList<>();
        String query = "SELECT * FROM FoodEntries WHERE user_id = ?";
        try (Connection conn = SQLiteManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching food entries: " + e.getMessage());
        }
        return foodEntries;
    }


    public int getCalorieValue() {
        // TODO Auto-generated method stub
        return 0;
    }

}
