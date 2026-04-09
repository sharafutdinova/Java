package task_13.task_manager;

import Task_13.task_manager.Task;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceAddTaskTest<T> extends TaskServiceTest<T> {
    /**
     * Добавление в пустой список
     * Добавление в непустой список
     * Добавление задачи с таким же id -> не добавится
     * Добавление с разными типами id
     */
    @Test
    public void userCanAddNewTaskToEmptyList() {
        taskService.addTask((Task<T>) baseTask_1);
        assertEquals(1, taskService.getTasks().size());
        Task<T> actualTask = taskService.getTasks().getFirst();
        assertTrue(compareTask((Task<T>) baseTask_1, actualTask));
    }

    @Test
    public void userCanAddNewTaskToNotEmptyList() {
        taskService.addTask((Task<T>) baseTask_1);
        taskService.addTask((Task<T>) baseTask_2);
        assertEquals(2, taskService.getTasks().size());
        Task<T> actualTask_1 = taskService.getTasks().getFirst();
        Task<T> actualTask_2 = taskService.getTasks().getLast();
        assertTrue(compareTask((Task<T>) baseTask_1, actualTask_1));
        assertTrue(compareTask((Task<T>) baseTask_2, actualTask_2));
    }

    @Test
    public void userCannotAddTaskWithTheSameID() {
        Task<Integer> expectedTask_3 = new Task<>(1, "new", "low", new Date());
        taskService.addTask((Task<T>) baseTask_1);
        taskService.addTask((Task<T>) baseTask_2);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask((Task<T>) expectedTask_3),
                "При добавлении задачи с существующим ID не было выброшено исключение IllegalArgumentException");
        assertEquals(2, taskService.getTasks().size());
    }
    @Test
    public void userCannotAddNullTask() {
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(null),
                "При добавлении null задачи не было выброшено исключение IllegalArgumentException");
        assertEquals(0, taskService.getTasks().size());
    }
}
