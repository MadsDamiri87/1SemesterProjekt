package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import semKloeverly.domain.Resident;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

public class EditResidentController
{

  @FXML public TextField pointBox;

  @FXML private TextField startingPoints;

  @FXML private TextField nameTextFieldResident;

  @FXML private TextField surNameTextFieldResident;

  @FXML private TextField addressTextFieldResident;

  @FXML private TextField phoneNumberTextFieldResident;

  private DataManager dataManager;

  private Resident editResident;

  @FXML public void initialize()
  {
    dataManager = FileDataManager.getInstance();

    editResident = ViewManager.getEditResident();

    if (editResident != null)
    {
      startingPoints.setText(String.valueOf(editResident.getPoints()));
      nameTextFieldResident.setText(editResident.getName());
      surNameTextFieldResident.setText(editResident.getSurname());
      addressTextFieldResident.setText(editResident.getAddress());
      phoneNumberTextFieldResident.setText(editResident.getPhoneNumber());
    }
  }

  public void onDeleteResidentButton(ActionEvent actionEvent)
  {
    if (editResident == null)
    {
      return;
    }

    dataManager.deleteResident(editResident);

    ViewManager.showView("ViewResidents");

  }

  public void onSaveResidentButton(ActionEvent actionEvent)
  {
    if (editResident == null)
    {
      return;
    }

    try
    {

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
    catch (NumberFormatException e)
    {
      Alert error = new Alert(Alert.AlertType.INFORMATION,
          "Only numbers are accepted as points. Try again\n " + e.getMessage());
      error.show();

    }

  }

  public void onCancelResidentButton(ActionEvent actionEvent)
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


