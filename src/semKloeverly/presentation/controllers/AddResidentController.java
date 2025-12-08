package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import semKloeverly.domain.Resident;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class AddResidentController
{

  @FXML private TextField startingPoints;

  @FXML private TextField nameTextFieldResident;

  @FXML private TextField surNameTextFieldResident;

  @FXML private TextField addressTextFieldResident;

  @FXML private TextField phoneNumberTextFieldResident;

  private DataManager dataManager;

  @FXML public void initialize()
  {
    dataManager = FileDataManager.getInstance();
  }

  public void saveNewResidentButton()
  {
    String name = nameTextFieldResident.getText();
    String surName = surNameTextFieldResident.getText();
    String address = addressTextFieldResident.getText();
    String phoneNumber = phoneNumberTextFieldResident.getText();

    try
    {
      int points = Integer.parseInt(startingPoints.getText());
      Resident resident = new Resident(points, name, surName, address,
          phoneNumber);
      dataManager.addResident(resident);
      ViewManager.showView("AddResident");


    }
    catch (NumberFormatException e)
    {
      Alert error = new Alert(Alert.AlertType.INFORMATION,
          "Only numbers are acceptet as points. Try again\n " + e.getMessage());
      error.show();

    }

  }

  public void cancelNewResident()
  {
    ViewManager.showView("HomeView");
  }


  public void nameFieldAddResident()
  {
  }

  public void addressFieldAddResident()
  {
  }

  public void phoneFieldAddResident()
  {
  }

}
