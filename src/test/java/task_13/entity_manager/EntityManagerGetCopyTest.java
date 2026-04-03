package task_13.entity_manager;

import Task_13.entity_manager.Entity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntityManagerGetCopyTest extends EntityManagerTest {
    /**
     * Сделать копию и изменить список
     * Сделать копию пустого списка
     * Сделать копию непустого списка
     */
    @Test
    public void userCanGetCopyOfList() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        List<Entity> copy = entityManager.getAll();
        assertEquals(2, copy.size());
        assertTrue(compareEntities(baseEntity_1, copy.getFirst()));
        assertTrue(compareEntities(baseChildEntity_2, copy.getLast()));
    }

    @Test
    public void userCanGetCopyOfEmptyList() {
        List<Entity> copy = entityManager.getAll();
        assertEquals(0, copy.size());
    }

    @Test
    public void userCanGetCopyOfListAndChangeList() {
        entityManager.addEntity(baseEntity_1);
        List<Entity> copy = entityManager.getAll();
        entityManager.addEntity(baseChildEntity_2);
        assertEquals(1, copy.size());
        assertEquals(2, entityManager.getEntitiesList().size());
    }
}
