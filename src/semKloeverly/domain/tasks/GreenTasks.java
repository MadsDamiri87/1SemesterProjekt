package semKloeverly.domain.tasks;

public class GreenTasks extends Tasks {


    public GreenTasks(String type, String description, int points) {
        super(type, description, points);
    }

    @Override
    public int getPoints()
    {
        return 0; //temporary
    }
}
