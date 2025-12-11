package semKloeverly.domain.tasks;

import semKloeverly.domain.Resident;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class GreenTasks extends Tasks implements Serializable {


    public GreenTasks(Resident resident, String type, String description, int points, String status) {
        super(resident, type, description, points, status);
    }


}
