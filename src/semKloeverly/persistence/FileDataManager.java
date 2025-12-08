package semKloeverly.persistence;

import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import semKloeverly.domain.Resident;
//import semKloeverly.domain.tasks.CommunityTasks;
//import semKloeverly.domain.tasks.GreenTasks;
//import semKloeverly.domain.tasks.TradeTasks;

import java.io.*;
import java.util.List;

public class FileDataManager implements DataManager
{

  private static DataContainer data = new DataContainer();
  private static FileDataManager instance;


  public static FileDataManager getInstance()
  {
    if (instance == null)
    {
      instance = new FileDataManager();
    }
    return instance;
  }


  @Override public void addResident(Resident resident)
  {

    data = load();
    data.getResidents().add(resident);

    saveResidentFile(data);

  }

  public void saveResidentFile(DataContainer saveData)
  {

    try (ObjectOutputStream saveResidentsToFile = new ObjectOutputStream(
        new FileOutputStream("save.bin")))
    {
      saveResidentsToFile.writeObject(saveData);

    }

    catch (IOException e)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR, "Error - Data not saved!");
      alert.show();
    }
  }

  public DataContainer load()
  {

    File file = new File("save.bin");
    if (!file.exists())

    {
      return new DataContainer();
    }
    try (ObjectInputStream loadResidentsToFile = new ObjectInputStream(
        new FileInputStream("save.bin")))
    {
      return (DataContainer) loadResidentsToFile.readObject();
    }
    catch (IOException | ClassNotFoundException e)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR,
          "Error - Data not loaded!");
      alert.show();
      return new DataContainer();

    }

  }

  @Override public List<Resident> getAllResidents()
  {
    data=load();
    return data.getResidents();

  }

  //    @Override
  //    public void addTask(Task task) {
  //
  //    }
  //
  //    @Override
  //    public List<Task> getAllTasks() {
  //        return List.of();
  //    }
  //
  //    @Override
  //    public void addGreenTask(GreenTasks greenTask) {
  //
  //    }
  //
  //    @Override
  //    public List<GreenTasks> getAllGreenTasks() {
  //        return List.of();
  //    }
  //
  //    @Override
  //    public void addCommunityTasks(CommunityTasks communityTask) {
  //
  //    }
  //
  //    @Override
  //    public List<CommunityTasks> getAllCommunityTasks() {
  //        return List.of();
  //    }
  //
  //    @Override
  //    public void addTradeTasks(TradeTasks tradeTask) {
  //
  //    }
  //
  //    @Override
  //    public List<TradeTasks> getAllTradeTasks() {
  //        return List.of();
  //    }
  //

}
