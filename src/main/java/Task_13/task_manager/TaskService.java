package Task_13.task_manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService<T> {
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public synchronized void addTask(Task<T> newTask) {
        if (tasks.stream().filter(task -> task.getID().equals(newTask.getID())).toList().isEmpty())
            tasks.add(newTask);
    }

    public synchronized void deleteTask(T taskId) {
        tasks.removeIf(task -> task.getID().equals(taskId));
    }

    public Task findTaskById(T id) {
        return tasks.stream().filter(task -> task.getID().equals(id)).findFirst().get();
    }

    public List<Task> findTasks(String state, String priority) {
        return tasks.stream().filter(task -> task.getState().equals(state) && task.getPriority().equals(priority)).toList();
    }

    public List<Task> getSortedTasks() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toList());
    }

}
