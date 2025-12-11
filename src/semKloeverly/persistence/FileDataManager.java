package semKloeverly.persistence;

import javafx.scene.control.Alert;
import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.GreenTasks;
import semKloeverly.domain.tasks.Tasks;

import java.io.*;
import java.util.List;

public class FileDataManager implements DataManager {

    private static DataContainer data = new DataContainer();
    private static FileDataManager instance;

    private FileDataManager() {
    }

    public static FileDataManager getInstance() {
        if (instance == null) {
            instance = new FileDataManager();
        }
        return instance;
    }


    @Override
    public void addResident(Resident resident) {

        data = load();

        int maxID = 0;

        for (Resident person : data.getResidents()) {
            if (person.getId() > maxID) {
                maxID = person.getId();
            }
        }

        resident.setId(maxID + 1);

        data.getResidents().add(resident);

        saveResidentFile(data);

    }




    @Override
    public void addTask(Tasks tasks){
        data = load();
        data.getTasks().add(tasks);
        saveResidentFile(data);
    }

    public void saveResidentFile(DataContainer saveData) {

        try (ObjectOutputStream saveResidentsToFile = new ObjectOutputStream(new FileOutputStream("save.bin"))) {
            saveResidentsToFile.writeObject(saveData);

        }

        catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error - Data not saved!");
            alert.show();
        }
    }

    public DataContainer load() {

        File file = new File("save.bin");
        if (!file.exists()) {
            return new DataContainer();
        }

        try (ObjectInputStream loadResidentsToFile = new ObjectInputStream(new FileInputStream("save.bin"))) {
            return (DataContainer) loadResidentsToFile.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error - Data not loaded!");
            alert.show();
            return new DataContainer();

        }

    }

    @Override
    public List<Resident> getAllResidents() {
        data = load();
        return data.getResidents();

    }

    @Override
    public List<Tasks> getAllTasks() {
        data = load();
        return data.getTasks();
    }


    @Override
    public void deleteResident(Resident deleteResident) {
        data = load();
        data.getResidents().removeIf(person -> person.getId() == deleteResident.getId());
        saveResidentFile(data);
    }


    @Override
    public void updateResident(Resident updatedResident) {
        data = load();
        for (int i = 0; i < data.getResidents().size(); i++) {
            Resident person = data.getResidents().get(i);
            if (person.getId() == updatedResident.getId()) {
                data.getResidents().set(i, updatedResident);
                break;
            }
        }
        saveResidentFile(data);
    }

  //    @Override
  //    public void addGreenTask(GreenTasks greenTask) {
  //        data = load();
  //        data.getTasks().add(greenTask);
  //        saveResidentFile(data);
  //
  //    }
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
