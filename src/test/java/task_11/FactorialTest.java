package task_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest extends TestSetup {
    /**
     * Проверка метода, который вычисляет факториал числа
     * Положительные тесты
     * - положительные числа 3 -> 6
     * - положительные числа 1 -> 1
     * Корнер кейс
     * - 0 -> 1
     * Негативные тесты
     * - негативное число -10 -> IllegalArgumentException
     * - большое число 9999 -> IllegalArgumentException
     */

    public static Stream<Arguments> positiveCasesForFactorialTest() {
        return Stream.of(
                Arguments.of(3, 6),
                Arguments.of(1, 1),
                Arguments.of(0, 1));
    }

    @ParameterizedTest
    @MethodSource("positiveCasesForFactorialTest")
    public void userCanGetFactorialForPositiveNumber(int number, int expectedResult) {
        int actualResult = methodsForTests.factorial(number);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void userCanNotGetFactorialForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            methodsForTests.factorial(-100);
        }, "Calculating factorial for negative value should lead to IllegalArgumentException");
    }

    @Test
    public void userCanNotGetFactorialForLargeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            methodsForTests.factorial(9999);
        }, "Calculating factorial for large value should lead to IllegalArgumentException");
    }
}
