package semKloeverly.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import semKloeverly.domain.Resident;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

public class AddResidentController {

    @FXML
    private TextField startingPoints;

    @FXML
    private TextField nameTextFieldResident;

    @FXML
    private TextField surNameTextFieldResident;

    @FXML
    private TextField addressTextFieldResident;

    @FXML
    private TextField phoneNumberTextFieldResident;

    private DataManager dataManager;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        dataManager = FileDataManager.getInstance();
        messageLabel.setText("Status: Ready to add a resident");
    }

    public void onSaveNewResidentButton() {
        String name = nameTextFieldResident.getText();
        String surName = surNameTextFieldResident.getText();
        String address = addressTextFieldResident.getText();
        String phoneNumber = phoneNumberTextFieldResident.getText();

        try {
            int points = Integer.parseInt(startingPoints.getText());
            Resident resident = new Resident(points, name, surName, address, phoneNumber);
            dataManager.addResident(resident);
            messageLabel.setText("Status: Resident " + name + " " + surName + " was added to the system");

        }
        catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Only numbers are acceptet as points. Try again\n " + e.getMessage());
            error.show();

        }
        nameTextFieldResident.clear();
        surNameTextFieldResident.clear();
        addressTextFieldResident.clear();
        phoneNumberTextFieldResident.clear();
        startingPoints.clear();
    }

    public void onCancelNewResidentButton() {
        ViewManager.showView("HomeView");
    }

}
