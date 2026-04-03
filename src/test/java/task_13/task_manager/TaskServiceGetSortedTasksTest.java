package task_13.task_manager;

import Task_13.task_manager.Task;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskServiceGetSortedTasksTest extends TaskServiceTest {
    /**
     * Сортировка пустого списка
     * Сортировка списка из одного элемента
     * Сортировка списка из нескольких элементов
     * Сортировка списка с одинаковыми датами
     */

    @Test
    public void userCanSortListWithOneTask() {
        taskService.addTask(baseTask_1);
        List<Task> actualTasks = taskService.getSortedTasks();
        assertEquals(1, actualTasks.size());
    }

    @Test
    public void userCanSortListWithSeveralTasks() {
        Task<Integer> baseTask_3 = new Task<>(3, "Checked", "low", new Date(124, 11, 20));
        Task<Integer> baseTask_4 = new Task<>(4, "New", "high", new Date(127, 1, 1));
        taskService.addTask(baseTask_1);
        taskService.addTask(baseTask_2);
        taskService.addTask(baseTask_3);
        taskService.addTask(baseTask_4);
        List<Task> actualTasks = taskService.getSortedTasks();
        assertEquals(4, actualTasks.size());
        assertTrue(compareTask(baseTask_3, actualTasks.getFirst()));
        assertTrue(compareTask(baseTask_4, actualTasks.getLast()));
    }

    @Test
    public void userCanSortListWithSameDates() {
        Task<Integer> baseTask_3 = new Task<>(1, "Checked", "low", new Date(126, 5, 5));
        Task<Integer> baseTask_4 = new Task<>(2, "Checked", "low", new Date(126, 5, 5));
        Task<Integer> baseTask_5 = new Task<>(3, "Checked", "low", new Date(126, 5, 5));
        taskService.addTask(baseTask_3);
        taskService.addTask(baseTask_4);
        taskService.addTask(baseTask_5);
        List<Task> actualTasks = taskService.getSortedTasks();
        assertEquals(3, actualTasks.size());
    }

    @Test
    public void userCanSortEmptyList() {
        List<Task> actualTasks = taskService.getSortedTasks();
        assertEquals(0, actualTasks.size());
    }
}
