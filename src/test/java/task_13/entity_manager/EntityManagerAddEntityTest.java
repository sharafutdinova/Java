package task_13.entity_manager;

import Task_13.entity_manager.Entity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerAddEntityTest extends EntityManagerTest {
    /**
     * Добавление в пустой список
     * Добавление в непустой список
     * Добавление одинаковых сущностей
     * Добавление разных сущностей
     */
    @Test
    public void userCanAddEntityToEmptyList() {
        entityManager.addEntity(baseEntity_1);
        assertEquals(1, entityManager.getEntitiesList().size());
        assertTrue(compareEntities(baseEntity_1, entityManager.getEntitiesList().getFirst()));
    }

    @Test
    public void userCanAddEntityToNotEmptyList() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseChildEntity_2);
        assertEquals(2, entityManager.getEntitiesList().size());
        assertTrue(compareEntities(baseEntity_1, entityManager.getEntitiesList().getFirst()));
        assertTrue(compareEntities(baseChildEntity_2, entityManager.getEntitiesList().getLast()));
    }

    @Test
    public void userCanAddEqualsEntitiesList() {
        entityManager.addEntity(baseEntity_1);
        entityManager.addEntity(baseEntity_1);
        assertEquals(2, entityManager.getEntitiesList().size());
        assertTrue(compareEntities(baseEntity_1, entityManager.getEntitiesList().getFirst()));
        assertTrue(compareEntities(baseEntity_1, entityManager.getEntitiesList().getLast()));
    }

    @Test
    public void userCannotAddNullEntity() {
        Entity entity = null;
        assertThrows(IllegalArgumentException.class, () -> entityManager.addEntity(entity),
                "При добавлении сущности = null, не выбрасывается исключение IllegalArgumentException");
        assertEquals(0, entityManager.getEntitiesList().size());
    }
}
