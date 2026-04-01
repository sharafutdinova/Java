package task_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountVowelsTest extends TestSetup {
    /**
     * Проверка подсчета гласных символов с строке
     * Положительные тесты
     * - есть гласные символы "alsu" -> 2
     * - есть гласные символы с разным регистром "COMmon" -> 2
     * - все варианты гласных "eyuoai" -> 6
     * корнер кейс
     * - нет гласных "qwrtopsdfghjklzxcvbnm" -> 0
     * - пустая строка "" -> 0
     * Отрицательные
     * - null -> IllegalArgumentException
     */
    public static Stream<Arguments> positiveCasesForCountVowelsTest() {
        return Stream.of(
                Arguments.of("alsu", 2),
                Arguments.of("COMmon", 2),
                Arguments.of("eyuoai", 6),
                Arguments.of("qwrtpsdfghjklzxcvbnm", 0),
                Arguments.of("", 0));
    }

    @ParameterizedTest
    @MethodSource("positiveCasesForCountVowelsTest")
    public void userCanGetValidCountOfVowelsForString(String inputString, int expectedCount) {
        int actualResult = methodsForTests.countVowels(inputString);
        assertEquals(expectedCount, actualResult);
    }

    @Test
    public void userCanNotGetCountOfVowelsForNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            methodsForTests.countVowels(null);
        }, "Getting count of vowels chars for null string should lead to IllegalArgumentException");
    }
}
