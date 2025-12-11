package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.GreenTasks;
import semKloeverly.domain.tasks.Tasks;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

import java.util.List;

public class GreenTasksController {


    public ComboBox<String> statusComboBox;
    @FXML
    private TextField pointField;
    @FXML
    private TextField descriptionTextfield;
    @FXML
    private ComboBox<Resident> assignResidentComboBox;

    private DataManager dataManager;

    @FXML
    public void initialize() {
        dataManager = FileDataManager.getInstance();

        List<Resident> allResidents = dataManager.getAllResidents();

        assignResidentComboBox.getItems().addAll(allResidents);
        statusComboBox.getItems().addAll("Taken", "Not Taken", "Assign", "Not Assign" );




    }

    public void saveButtonGreenTasks() {

        String description = descriptionTextfield.getText();
        Resident selectedResident = assignResidentComboBox.getValue();
        String selectedStatus = statusComboBox.getValue();

        try {
            int points = Integer.parseInt(pointField.getText());
            Tasks newGreenTask = new GreenTasks(selectedResident, "GreenTask", description, points, selectedStatus);

            newGreenTask.setStatus(selectedStatus);
            dataManager.addTask(newGreenTask);
            ViewManager.showView("GreenTasks");


        }
        catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Only numbers are acceptet as points. Try again\n " + e.getMessage());
            error.show();

        }

    }

    public void cancelButtonGreenTasks() {
        ViewManager.showView("Home");
    }
}
