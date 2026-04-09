package task_13.entity_manager;

import Task_13.entity_manager.Entity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerDeleteEntityTest extends EntityManagerTest {
    /**
     * Удаление существующей сущности
     * Удаление несуществующей сущности
     * Удаление сущности со списка с дубликатами
     * Удаление с пустого списка
     */
    @Test
    public void userCanDeleteLastEntityFromList() {
        entityManager.addEntity(baseEntity_1);
        assertTrue(entityManager.deleteEntity(baseEntity_1));
        assertEquals(0, entityManager.getEntitiesList().size());
    }

    @Test
    public void userCanDeleteEntityFromListWithDuplicates() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseEntity_1);
        assertTrue(entityManager.deleteEntity(baseEntity_1));
        assertEquals(2, entityManager.getEntitiesList().size());
    }

    @Test
    public void userCannotDeleteNotExistsEntityFromList() {
        entityManager.addEntity(baseEntity_1);
        assertFalse(entityManager.deleteEntity(baseChildEntity_2));
        assertEquals(1, entityManager.getEntitiesList().size());
    }

    @Test
    public void userCannotDeleteEntityFromEmptyList() {
        assertFalse(entityManager.deleteEntity(baseChildEntity_2));
        assertEquals(0, entityManager.getEntitiesList().size());
    }

    @Test
    public void userCannotDeleteNullEntity() {
        Entity entity = null;
        assertThrows(IllegalArgumentException.class, () -> entityManager.deleteEntity(entity),
                "При удалении сущности = null, не выбрасывается исключение IllegalArgumentException");
        assertEquals(0, entityManager.getEntitiesList().size());
    }
}
