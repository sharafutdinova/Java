package task_13.task_manager;

import Task_13.task_manager.Task;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceFindTaskTest extends TaskServiceTest {
    /**
     * Успешный поиск с несколькими результатами
     * Поиск существующей задачи с таким же статутсом и приоритетом в списке
     * Поиск существующей задачи с таким же статутсом и другим приоритетом в списке
     * Поиск существующей задачи с другим статутсом и таким же приоритетом в списке
     * Поиск существующей задачи с другими статутсом и приоритетом в списке
     * Поиск в пустом списке -> NoSuchElementException
     */
    @Test
    public void userCanFindTasksFromList() {
        Task<Integer> baseTask_3 = new Task<>(3, "Checked", "high", new Date());
        Task<Integer> baseTask_4 = new Task<>(4, "Checked", "high", new Date());
        taskService.addTask(baseTask_1);
        taskService.addTask(baseTask_2);
        taskService.addTask(baseTask_3);
        taskService.addTask(baseTask_4);
        List<Task> actualTasks = taskService.findTasks(baseTask_1.getState(), baseTask_1.getPriority());
        assertEquals(3, actualTasks.size());
        List<Task> filteredActualTasks = filterTasks(actualTasks, baseTask_1.getState(), baseTask_1.getPriority());
        assertEquals(3, filteredActualTasks.size());
    }

    //У одной задачи не тот приоритет, у другой не тот статус
    @Test
    public void userCannotFindTasksWithNotMathedOneValueFromList() {
        taskService.addTask(baseTask_1);
        taskService.addTask(baseTask_2);
        List<Task> filteredTasks = taskService.findTasks(baseTask_1.getState(), baseTask_2.getPriority());
        assertEquals(0, filteredTasks.size());
    }

    //У задачи не тот приоритет и статус
    @Test
    public void userCannotFindTasksWithNotMathedValuesFromList() {
        taskService.addTask(baseTask_1);
        List<Task> filteredTasks = taskService.findTasks(baseTask_2.getState(), baseTask_2.getPriority());
        assertEquals(0, filteredTasks.size());
    }

    @Test
    public void userCannotFindTaskFromEmptyList() {
        List<Task> filteredTasks = taskService.findTasks(baseTask_2.getState(), baseTask_2.getPriority());
        assertEquals(0, filteredTasks.size()); }
}
