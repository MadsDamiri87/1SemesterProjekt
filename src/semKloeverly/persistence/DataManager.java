package semKloeverly.persistence;

import javafx.concurrent.Task;
import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.CommunityTasks;
import semKloeverly.domain.tasks.GreenTasks;
import semKloeverly.domain.tasks.TradeTasks;

import java.util.List;

public interface DataManager {

    void addResident(Resident resident);
    List<Resident> getAllResidents();

    void addTask(Task task);
    List<Task> getAllTasks();

    void addGreenTask(GreenTasks greenTask);
    List<GreenTasks> getAllGreenTasks();


    void addCommunityTasks(CommunityTasks communityTask);
    List<CommunityTasks> getAllCommunityTasks();

    void addTradeTasks(TradeTasks tradeTask);
    List<TradeTasks> getAllTradeTasks();



}
