package task_11;

import Task_11.MethodsForTests;
import org.junit.jupiter.api.BeforeEach;

public class TestSetup {
    protected MethodsForTests methodsForTests;

    @BeforeEach
    public void setupTest() {
        methodsForTests = new MethodsForTests();
    }
}
