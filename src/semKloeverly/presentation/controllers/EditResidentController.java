package semKloeverly.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import semKloeverly.domain.Resident;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

public class EditResidentController {

    @FXML
    private ComboBox setStatusComboBox;
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
    private Resident editResident;

    @FXML
    public void initialize() {
        dataManager = FileDataManager.getInstance();

      editResident = dataManager.getEditResident();

        setStatusComboBox.getItems().addAll("Taken", "Not Taken", "Assign", "Not Assign");

        if (editResident != null) {
            startingPoints.setText(String.valueOf(editResident.getPoints()));
            nameTextFieldResident.setText(editResident.getName());
            surNameTextFieldResident.setText(editResident.getSurname());
            addressTextFieldResident.setText(editResident.getAddress());
            phoneNumberTextFieldResident.setText(editResident.getPhoneNumber());
        }
    }

    public void onDeleteResidentButton() {
        if (editResident == null) {
            return;
        }

        dataManager.deleteResident(editResident);

        ViewManager.showView("ViewResidents");

    }

    public void onSaveResidentButton() {
        if (editResident == null) {
            return;
        }

        try {

            String name = nameTextFieldResident.getText();
            String surName = surNameTextFieldResident.getText();
            String address = addressTextFieldResident.getText();
            String phoneNumber = phoneNumberTextFieldResident.getText();
            int points = Integer.parseInt(startingPoints.getText());

            editResident.setPoints(points);
            editResident.setName(name);
            editResident.setSurname(surName);
            editResident.setAddress(address);
            editResident.setPhoneNumber(phoneNumber);

            dataManager.updateResident(editResident);
            ViewManager.showView("ViewResidents");

        }
        catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Only numbers are accepted as points. Try again\n " + e.getMessage());
            error.show();

        }

    }

    public void onCancelResidentButton() {
        ViewManager.showView("HomeView");
    }
}



