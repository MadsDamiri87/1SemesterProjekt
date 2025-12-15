package semKloeverly.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import semKloeverly.domain.Resident;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

import java.util.Optional;

public class ViewResidentsController {

    public Button resetAllPointsID;
    @FXML
    private TableColumn<Resident, String> residentsName;

    @FXML
    private TableColumn<Resident, String> residentsAddress;

    @FXML
    private TableColumn<Resident, String> residentsNumber;

    @FXML
    private TableColumn<Resident, Integer> residentsPoints;

    @FXML
    private TableView<Resident> residentsViewTable;

    @FXML
    private TextField pointFieldId;
    private DataManager dataManager;

    @FXML
    public void initialize() {
        dataManager = FileDataManager.getInstance();

        residentsName.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        residentsAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        residentsNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        residentsPoints.setCellValueFactory(new PropertyValueFactory<>("points"));

        loadResidents();
    }

    public void loadResidents() {
        residentsViewTable.getItems().setAll(dataManager.getAllResidents());

    }

    public void onAddPointsButton() {
        Resident selectedResident = residentsViewTable.getSelectionModel().getSelectedItem();

        if (selectedResident == null) {
            return;
        }

        try {
            int addPoints = Integer.parseInt(pointFieldId.getText());
            selectedResident.setPoints(selectedResident.getPoints() + addPoints);
            dataManager.updateResident(selectedResident);
            ViewManager.showView("ViewResidents");

        }
        catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Only numbers are acceptet as points. Try again\n " + e.getMessage());
            error.show();

        }

    }

    public void onRemovePointsButton() {
        Resident selectedResident = residentsViewTable.getSelectionModel().getSelectedItem();

        if (selectedResident == null) {
            return;
        }

        try {
            int removePoints = Integer.parseInt(pointFieldId.getText());

            int resetPoints = selectedResident.getPoints() - removePoints;

            if (resetPoints < 0)
                resetPoints = 0;

            selectedResident.setPoints(resetPoints);

            dataManager.updateResident(selectedResident);

            ViewManager.showView("ViewResidents");

        }
        catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Only numbers are accepted as points. Try again\n " + e.getMessage());
            error.show();
        }
    }

    public void onEditResident() {

        Resident selectedResident = residentsViewTable.getSelectionModel().getSelectedItem();

        dataManager.seteditResident(selectedResident.getId());

        ViewManager.showView("EditResident");
    }

    public void ClickResident() {
    }

    public void onResetAllPoints() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning: You are about to reset all the Residents points");
        alert.setContentText("If you want to proceed please confirm ");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            for (Resident resident : residentsViewTable.getItems()) {
                resident.setPoints(0);
                dataManager.updateResident(resident);
            }
            loadResidents();
        }
    }
}


