package semKloeverly.domain.tasks;

public class TradeTasks extends Tasks {


    public TradeTasks(String type, String description, int points) {
        super(type, description, points);
    }

    @Override
    public int getPoints() {
        return 0; //temporary
    }
}
