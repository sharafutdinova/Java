package Task_13.task_manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService<T> {
    private List<Task<T>> tasks = new ArrayList<>();

    public List<Task<T>> getTasks() {
        return List.copyOf(tasks);
    }

    public synchronized void addTask(Task<T> newTask) {
        if (newTask == null) throw new IllegalArgumentException("Задача не может быть null");
        if (tasks.stream().filter(task -> task.getID().equals(newTask.getID())).toList().isEmpty())
            tasks.add(newTask);
        else throw new IllegalArgumentException("Задача с таким id уже существует");
    }

    public synchronized void deleteTask(T taskId) {
        if (taskId == null) throw new IllegalArgumentException("Id задачи не может быть null");
        tasks.removeIf(task -> task.getID().equals(taskId));
    }

    public Task<T> findTaskById(T id) {
        if (id == null) throw new IllegalArgumentException("Id задачи не может быть null");
        return tasks.stream().filter(task -> task.getID().equals(id)).findFirst().orElseThrow();
    }

    public List<Task<T>> findTasksByState(String state) {
        if (state == null || state.isEmpty()) throw new IllegalArgumentException("State не может быть пустым или null");
        return tasks.stream().filter(task -> task.getState().equals(state)).toList();
    }

    public List<Task<T>> findTasksByPriority(String priority) {
        if (priority == null || priority.isEmpty())
            throw new IllegalArgumentException("Priority не может быть пустым или null");
        return tasks.stream().filter(task -> task.getPriority().equals(priority)).toList();
    }

    public List<Task<T>> getSortedTasks() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toList());
    }

}
