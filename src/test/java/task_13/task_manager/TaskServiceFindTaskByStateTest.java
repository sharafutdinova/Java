package task_13.task_manager;

import Task_13.task_manager.Task;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceFindTaskByStateTest<T> extends TaskServiceTest<T> {
    /**
     * Успешный поиск с несколькими результатами
     * Поиск по существующему статусу
     * Поиск по несуществующему статусу
     * Поиск в пустом списке
     * Поиск по null статусу -> NullPointerException
     */
    @Test
    public void userCanFindTasksByState() {
        Task<Integer> baseTask_3 = new Task<>(3, "Checked", "high", new Date());
        Task<Integer> baseTask_4 = new Task<>(4, "Checked", "high", new Date());
        taskService.addTask((Task<T>) baseTask_1);
        taskService.addTask((Task<T>) baseTask_2);
        taskService.addTask((Task<T>) baseTask_3);
        taskService.addTask((Task<T>) baseTask_4);
        List<Task<T>> actualTasks = taskService.findTasksByState(baseTask_1.getState());
        assertEquals(3, actualTasks.size());
    }

    @Test
    public void userCannotFindTasksByNotExistsState() {
        taskService.addTask((Task<T>) baseTask_1);
        List<Task<T>> filteredTasks = taskService.findTasksByState("not exists state");
        assertEquals(0, filteredTasks.size());
    }

    @Test
    public void userCannotFindTaskByStateFromEmptyList() {
        List<Task<T>> filteredTasks = taskService.findTasksByState(baseTask_2.getState());
        assertEquals(0, filteredTasks.size());
    }

    @Test
    public void userCannotFindTasksByNullState() {
        assertThrows(IllegalArgumentException.class, () -> taskService.findTasksByState(null),
                "При фильтрации по статусу null не было выброшено исключение IllegalArgumentException");
    }

    @Test
    public void userCannotFindTasksByEmptyState() {
        assertThrows(IllegalArgumentException.class, () -> taskService.findTasksByState(null),
                "При фильтрации по пустому статусу не было выброшено исключение IllegalArgumentException");
    }
}
