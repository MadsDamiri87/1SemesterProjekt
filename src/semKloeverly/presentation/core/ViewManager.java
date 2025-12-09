package semKloeverly.presentation.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import semKloeverly.domain.Resident;

import java.io.IOException;

public class ViewManager
{

  private static AnchorPane centerPane;
  private static Stage stage;
  private static Resident editResident;

  public static void setStage(Stage primaryStage)
  {
    stage = primaryStage;
  }

  public static void showView(String viewName)
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(
          ViewManager.class.getResource("/fxml/" + viewName + ".fxml"));

      Parent root = loader.load();
      centerPane.getChildren().setAll(root);

    }
    catch (IOException e)
    {
      Alert error = new Alert(Alert.AlertType.ERROR,
          "Cannot find view: " + viewName);
      error.show();
    }

  }

  public static void setCenterPane(AnchorPane pane)
  {
    centerPane = pane;
  }


  public static void setEditResident(Resident resident)
  {
    editResident = resident;
  }

  public static Resident getEditResident()
  {
    return editResident;
  }
}
