package semKloeverly.domain.tasks;

import semKloeverly.domain.Resident;

import java.io.Serializable;


public abstract class Tasks implements Serializable {

    private int taskID;
    private Resident resident;
    private String type;
    private String description;
    private int points;
    private String status;


    public Tasks(Resident resident, String type, String description, int points, String status) {

        this.taskID      = taskID;
        this.type        = type;
        this.description = description;
        this.points      = points;
        this.status      = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }



}
