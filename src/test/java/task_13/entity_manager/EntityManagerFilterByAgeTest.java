package task_13.entity_manager;

import Task_13.entity_manager.Entity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerFilterByAgeTest extends EntityManagerTest {
    /**
     * Фильтрация в пустом списке
     * Фильтрация по существующему возрасту
     * Проверка нижней/верхней границ: граница, граница + 1, граница -1
     * Проверка фильтрации при От > До
     */
    @Test
    public void userCanFilterListByExistAge() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        List<Entity> filteredEntities = entityManager.filterByAge(baseEntity_1.getAge() - 1, baseEntity_1.getAge() + 1);
        assertEquals(1, filteredEntities.size());
        assertTrue(compareEntities(baseEntity_1, filteredEntities.getLast()));
    }

    @Test
    public void userCanFilterListByAgeWithOutOfBorderValue() {
        entityManager.addEntity(baseEntity_1);
        List<Entity> filteredEntities = entityManager.filterByAge(baseEntity_1.getAge() - 10, baseEntity_1.getAge() - 1);
        assertEquals(0, filteredEntities.size());
        filteredEntities = entityManager.filterByAge(baseEntity_1.getAge() + 1, baseEntity_1.getAge() + 10);
        assertEquals(0, filteredEntities.size());
    }

    @Test
    public void userCanFilterListByAgeWithBorderValue() {
        entityManager.addEntity(baseEntity_1);
        List<Entity> filteredEntities = entityManager.filterByAge(baseEntity_1.getAge(), baseEntity_1.getAge());
        assertEquals(1, filteredEntities.size());
        assertTrue(compareEntities(baseEntity_1, filteredEntities.getLast()));
    }

    @Test
    public void userCanFilterEmptyListByAge() {
        List<Entity> filteredEntities = entityManager.filterByAge(0, 100);
        assertEquals(0, filteredEntities.size());
    }

    @Test
    public void userCannotFilterByAgeWithMinGreaterThanMax() {
        entityManager.addEntity(baseEntity_1);
        assertThrows(IllegalArgumentException.class, () -> entityManager.filterByAge(60,40), "При фильтрации со значениями От > До не было выброшено IllegalArgumentException");
    }
}
