package practice_11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateLengthTest extends StringProcessorTest {
    /**
     * Тесты на валидацию длины
     * позитивные сценарии
     * "Alsu", 3 -> "Alsu"
     * "Alsu", 4 -> "Alsu"
     * негативный сценарий
     * "Alsu", 5 -> IllegalArgumentException
     * угловые сценарии
     * "Alsu", 0 -> "Alsu"
     * "", 0 -> ""
     * "hello", -1 -> IllegalArgumentException
     */
    public static Stream<Arguments> stringForValidationPositiveCases() {
        return Stream.of(
                Arguments.of("Alsu", 3),
                Arguments.of("Alsu", 4),
                Arguments.of("Alsu", 0),
                Arguments.of("", 0));
    }

    @ParameterizedTest
    @MethodSource("stringForValidationPositiveCases")
    public void userCanValidateStringWithLengthMoreOrEqualValue(String initString, int minLength) {
        String actualResult = stringProcessor.validateLength(initString, minLength);
        assertEquals(actualResult, initString);
    }

    public static Stream<Arguments> stringForValidationNegativeCases() {
        return Stream.of(
                Arguments.of("Alsu", 5),
                Arguments.of("hello", -1));
    }

    @ParameterizedTest
    @MethodSource("stringForValidationNegativeCases")
    public void userCanNotValidateStringWithLengthLessThanMinValue(String initString, int minLength) {
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessor.validateLength(initString, minLength);
        }, "Validation of string with length less than minValue should lead to IllegalArgumentException");
    }

}
