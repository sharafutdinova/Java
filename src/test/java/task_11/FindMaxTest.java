package task_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindMaxTest extends TestSetup {
    /**
     * Проверка метода по нахождению максимума в массиве чисел
     * Положительные тесты
     * - положительные числа [0,1,2,3,2] -> 3
     * - одинаковые числа [1,1,1] -> 1
     * - отрицательные числа [-1,-2,-3] -> -1
     * корнер кейс
     * - одно число [10] -> 10
     * Негативные тесты
     * - пустой массив [] -> NoSuchElementException
     * - null -> NullPointerException
     */

    public static Stream<Arguments> positiveCasesForFindMaxTest() {
        return Stream.of(
                Arguments.of((Object) new int[]{0, 1, 2, 3}),
                Arguments.of((Object) new int[]{1, 1, 1}),
                Arguments.of((Object) new int[]{-1, -2, -3}),
                Arguments.of((Object) new int[]{10}));
    }

    @ParameterizedTest
    @MethodSource("positiveCasesForFindMaxTest")
    public void userCanGetMaxNumberFromArray(int[] array) {
        int actualValue = methodsForTests.findMax(array);
        int expectedValue = Arrays.stream(array).max().orElseThrow();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void userCanNotGetMaxNumberFromNullArray() {
        assertThrows(NullPointerException.class, () -> {
            methodsForTests.findMax(null);
        }, "Getting max value for null array should lead to NullPointerException");
    }

    @Test
    public void userCanNotGetMaxNumberFromEmptyArray() {
        assertThrows(NoSuchElementException.class, () -> {
            methodsForTests.findMax(new int[]{});
        }, "Getting max value for empty array should lead to NoSuchElementException");
    }
}
