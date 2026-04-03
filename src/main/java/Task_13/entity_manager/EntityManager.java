package Task_13.entity_manager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityManager<T extends Entity> {
    private CopyOnWriteArrayList<T> entitiesList;

    public EntityManager() {
        this.entitiesList = new CopyOnWriteArrayList<>();
    }

    public List<T> getEntitiesList() {
        return entitiesList;
    }

    public void addEntity(T entity) {
        entitiesList.add(entity);
    }

    public boolean deleteEntity(T entity) {
        return entitiesList.remove(entity);
    }

    public List<T> getAll() {
        return List.copyOf(entitiesList);
    }

    public List<T> filterByName(String name) {
        return entitiesList.stream().filter(entity -> entity.getName().equals(name)).toList();
    }

    public List<T> filterByActivity(Boolean isActive) {
        return entitiesList.stream().filter(entity -> entity.isActive() == isActive).toList();
    }

    public List<T> filterByAge(int age) {
        return entitiesList.stream().filter(entity -> entity.getAge() == age).toList();
    }
}
