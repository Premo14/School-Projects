import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {
    private TaskService taskService;

    @Before
    public void setup() {
        // Create an instance of TaskService before each test case
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        // Create a new task
        Task task = new Task("T1", "Task 1", "Description 1");

        // Add the task to the TaskService and store the result
        boolean result = taskService.addTask(task);

        // Assert that the task was successfully added
        Assert.assertTrue(result);
    }

    @Test
    public void testDeleteTask() {
        // Create a new task
        Task task = new Task("T1", "Task 1", "Description 1");

        // Add the task to the TaskService
        taskService.addTask(task);

        // Delete the task by its ID and store the result
        boolean result = taskService.deleteTask("T1");

        // Assert that the task was successfully deleted
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateTaskName() {
        // Create a new task
        Task task = new Task("T1", "Task 1", "Description 1");

        // Add the task to the TaskService
        taskService.addTask(task);

        // Update the task name and store the result
        boolean result = taskService.updateTaskName("T1", "New Task Name");

        // Assert that the task name was successfully updated
        Assert.assertTrue(result);

        // Assert that the task's name matches the updated value
        Assert.assertEquals("New Task Name", task.getName());
    }
}