package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import semKloeverly.persistence.DataManager;

public class TradeTasksController {
    @FXML
    private ComboBox offeredByResident;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField pointField;
    @FXML
    private ComboBox takenByResident;
    @FXML
    private DatePicker deadlineDate;

    private DataManager dataManager;

    @FXML
    public void initialize() {
    }

    public void onSaveTaskButton(ActionEvent actionEvent) {
    }

    public void onCancelTaskButton(ActionEvent actionEvent) {
    }
}
