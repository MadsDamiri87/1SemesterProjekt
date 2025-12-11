package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.GreenTasks;
import semKloeverly.domain.tasks.Tasks;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

import java.util.List;

public class GreenTasksController
{

  @FXML private ComboBox<String> statusComboBox;
  @FXML private TextField pointField;
  @FXML private TextField descriptionTextfield;
  @FXML private ComboBox<Resident> assignResidentComboBox;
  @FXML private Label messageLabel;
  private DataManager dataManager;

  @FXML public void initialize()
  {
    dataManager = FileDataManager.getInstance();
    messageLabel.setText("Status: Ready to add a Green Task");

    List<Resident> allResidents = dataManager.getAllResidents();

    assignResidentComboBox.getItems().addAll(allResidents);
    statusComboBox.getItems()
        .addAll("Taken", "Not Taken", "Assign", "Not Assign");

  }

  public void onSaveTaskButton()
  {

    String description = descriptionTextfield.getText();
    Resident selectedResident = assignResidentComboBox.getValue();
    String selectedStatus = statusComboBox.getValue();

    try
    {
      int points = Integer.parseInt(pointField.getText());
      Tasks newGreenTask = new GreenTasks(selectedResident, "Green Task",
          description, points, selectedStatus);

      newGreenTask.setStatus(selectedStatus);
      dataManager.addTask(newGreenTask);

      messageLabel.setText("Status: Green Task " + description + " added");

    }
    catch (NumberFormatException e)
    {
      Alert error = new Alert(Alert.AlertType.INFORMATION,
          "Only numbers are accepted as points. Try again\n " + e.getMessage());
      error.show();

    }

  }

  public void onCancelTaskButton()
  {
    ViewManager.showView("HomeView");
  }
}
