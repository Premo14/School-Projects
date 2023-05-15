// Task class represents a task object with required fields (id, name, description)
public class Task {
    private final String taskId;
    private String name;
    private String description;

    // Constructor to initialize the task object with id, name, and description
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be null and must not exceed 10 characters.");
        }
        this.taskId = taskId;

        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name must not be null and must not exceed 20 characters.");
        }
        this.name = name;

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description must not be null and must not exceed 50 characters.");
        }
        this.description = description;
    }

    // Getter method for retrieving the task id
    public String getId() {
        return taskId;
    }

    // Getter method for retrieving the task name
    public String getName() {
        return name;
    }

    // Setter method for updating the task name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for retrieving the task description
    public String getDescription() {
        return description;
    }

    // Setter method for updating the task description
    public void setDescription(String description) {
        this.description = description;
    }
}