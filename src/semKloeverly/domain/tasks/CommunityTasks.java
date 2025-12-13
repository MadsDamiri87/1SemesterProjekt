package semKloeverly.domain.tasks;

import semKloeverly.domain.Resident;

public class CommunityTasks extends Tasks {

    public CommunityTasks(Resident resident, String type, String description, int points, String status) {
        super(resident, type, description, points, status);
    }

}
