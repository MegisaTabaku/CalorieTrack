package inxhinierisofti;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodEntry {
    private LocalDateTime dateTime;
    private String foodName;
    private int calorieValue;
    private double price;


    public FoodEntry(LocalDateTime dateTime, String foodName, int calorieValue, double price) {
        this.dateTime = dateTime;
        this.foodName = foodName;
        this.calorieValue = calorieValue;
        this.price = price;
    }

    // Getter-a
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCalorieValue() {
        return calorieValue;
    }

    public double getPrice() {
        return price;
    }

    //Shtimi i hyrjeve
    public void addFoodEntry(FoodEntry entry, int userId) {
        String query = "INSERT INTO FoodEntries (date_time, food_name, calorie_value, price, user_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = SQLiteManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(entry.getDateTime()));
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

    // Metoda për të marrë të gjitha hyrjet ushqimore
    public List<FoodEntry> getAllFoodEntries(int userId) {
        List<FoodEntry> foodEntries = new ArrayList<>();
        String query = "SELECT * FROM FoodEntries WHERE user_id = ?";
        try (Connection connection = SQLiteManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                foodEntries.add(new FoodEntry(
                        rs.getTimestamp("date_time").toLocalDateTime(),
                        rs.getString("food_name"),
                        rs.getInt("calorie_value"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching food entries: " + e.getMessage());
        }
        return foodEntries;
    }
}
