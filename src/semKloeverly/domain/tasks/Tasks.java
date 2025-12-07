package semKloeverly.domain.tasks;

public abstract class Tasks {

    private String type;
    private String description;
    private int points;


    public Tasks(String type, String description, int points) {
        this.type = type;
        this.description = description;
        this.points = points;
    }
    public int getPoints(){
        return points;
    }
}
