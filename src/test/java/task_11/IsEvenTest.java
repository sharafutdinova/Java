package task_11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsEvenTest extends TestSetup {
    /**
     * Проверка числа на четность
     * Положительные тесты
     * - Чётные числа 10 -> true
     * - нечётные числа 3 -> false
     * - Нулевое значение 0 -> true
     * - Отрицательные числа -13 -> false
     * - Отрицательные числа -10 -> true
     */
    public static Stream<Arguments> positiveCasesForIsEvenTest() {
        return Stream.of(
                Arguments.of(10, true),
                Arguments.of(3, false),
                Arguments.of(0, true),
                Arguments.of(-13, false),
                Arguments.of(-10, true));
    }

    @ParameterizedTest
    @MethodSource("positiveCasesForIsEvenTest")
    public void checkingThatNumbersCanBeCheckedForEvenness(int number, boolean expectedResult) {
        boolean actualResult = methodsForTests.isEven(number);
        assertEquals(expectedResult, actualResult);
    }
}
