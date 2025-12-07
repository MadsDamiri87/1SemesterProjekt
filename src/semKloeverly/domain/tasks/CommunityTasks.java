package semKloeverly.domain.tasks;

public class CommunityTasks extends Tasks {

    public CommunityTasks(String type, String description, int points) {
        super(type, description, points);
    }

    @Override
    public int getPoints() {
        return 0; //temporary
    }


}
