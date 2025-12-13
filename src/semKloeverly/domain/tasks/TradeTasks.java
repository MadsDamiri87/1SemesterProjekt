package semKloeverly.domain.tasks;

import semKloeverly.domain.Resident;

public class TradeTasks extends Tasks {


    public TradeTasks(Resident resident, String type, String description, int points, String status) {
        super(resident, type, description, points, status);
    }

}
