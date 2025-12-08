package semKloeverly.presentation.controllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import semKloeverly.domain.Resident;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;

public class ViewResientsController {

    @FXML
    private TableColumn<Resident, String> residentName ;

    @FXML
    private TableColumn <Resident, String> residentsAddress;

    @FXML
    private TableColumn <Resident, String> residentsNumber;

    @FXML
    private TableColumn <Resident, Integer> residentsPoints;

    @FXML
    private TextField pointFieldId;

    @FXML
    private TableView <Resident> residentViewTable;

    private DataManager dataManager;

    @FXML
    public void initialize()
  {
   dataManager = FileDataManager.getInstance();

    residentName.setCellValueFactory(new PropertyValueFactory<>("fullname"));
    residentsAddress.setCellValueFactory(
        new PropertyValueFactory<>("address"));
    residentsNumber.setCellValueFactory(
        new PropertyValueFactory<>("phoneNumber"));
    residentsPoints.setCellValueFactory(new PropertyValueFactory<>("points"));


    loadResidents();
  }

  public void loadResidents()
  {
    residentViewTable.getItems().setAll(dataManager.getAllResidents());

  }
    public void onEditResident() {
        
    }

    public void pointInputField() {
    }

    public void onAddPointsButton() {
    }
    public void onRemovePointsButton() {
    }

  public void onResidentClicked(MouseEvent mouseEvent)
  {
  }
}
