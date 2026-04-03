package task_13.entity_manager;

import Task_13.entity_manager.Entity;
import Task_13.entity_manager.EntityChild;
import Task_13.entity_manager.EntityManager;
import Task_13.inventory_service.Product;
import org.junit.jupiter.api.BeforeEach;

public class EntityManagerTest {
    protected EntityManager<Entity> entityManager;

    protected Entity baseEntity_1 = new Entity("Alsu", 30, true);
    protected Entity baseChildEntity_2 = new EntityChild("Anna", 15, true);

    @BeforeEach
    public void testSetup() {
        entityManager = new EntityManager<>();
    }

    public boolean compareEntities(Entity expected, Entity actual) {
        return expected.getName().equals(actual.getName()) && expected.getAge()==actual.getAge() && expected.isActive() == actual.isActive();
    }
}
