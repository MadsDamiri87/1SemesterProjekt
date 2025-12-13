package semKloeverly.presentation.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.CommunityTasks;
import semKloeverly.domain.tasks.Tasks;
import semKloeverly.persistence.DataManager;
import semKloeverly.presentation.core.ViewManager;
import semKloeverly.persistence.FileDataManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CommunityTasksController implements Initializable {

    @FXML
    private TextField pointsTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private ComboBox<Resident> residentDropDown;

    private DataManager dataManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataManager = FileDataManager.getInstance();
        List<Resident> residents = dataManager.getAllResidents();

        residentDropDown.getItems().clear();
        for (Resident resident : residents) {
            residentDropDown.getItems().add(resident);
        }
    }

    @FXML
    private void onSaveCommunityTask(ActionEvent event) {
        String description = descriptionTextField.getText();
        String pointsText = pointsTextField.getText();
        Resident selectedResident = residentDropDown.getValue();

        if (description == null || description.trim().isEmpty()) {
            showAlert("Error ", "Type in a description");
            return;
        }

        int points;
        try {
            points = Integer.parseInt(pointsText);
            if (points <= 0) {
                showAlert("Error ", "Point need to be bigger then 0");
                return;
            }
        }
        catch (NumberFormatException e) {
            showAlert("Error ", "Points needs to be a number");
            return;
        }

        if (selectedResident == null) {
            showAlert("Error", "Choose a resident ");
            return;
        }

        Tasks task = new CommunityTasks(selectedResident, "Community Task", description, points, "Assigned");


        dataManager.addTask(task);

        showAlert("Succes", "Community Task assigned to " + selectedResident.getFullname());

        clearFields();
    }

    @FXML
    private void onCancelCommunityTask() {
        ViewManager.showView("HomeView");
    }

    private void clearFields() {
        descriptionTextField.clear();
        pointsTextField.clear();
        residentDropDown.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}