package inxhinierisofti;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class DashboardController {

    @FXML
    private Button addFoodEntryButton;

    @FXML
    private Button viewFoodEntriesButton;

    @FXML
    private Button logoutButton;

    @FXML
    public void handleAddFoodEntry() {
        System.out.println("Add Food Entry clicked.");

        openScene("/inxhinierisofti/views/add_food_entry.fxml", "Add Food Entry");
    }

    @FXML
    public void handleViewFoodEntries() {
        System.out.println("View Food Entries clicked.");

        openScene("/inxhinierisofti/views/view_food_entries.fxml", "View Food Entries");
    }

    @FXML
    public void handleLogout() {
        System.out.println("Logout clicked.");

        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        openScene("/inxhinierisofti/views/login.fxml", "Login");
    }

    private void openScene(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUsername(String username) {
    }
}
