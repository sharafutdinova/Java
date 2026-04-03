package task_13.task_manager;

import Task_13.inventory_service.Product;
import Task_13.task_manager.Task;
import Task_13.task_manager.TaskService;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;
import java.util.List;

public class TaskServiceTest {
    protected TaskService taskService;
    protected Task<Integer> baseTask_1 = new Task<>(1, "Checked", "high", new Date());
    protected Task<String> baseTask_2 = new Task<>("First", "new", "medium", new Date());

    @BeforeEach
    public void testSetup() {
        taskService = new TaskService();
    }

    public boolean compareTask(Task expected, Task actual) {
        return expected.getID().equals(actual.getID()) && expected.getDate().equals(actual.getDate())
                && expected.getPriority().equals(actual.getPriority()) && expected.getState().equals(actual.getState());
    }

    public List<Task> filterTasks(List<Task> tasks, String state, String priority) {
        return tasks.stream().filter(task -> task.getState().equals(state) && task.getPriority().equals(priority)).toList();
    }
}
