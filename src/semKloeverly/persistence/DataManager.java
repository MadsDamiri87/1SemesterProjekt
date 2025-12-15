package semKloeverly.persistence;

import semKloeverly.domain.Resident;
import semKloeverly.domain.tasks.Tasks;

import java.util.List;

public interface DataManager
{

  void addResident(Resident resident);

  List<Resident> getAllResidents();

  void updateResident(Resident resident);

  void deleteResident(Resident resident);

  void addTask(Tasks task);

  List<Tasks> getAllTasks();

  void updateTasks(Tasks task);

  void setEditResident(int id);
  Resident getEditResident();
}
