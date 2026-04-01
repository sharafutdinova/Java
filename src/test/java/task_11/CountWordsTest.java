package task_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountWordsTest extends TestSetup {
    /**
     * Проверка метода, который считает количество слов в строке
     * Положительные тесты
     * - несколько слов в строке "Доброе утро мир!" -> 3
     * - одно слово "Привет" -> 1
     * - несколько пробелов подряд "Сегодня  1 апреля" -> 3
     * - лишние пробелы " Сегодня 1 апреля " -> 3
     * Корнер кейс
     * - пустая строка "" -> 0
     * - только пробел " " -> 0
     * Негативные тесты
     * - null -> NullPointerException
     */

    public static Stream<Arguments> positiveCasesForCountWordsTest() {
        return Stream.of(
                Arguments.of("Доброе утро мир!", 3),
                Arguments.of("Привет", 1),
                Arguments.of(" Сегодня 1 апреля ", 3),
                Arguments.of("Сегодня  1 апреля", 3),
                Arguments.of("", 0),
                Arguments.of(" ", 0));
    }

    @ParameterizedTest
    @MethodSource("positiveCasesForCountWordsTest")
    public void userCanGetCountOfWords(String inputString, int expectedResult) {
        int actualResult = methodsForTests.countWords(inputString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void userCanNotGetCountOfWordsForNull() {
        assertThrows(NullPointerException.class,
                () -> methodsForTests.countWords(null), "Getting count of words for null should lead to NullPointerException");
    }
}
