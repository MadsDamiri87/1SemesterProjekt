package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import semKloeverly.domain.Resident;
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


    public void nameFieldAddResident() {
    }

    public void addressFieldAddResident() {
    }

    public void phoneFieldAddResident() {
    }

    public void saveNewResidentButton() {
        String name = nameTextFieldResident.getText();
        String surName = surNameTextFieldResident.getText();
        String address = addressTextFieldResident.getText();
        String phoneNumber = phoneNumberTextFieldResident.getText();

        try {
            int points = Integer.parseInt(startingPoints.getText());
            Resident resident = new Resident(points, name, surName, address, phoneNumber);
            FileDataManager.getInstance().addResident(resident);

//            OutputStream saveFile =

        }
        catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Only numbers are acceptet as points. Try again\n " + e.getMessage());
            error.show();
        }

    }


    public void surNameFieldAddResident() {
    }

    public void cancelNewResident() {
        ViewManager.showView("HomeView");
    }


}
