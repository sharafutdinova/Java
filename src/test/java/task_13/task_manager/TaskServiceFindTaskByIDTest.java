package task_13.task_manager;

import Task_13.task_manager.Task;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceFindTaskByIDTest<T> extends TaskServiceTest<T> {
    /**
     * Поиск задач с разными типами ID
     * Поиск существующей задачи в списке
     * Поиск задачи, которой нет в списке -> NoSuchElementException
     */
    @Test
    public void userCanFindTaskByIDFromList() {
        taskService.addTask((Task<T>) baseTask_1);
        Task<T> actualTask = taskService.findTaskById((T) baseTask_1.getID());
        assertTrue(compareTask((Task<T>) baseTask_1, actualTask));
    }

    @Test
    public void userCanFindTasksWithDifferentIDFromList() {
        taskService.addTask((Task<T>) baseTask_1);
        taskService.addTask((Task<T>) baseTask_2);
        Task<T> actualTask_1 = taskService.findTaskById((T) baseTask_1.getID());
        assertTrue(compareTask((Task<T>) baseTask_1, actualTask_1));
        Task<T> actualTask_2 = taskService.findTaskById((T) baseTask_2.getID());
        assertTrue(compareTask((Task<T>) baseTask_2, actualTask_2));
        assertEquals(2, taskService.getTasks().size());
    }

    @Test
    public void userCannotFindNotExistsTaskFromList() {
        taskService.addTask((Task<T>) baseTask_1);
        assertThrows(NoSuchElementException.class, () -> taskService.findTaskById((T) baseTask_2.getID()),
                "При поиске несуществующей задачи не было исключения NoSuchElementException");
    }

    @Test
    public void userCannotFindNotExistsTaskFromEmptyList() {
        assertThrows(NoSuchElementException.class, () -> taskService.findTaskById((T) baseTask_2.getID()),
                "При поиске в пустом списке не было исключения NoSuchElementException");
    }

    @Test
    public void userCannotFindTasksByNullID() {
        assertThrows(IllegalArgumentException.class, () -> taskService.findTaskById(null),
                "При фильтрации по Id = null не было выброшено исключение IllegalArgumentException");
    }
}
