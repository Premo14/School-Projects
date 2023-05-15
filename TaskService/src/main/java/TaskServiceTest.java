import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskServiceTest {
    private TaskService taskService;

    @Before
    public void setup() {
        // Create an instance of TaskService before each test case
        taskService = new TaskService();
    }

    @Test
    public void testAddTaskWithExistingId() {
        // Create two tasks with the same ID
        Task task1 = new Task("T1", "Task 1", "Description 1");
        Task task2 = new Task("T1", "Task 2", "Description 2");

        // Add the first task to the TaskService and store the result
        boolean result1 = taskService.addTask(task1);

        // Add the second task with the same ID to the TaskService and store the result
        boolean result2 = taskService.addTask(task2);

        // Assert that the first task was successfully added
        Assert.assertTrue(result1);

        // Assert that the second task with the same ID was not added
        Assert.assertFalse(result2);
    }

    @Test
    public void testDeleteNonExistingTask() {
        // Attempt to delete a non-existing task by its ID and store the result
        boolean result = taskService.deleteTask("T1");

        // Assert that the task was not deleted
        Assert.assertFalse(result);
    }

    @Test
    public void testUpdateNonExistingTaskName() {
        // Attempt to update the name of a non-existing task by its ID and store the result
        boolean result = taskService.updateTaskName("T1", "New Task Name");

        // Assert that the task name was not updated
        Assert.assertFalse(result);
    }

    @Test
    public void testUpdateTaskDescription() {
        // Create a new task
        Task task = new Task("T1", "Task 1", "Description 1");

        // Add the task to the TaskService
        taskService.addTask(task);

        // Update the task description and store the result
        boolean result = taskService.updateTaskDescription("T1", "New Description");

        // Assert that the task description was successfully updated
        Assert.assertTrue(result);

        // Assert that the task's description matches the updated value
        Assert.assertEquals("New Description", task.getDescription());
    }

    @Test
    public void testUpdateNonExistingTaskDescription() {
        // Attempt to update the description of a non-existing task by its ID and store the result
        boolean result = taskService.updateTaskDescription("T1", "New Description");

        // Assert that the task description was not updated
        Assert.assertFalse(result);
    }
}
