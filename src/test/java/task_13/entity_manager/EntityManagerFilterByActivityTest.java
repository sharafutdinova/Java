package task_13.entity_manager;

import Task_13.entity_manager.Entity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerFilterByActivityTest extends EntityManagerTest{
    /**
     * Фильтрация в пустом списке
     * Фильтрация по активным
     * Фильтрация по неактивным
     * Фильтрация с 1 совпадением
     * Фильтрация с несколькими совпадениями
     */
    @Test
    public void userCanFilterListByActive() {
        Entity baseEntity_3 = new Entity("Alsu", 34, false);
        Entity baseEntity_4 = new Entity("Alsu", 12, false);
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        entityManager.addEntity(baseEntity_3);
        entityManager.addEntity(baseEntity_4);
        List<Entity> filteredEntities = entityManager.filterByActivity(true);
        assertEquals(2, filteredEntities.size());
        assertTrue(filteredEntities.getFirst().isActive());
        assertTrue(filteredEntities.getLast().isActive());
    }
    @Test
    public void userCanFilterListByNotActive() {
        Entity baseEntity_3 = new Entity("Alsu", 34, false);
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        entityManager.addEntity(baseEntity_3);
        List<Entity> filteredEntities = entityManager.filterByActivity(false);
        assertEquals(1, filteredEntities.size());
        assertFalse(filteredEntities.getFirst().isActive());
    }
    @Test
    public void userCanFilterEmptyList() {
        List<Entity> filteredEntities = entityManager.filterByActivity(false);
        assertEquals(0, filteredEntities.size());
    }
}
