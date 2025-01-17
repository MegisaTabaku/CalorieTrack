
import java.util.List;

public class CalorieManager {
    private static final int DAILY_CALORIE_THRESHOLD = 2500;

    // Method to check if the daily calorie limit has been exceeded
    public static boolean isCalorieLimitExceeded(List<FoodEntry> foodEntries) {
        int totalCalories = foodEntries.stream().mapToInt(entry -> entry.getCalorieValue()).sum(); // Updated to use getter
        return totalCalories > DAILY_CALORIE_THRESHOLD;
    }

    // Method to get the total calories consumed for the day
    public static int getTotalCalories(List<FoodEntry> foodEntries) {
        return foodEntries.stream().mapToInt(entry -> entry.getCalorieValue()).sum(); // Updated to use getter
    }
}
