package semKloeverly.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import semKloeverly.domain.Resident;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

public class ViewResidentsController
{

  @FXML private TableColumn<Resident, String> residentsName;

  @FXML private TableColumn<Resident, String> residentsAddress;

  @FXML private TableColumn<Resident, String> residentsNumber;

  @FXML private TableColumn<Resident, Integer> residentsPoints;

  @FXML private TableView<Resident> residentsViewTable;

  @FXML private TextField pointFieldId;
  private DataManager dataManager;

  @FXML public void initialize()
  {
    dataManager = FileDataManager.getInstance();

    residentsName.setCellValueFactory(new PropertyValueFactory<>("fullname"));
    residentsAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    residentsNumber.setCellValueFactory(
        new PropertyValueFactory<>("phoneNumber"));
    residentsPoints.setCellValueFactory(new PropertyValueFactory<>("points"));

    loadResidents();
  }

  public void loadResidents()
  {
    residentsViewTable.getItems().setAll(dataManager.getAllResidents());

  }

  public void onAddPointsButton()
  {
    Resident selectedResident = residentsViewTable.getSelectionModel()
        .getSelectedItem();

    if (selectedResident == null)
    {
      return;
    }

    try
    {
      int addPoints = Integer.parseInt(pointFieldId.getText());
      selectedResident.setPoints(selectedResident.getPoints() + addPoints);
      dataManager.updateResident(selectedResident);
      ViewManager.showView("ViewResidents");

    }
    catch (NumberFormatException e)
    {
      Alert error = new Alert(Alert.AlertType.INFORMATION,
          "Only numbers are acceptet as points. Try again\n " + e.getMessage());
      error.show();

    }

  }

  public void onRemovePointsButton()
  {
    Resident selectedResident = residentsViewTable.getSelectionModel()
        .getSelectedItem();

    if (selectedResident == null)
    {
      return;
    }

    try
    {
      int removePoints = Integer.parseInt(pointFieldId.getText());

      int resetPoints = selectedResident.getPoints() - removePoints;

      if (resetPoints < 0)
        resetPoints = 0;

      selectedResident.setPoints(resetPoints);

      dataManager.updateResident(selectedResident);

      ViewManager.showView("ViewResidents");

    }
    catch (NumberFormatException e)
    {
      Alert error = new Alert(Alert.AlertType.INFORMATION,
          "Only numbers are acceptet as points. Try again\n " + e.getMessage());
      error.show();
    }
  }

  public void onEditResident()
  {

    Resident selectedResident = residentsViewTable.getSelectionModel()
        .getSelectedItem();

    ViewManager.setEditResident(selectedResident);

    ViewManager.showView("EditResident");

  }

}


