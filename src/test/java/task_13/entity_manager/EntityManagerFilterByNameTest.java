package task_13.entity_manager;

import Task_13.entity_manager.Entity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerFilterByNameTest extends EntityManagerTest {
    /**
     * Фильтрация в пустом списке
     * Фильтрация по существующему имени
     * Фильтрация по несуществующему имени в списке
     * Фильтрация с 1 совпадением
     * Фильтрация с несколькими совпадениями
     * Фильтрация по пустому имени и null
     */
    @Test
    public void userCanFilterListByExistName() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        List<Entity> filteredEntities = entityManager.filterByName(baseEntity_1.getName());
        assertEquals(1, filteredEntities.size());
        assertTrue(compareEntities(baseEntity_1, filteredEntities.getLast()));
    }

    @Test
    public void userCanFilterListByExistNameWithSeveralMathes() {
        Entity baseEntity_3 = new Entity("Alsu", 34, true);
        Entity baseEntity_4 = new Entity("Alsu", 12, false);
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        entityManager.addEntity(baseEntity_3);
        entityManager.addEntity(baseEntity_4);
        List<Entity> filteredEntities = entityManager.filterByName(baseEntity_1.getName());
        assertEquals(3, filteredEntities.size());
        assertEquals(baseEntity_1.getName(), filteredEntities.getLast().getName());
    }

    @Test
    public void userCanFilterListByNotExistName() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        List<Entity> filteredEntities = entityManager.filterByName("Not Exist");
        assertEquals(0, filteredEntities.size());
    }

    @Test
    public void userCanFilterListByEmptyName() {
        entityManager.addEntity(baseEntity_1);
        Entity baseEntity_2 = new Entity("", 12, false);
        entityManager.addEntity(baseEntity_2);
        List<Entity> filteredEntities = entityManager.filterByName("");
        assertEquals(1, filteredEntities.size());
        assertEquals("", filteredEntities.getLast().getName());
    }

    @Test
    public void userCanFilterEmptyList() {
        List<Entity> filteredEntities = entityManager.filterByName("Not Exist");
        assertEquals(0, filteredEntities.size());
    }
    @Test
    public void userCannotFilterListByNullName() {
        entityManager.addEntity(baseEntity_1);
        Entity baseEntity_2 = new Entity(null, 12, false);
        entityManager.addEntity(baseEntity_2);
        assertThrows(NullPointerException.class, ()->entityManager.filterByName(null), "При фильтрации с null имененем не было NullPointerException");
    }
}
