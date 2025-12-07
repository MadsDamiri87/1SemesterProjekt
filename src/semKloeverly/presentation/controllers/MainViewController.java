package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import semKloeverly.presentation.core.ViewManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private AnchorPane centerView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewManager.setCenterPane(centerView);
    }


    @FXML
    public void onViewResidentsMainMenu() throws IOException {
        ViewManager.showView("ViewResidents");

    }

    public void onAddResidentMainMenu() {
        ViewManager.showView("AddResident");
    }

    public void onCommunityTasksMainMenu() {
        ViewManager.showView("CommunityTasks");
    }

    public void onGreenTasksMainMenu() {
        ViewManager.showView("GreenTasks");
    }

    public void onTradeTasksMainMenu() {
        ViewManager.showView("TradeTasks");
    }

    public void onViewAllTasksMainMenu() {
        ViewManager.showView("ViewAllTasks");
    }

    public void onViewPointSystemMainMenu() {
        ViewManager.showView("ViewPointSystem");
    }

}
