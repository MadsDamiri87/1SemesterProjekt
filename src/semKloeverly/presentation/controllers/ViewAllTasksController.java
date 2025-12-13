package semKloeverly.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import semKloeverly.domain.tasks.Tasks;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

import java.util.Optional;

public class ViewAllTasksController {

    @FXML
    private TableColumn<Tasks, String> taskTypeViewAllTasks;

    @FXML
    private TableColumn<Tasks, String> descriptionViewAllTasks;

    @FXML
    private TableColumn<Tasks, Integer> assignedPointsViewAllTasks;

    @FXML
    private TableColumn<Tasks, String> statusViewAllTasks;

    @FXML
    private TableView<Tasks> viewAllTasksTableView;

    private DataManager dataManager;

    @FXML
    public void initialize() {
        dataManager = FileDataManager.getInstance();

        taskTypeViewAllTasks.setCellValueFactory(new PropertyValueFactory<>("type"));
        descriptionViewAllTasks.setCellValueFactory(new PropertyValueFactory<>("description"));
        assignedPointsViewAllTasks.setCellValueFactory(new PropertyValueFactory<>("points"));
        statusViewAllTasks.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadTasks();

    }

    public void loadTasks() {
        viewAllTasksTableView.getItems().setAll(dataManager.getAllTasks());

    }

    public void cancelViewAllTasks() {
        ViewManager.showView("HomeView");
    }

    public void saveDataViewAllTasks() {
    }

    public void onResetAllPoints() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning: You are about to reset all the Residents Community points");
        alert.setContentText("If you want to proceed please confirm ");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            for (Tasks tasks : viewAllTasksTableView.getItems()) {
                tasks.setPoints(0);
                dataManager.updateTasks(tasks);
            }
        }
        loadTasks();
    }
}

