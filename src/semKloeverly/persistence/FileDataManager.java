package semKloeverly.persistence;

import javafx.concurrent.Task;
import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.CommunityTasks;
import semKloeverly.domain.tasks.GreenTasks;
import semKloeverly.domain.tasks.TradeTasks;

import java.util.List;

public class FileDataManager implements DataManager {

    private static DataContainer data = new DataContainer();
private static FileDataManager instance;

    public FileDataManager()
    {}

    @Override
    public void addResident(Resident resident) {
        data.getResidents().add(resident);


    }

    public static FileDataManager getInstance(){
        if(instance == null){
            instance = new FileDataManager();
        }
        return instance;
    }

    @Override
    public List<Resident> getAllResidents() {
        return List.of();
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public void addGreenTask(GreenTasks greenTask) {

    }

    @Override
    public List<GreenTasks> getAllGreenTasks() {
        return List.of();
    }

    @Override
    public void addCommunityTasks(CommunityTasks communityTask) {

    }

    @Override
    public List<CommunityTasks> getAllCommunityTasks() {
        return List.of();
    }

    @Override
    public void addTradeTasks(TradeTasks tradeTask) {

    }

    @Override
    public List<TradeTasks> getAllTradeTasks() {
        return List.of();
    }


}
