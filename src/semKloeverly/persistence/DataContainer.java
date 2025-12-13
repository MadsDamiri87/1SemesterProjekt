package semKloeverly.persistence;

import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.Tasks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataContainer implements Serializable {

    private List<Tasks> tasks;
    private List<Resident> residents;

    public DataContainer() {
        tasks     = new ArrayList<>();
        residents = new ArrayList<>();
    }


    public List<Tasks> getTasks() {
        return tasks;
    }

    public List<Resident> getResidents() {
        return residents;
    }
}
