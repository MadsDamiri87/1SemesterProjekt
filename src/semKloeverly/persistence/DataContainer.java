package semKloeverly.persistence;

import javafx.concurrent.Task;
import semKloeverly.domain.PointSystem;
import semKloeverly.domain.Resident;
//import semKloeverly.domain.tasks.CommunityTasks;
//import semKloeverly.domain.tasks.GreenTasks;
//import semKloeverly.domain.tasks.Tasks;
//import semKloeverly.domain.tasks.TradeTasks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataContainer implements Serializable
{

//    private List<Tasks> tasks;
    private List<Resident> residents;
    private List<PointSystem> pointSystems;

    public DataContainer() {
//        tasks = new ArrayList<>();
        residents = new ArrayList<>();
        pointSystems = new ArrayList<>();
    }

//    pointSystem er stadig ikke implementeret... Måske det ikke skal være en liste??

//    public List<Tasks> getTasks() {return tasks;}

    public List<Resident> getResidents() {return residents;}

    public List<PointSystem> getPointSystems() {return pointSystems;}

}
