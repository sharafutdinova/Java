package task_13.task_manager;

import Task_13.task_manager.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskServiceDeleteTaskTest<T> extends TaskServiceTest<T> {
    /**
     * Удаление задачи с разными типами ID
     * Удаление единственной задачи в списке
     * Удаление задачи, которой нет в списке
     */
    @Test
    public void userCanDeleteLastTaskInList() {
        taskService.addTask((Task<T>) baseTask_1);
        taskService.deleteTask((T) baseTask_1.getID());
        assertEquals(0, taskService.getTasks().size());
    }

    @Test
    public void userCanDeleteDifferentTasksFromList() {
        taskService.addTask((Task<T>) baseTask_1);
        taskService.addTask((Task<T>) baseTask_2);
        taskService.deleteTask((T) baseTask_1.getID());
        taskService.deleteTask((T) baseTask_2.getID());
        assertEquals(0, taskService.getTasks().size());
    }

    @Test
    public void userCannotDeleteNotExistsTaskFromList() {
        taskService.addTask((Task<T>) baseTask_1);
        taskService.deleteTask((T) baseTask_2.getID());
        assertEquals(1, taskService.getTasks().size());
    }

    @Test
    public void userCannotDeleteNullTaskFromList() {
        taskService.addTask((Task<T>) baseTask_1);
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask(null),
                "При удалении null задачи не было выброшено исключение IllegalArgumentException");
        assertEquals(1, taskService.getTasks().size());
    }
}
