package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import semKloeverly.persistence.DataManager;

public class CommunityTasksController {

  @FXML private TextField descriptionTextField;
  @FXML private TextField pointField;
  @FXML private ComboBox assignResidentComboBox;
  @FXML private ComboBox statusComboBox;

  private DataManager dataManager;

  @FXML public void initialize()
  {
  }

  public void onSaveTaskButton(ActionEvent actionEvent)
  {
  }

  public void onCancelTaskButton(ActionEvent actionEvent)
  {
  }
}
