package semKloeverly.domain.tasks;

import semKloeverly.domain.Resident;

import java.time.LocalDateTime;

public class TradeTasks extends Tasks {

private LocalDateTime deadline;

    public TradeTasks(Resident resident, String type, String description, int points, String status) {
        super(resident, type, description, points, status);
    }

}
