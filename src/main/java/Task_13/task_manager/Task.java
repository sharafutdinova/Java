package Task_13.task_manager;

import java.util.Date;
import java.util.Objects;

public class Task<T> {
    private T ID;
    private String state;
    private String priority;
    private Date date;

    public Task(T ID, String state, String priority, Date date) {
        if (ID == null) throw new IllegalArgumentException("ID cannot be null");
        this.ID = ID;
        this.state = state;
        this.priority = priority;
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public T getID() {
        return ID;
    }

    public String getPriority() {
        return priority;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task<?> task = (Task<?>) o;
        return Objects.equals(ID, task.ID) && Objects.equals(state, task.state) && Objects.equals(priority, task.priority) && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, state, priority, date);
    }

}
