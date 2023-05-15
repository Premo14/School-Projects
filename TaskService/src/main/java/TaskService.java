// TaskService class provides methods to add, delete, and update tasks
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks;

    // Constructor to initialize the tasks map
    public TaskService() {
        tasks = new HashMap<>();
    }

    // Method to add a task to the tasks map
    public boolean addTask(Task task) {
        if (task != null && !tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
            return true;
        }
        return false;
    }

    // Method to delete a task from the tasks map by task ID
    public boolean deleteTask(String taskId) {
        if (taskId != null && tasks.containsKey(taskId)) {
            tasks.remove(taskId);
            return true;
        }
        return false;
    }

    // Method to update the name of a task in the tasks map by task ID
    public boolean updateTaskName(String taskId, String newName) {
        if (taskId != null && newName != null && tasks.containsKey(taskId)) {
            Task task = tasks.get(taskId);
            task.setName(newName);
            return true;
        }
        return false;
    }

    // Method to update the description of a task in the tasks map by task ID
    public boolean updateTaskDescription(String taskId, String newDescription) {
        if (taskId != null && newDescription != null && tasks.containsKey(taskId)) {
            Task task = tasks.get(taskId);
            task.setDescription(newDescription);
            return true;
        }
        return false;
    }
}