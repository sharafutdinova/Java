package task_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseTest extends TestSetup {
    /**
     * Проверка метода по переворачиванию строки
     * Положительные тесты
     * - обычная строка "Alsu" -> "uslA"
     * - строка с символами и пробелами "Today is 31!" -> "!13 si yadoT"
     * корнер кейс
     * - пустая строка "" -> ""
     * - null -> null
     */
    public static Stream<Arguments> positiveCasesForReverseTest() {
        return Stream.of(
                Arguments.of("Alsu", "uslA"),
                Arguments.of("Today is 31!", "!13 si yadoT"),
                Arguments.of("", ""));
    }

    @ParameterizedTest
    @MethodSource("positiveCasesForReverseTest")
    public void userCanGetReversedString(String initValue, String expectedValue) {
        String actualResult = methodsForTests.reverse(initValue);
        assertEquals(expectedValue, actualResult);
    }

    @Test
    public void userCanGetReversedStringForNull() {
        String initValue = null;
        String actualResult = methodsForTests.reverse(initValue);
        assertEquals(initValue, actualResult);
    }
}
