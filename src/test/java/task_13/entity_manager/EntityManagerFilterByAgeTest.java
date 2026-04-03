package task_13.entity_manager;

import Task_13.entity_manager.Entity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntityManagerFilterByAgeTest extends EntityManagerTest {
    /**
     * Фильтрация в пустом списке
     * Фильтрация по существующему возрасту
     * Фильтрация по существующему возрасту +-1
     */
    @Test
    public void userCanFilterListByExistAge() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        List<Entity> filteredEntities = entityManager.filterByAge(baseEntity_1.getAge());
        assertEquals(1, filteredEntities.size());
        assertTrue(compareEntities(baseEntity_1, filteredEntities.getLast()));
    }

    @Test
    public void userCanFilterListByNotExistAge() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        List<Entity> filteredEntities = entityManager.filterByAge(baseEntity_1.getAge() + 1);
        assertEquals(0, filteredEntities.size());
        filteredEntities = entityManager.filterByAge(baseEntity_1.getAge() - 1);
        assertEquals(0, filteredEntities.size());
    }

    @Test
    public void userCanFilterEmptyListByAge() {
        List<Entity> filteredEntities = entityManager.filterByAge(0);
        assertEquals(0, filteredEntities.size());
    }
}
