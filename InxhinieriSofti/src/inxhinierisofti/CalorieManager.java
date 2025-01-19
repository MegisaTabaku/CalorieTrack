package inxhinierisofti;

import java.util.List;

public class CalorieManager {
    private static final int DAILY_CALORIE_THRESHOLD = 2500;

    public static boolean isCalorieLimitExceeded(List<FoodEntry> foodEntries) {
        int totalCalories = foodEntries.stream().mapToInt(entry -> entry.getCalorieValue()).sum();
        return totalCalories > DAILY_CALORIE_THRESHOLD;
    }


    public static int getTotalCalories(List<FoodEntry> foodEntries) {
        return foodEntries.stream().mapToInt(entry -> entry.getCalorieValue()).sum();
    }
}
