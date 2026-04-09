package task_13.task_manager;

import Task_13.task_manager.Task;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskServiceFindTaskByPriorityTest extends TaskServiceTest {
    /**
     * Успешный поиск с несколькими результатами
     * Поиск по существующему приоритету
     * Поиск по несуществующему приоритету
     * Поиск в пустом списке
     * Поиск по null приоритету -> IllegalArgumentException
     */
    @Test
    public void userCanFindTasksByPriority() {
        Task<Integer> baseTask_3 = new Task<>(3, "Checked", "high", new Date());
        Task<Integer> baseTask_4 = new Task<>(4, "Checked", "high", new Date());
        taskService.addTask(baseTask_1);
        taskService.addTask(baseTask_2);
        taskService.addTask(baseTask_3);
        taskService.addTask(baseTask_4);
        List<Task> actualTasks = taskService.findTasksByPriority(baseTask_1.getPriority());
        assertEquals(3, actualTasks.size());
    }

    @Test
    public void userCannotFindTasksByNotExistsPriority() {
        taskService.addTask(baseTask_1);
        List<Task> filteredTasks = taskService.findTasksByPriority("not exists priority");
        assertEquals(0, filteredTasks.size());
    }

    @Test
    public void userCannotFindTaskByPriorityFromEmptyList() {
        List<Task> filteredTasks = taskService.findTasksByPriority(baseTask_2.getPriority());
        assertEquals(0, filteredTasks.size());
    }

    @Test
    public void userCannotFindTasksByNullPriority() {
        assertThrows(IllegalArgumentException.class, () -> taskService.findTasksByPriority(null),
                "При фильтрации по приоритету null не было выброшено исключение IllegalArgumentException");
    }

    @Test
    public void userCannotFindTasksByEmptyPriority() {
        assertThrows(IllegalArgumentException.class, () -> taskService.findTasksByPriority(""),
                "При фильтрации по пустому приоритету не было выброшено исключение IllegalArgumentException");
    }
}
