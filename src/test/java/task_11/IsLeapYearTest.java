package task_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IsLeapYearTest extends TestSetup {
    /**
     * Проверка метода, который определяет, является ли год високосным
     * Положительные тесты
     * - Обычные (2026, 1999) -> false
     * - Високосные (2020, 2000, 1600) -> true
     * Корнер кейсы
     * - Года, которые делятся на 100, но не на 400 (1900, 2100) -> false
     * - 0 -> true
     * Негативные тесты
     * - отрицательное число -> IllegalArgumentException
     */

    public static Stream<Arguments> positiveCasesForIsLeapYearTest() {
        return Stream.of(
                Arguments.of(2026, false),
                Arguments.of(2000, true),
                Arguments.of(2024, true),
                Arguments.of(2100, false),
                Arguments.of(1800, false),
                Arguments.of(0, true));
    }

    @ParameterizedTest
    @MethodSource("positiveCasesForIsLeapYearTest")
    public void userCanCheckIsLeapYear(int year, boolean expectedValue) {
        boolean actualResult = methodsForTests.isLeapYear(year);
        assertEquals(expectedValue, actualResult);
    }

    @Test
    public void userCanNotCheckIsLeapYearForNegativeValue() {
        int year = -100;
        assertThrows(IllegalArgumentException.class, () -> {
            methodsForTests.isLeapYear(year);
        }, "Checking is leap year for negative value should lead to IllegalArgumentException");
    }
}
