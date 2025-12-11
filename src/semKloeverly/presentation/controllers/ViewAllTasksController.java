package semKloeverly.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.Tasks;
import semKloeverly.persistence.DataManager;
import semKloeverly.persistence.FileDataManager;
import semKloeverly.presentation.core.ViewManager;

public class ViewAllTasksController
{
  @FXML private TableColumn<Tasks, String> taskTypeViewAllTasks;

  @FXML private TableColumn<Tasks, String> descriptionViewAllTasks;

  @FXML private TableColumn<Tasks, Integer> assignedPointsViewAllTasks;

  @FXML private TableColumn<Tasks, String> statusViewAllTasks;

  @FXML private TableView<Tasks> viewAllTasksTableView;

  private DataManager dataManager;

  @FXML public void initialize()
  {
    dataManager = FileDataManager.getInstance();

    taskTypeViewAllTasks.setCellValueFactory(
        new PropertyValueFactory<>("type"));
    descriptionViewAllTasks.setCellValueFactory(
        new PropertyValueFactory<>("description"));
    assignedPointsViewAllTasks.setCellValueFactory(
        new PropertyValueFactory<>("points"));
    statusViewAllTasks.setCellValueFactory(
        new PropertyValueFactory<>("status"));

    loadTasks();

  }

  public void loadTasks()
  {
    viewAllTasksTableView.getItems().setAll(dataManager.getAllTasks());

  }

  public void cancelViewAllTasks()
  {
    ViewManager.showView("HomeView");
  }

  public void saveDataViewAllTasks()
  {
  }
}
