package task_11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindSecondMaxTest extends TestSetup {
    /**
     * Проверка метода, который находит второе по величине число
     * Положительные тесты
     * - положительные разные числа [1,2,5,3] -> 3
     * - отрицательные числа [-2,-6,-3,-2] -> -3 (но в результате получаю -2)
     * Корнер кейс
     * - два числа [1,2] -> 1
     * Негативные тесты
     * - одинаковые числа [2,2,2,2] -> NoSuchElementException
     * - один элемент в массиве [1] -> NoSuchElementException
     * - пустой массив [] -> NoSuchElementException
     */
    public static Stream<Arguments> positiveCasesForFindSecondMaxTest() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5, 3}, 3),
                Arguments.of(new int[]{-2, -6, -3, -2}, -3),
                Arguments.of(new int[]{1, 2}, 1));
    }

    @ParameterizedTest
    @MethodSource("positiveCasesForFindSecondMaxTest")
    public void userCanFindSecondMaxInArray(int[] array, int expectedResult) {
        int actualResult = methodsForTests.findSecondMax(array);
        assertEquals(expectedResult, actualResult);
    }

    public static Stream<Arguments> NegativeCasesForFindSecondMaxTest() {
        return Stream.of(
                Arguments.of(new int[]{1}, "array with only one value"),
                Arguments.of(new int[]{}, "empty array"),
                Arguments.of(new int[]{1, 1, 1}, "array consisting of duplicates"));
    }

    @ParameterizedTest
    @MethodSource("NegativeCasesForFindSecondMaxTest")
    public void userCanNotFindSecondMaxInArray(int[] array, String message) {
        assertThrows(NoSuchElementException.class,
                () -> methodsForTests.findSecondMax(array), "Findind second max in " + message + " should lead to NoSuchElementException");
    }
}
