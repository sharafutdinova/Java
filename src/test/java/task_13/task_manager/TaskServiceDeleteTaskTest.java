package task_13.task_manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskServiceDeleteTaskTest extends TaskServiceTest{
    /**
     * Удаление задачи с разными типами ID
     * Удаление единственной задачи в списке
     * Удаление задачи, которой нет в списке
     */
    @Test
    public void userCanDeleteLastTaskInList(){
        taskService.addTask(baseTask_1);
        taskService.deleteTask(baseTask_1.getID());
        assertEquals(0, taskService.getTasks().size());
    }

    @Test
    public void userCanDeleteDifferentTasksFromList(){
        taskService.addTask(baseTask_1);
        taskService.addTask(baseTask_2);
        taskService.deleteTask(baseTask_1.getID());
        taskService.deleteTask(baseTask_2.getID());
        assertEquals(0, taskService.getTasks().size());
    }

    @Test
    public void userCannotDeleteNotExistsTaskFromList(){
        taskService.addTask(baseTask_1);
        taskService.deleteTask(baseTask_2.getID());
        assertEquals(1, taskService.getTasks().size());
    }
}
