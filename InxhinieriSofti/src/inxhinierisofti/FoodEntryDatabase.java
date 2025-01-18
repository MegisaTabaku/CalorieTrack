package inxhinierisofti;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching food entries: " + e.getMessage());
        }
        return foodEntries;
    }
}