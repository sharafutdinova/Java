package task_13.task_manager;

import Task_13.task_manager.Task;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskServiceAddTaskTest extends TaskServiceTest {
    /**
     * Добавление в пустой список
     * Добавление в непустой список
     * Добавление задачи с таким же id -> не добавится
     * Добавление с разными типами id
     */
    @Test
    public void userCanAddNewTaskToEmptyList() {
        taskService.addTask(baseTask_1);
        assertEquals(1, taskService.getTasks().size());
        Task<String> actualTask = (Task<String>) taskService.getTasks().getFirst();
        assertTrue(compareTask(baseTask_1, actualTask));
    }

    @Test
    public void userCanAddNewTaskToNotEmptyList() {
        taskService.addTask(baseTask_1);
        taskService.addTask(baseTask_2);
        assertEquals(2, taskService.getTasks().size());
        Task<String> actualTask_1 = (Task<String>) taskService.getTasks().getFirst();
        Task<String> actualTask_2 = (Task<String>) taskService.getTasks().getLast();
        assertTrue(compareTask(baseTask_1, actualTask_1));
        assertTrue(compareTask(baseTask_2, actualTask_2));
    }

    @Test
    public void userCannotAddTaskWithTheSameID() {
        Task<Integer> expectedTask_3 = new Task<>(1, "new", "low", new Date());
        taskService.addTask(baseTask_1);
        taskService.addTask(baseTask_2);
        taskService.addTask(expectedTask_3);
        assertEquals(2, taskService.getTasks().size());
        Task<String> actualTask_1 = (Task<String>) taskService.getTasks().getFirst();
        Task<String> actualTask_2 = (Task<String>) taskService.getTasks().getLast();
        assertTrue(compareTask(baseTask_1, actualTask_1));
        assertTrue(compareTask(baseTask_2, actualTask_2));
    }
}
