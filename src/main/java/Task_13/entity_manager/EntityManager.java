package Task_13.entity_manager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityManager<T extends Entity> {
    private CopyOnWriteArrayList<T> entitiesList;

    public EntityManager() {
        this.entitiesList = new CopyOnWriteArrayList<>();
    }

    public List<T> getEntitiesList() {
        return List.copyOf(entitiesList);
    }

    public void addEntity(T entity) {
        if (entity == null)
            throw new IllegalArgumentException("Сущность не может быть null");
        entitiesList.add(entity);
    }

    public boolean deleteEntity(T entity) {
        if (entity == null)
            throw new IllegalArgumentException("Сущность не может быть null");
        return entitiesList.remove(entity);
    }

    public List<T> getAll() {
        return List.copyOf(entitiesList);
    }

    public List<T> filterByName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть null или пустым");
        return entitiesList.stream().filter(entity -> entity.getName().equals(name)).toList();
    }

    public List<T> filterByActivity(Boolean isActive) {
        return entitiesList.stream().filter(entity -> entity.isActive() == isActive).toList();
    }

    public List<T> filterByAge(int minAge, int maxAge) {
        if (maxAge < minAge) throw new IllegalArgumentException("Значение От не может быть больше значения До");
        return entitiesList.stream().filter(entity -> entity.getAge() >= minAge && entity.getAge() <= maxAge).toList();
    }
}
