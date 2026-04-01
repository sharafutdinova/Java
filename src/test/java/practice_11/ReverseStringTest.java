package practice_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Class StringProcessor method reverse")
public class ReverseStringTest extends StringProcessorTest {
    /**
     * Тесты для переворота строки:
     * happy path: "Alsu" -> "uslA"
     * corner cases:
     * "" -> ""
     * "a" -> "a"
     * null -> IllegalArgument Exception
     */
    public static Stream<Arguments> validStringToReverse() {
        return Stream.of(
                //happy path: "Alsu" -> "uslA"
                Arguments.of("Alsu", "uslA"),
                //happy path: "" -> ""
                Arguments.of("", ""),
                //happy path: "A" -> "A"
                Arguments.of("A", "A"));
    }

    @ParameterizedTest
    @MethodSource("validStringToReverse")
    public void userCanReverseValidString(String initString, String expectedString) {
        String reversedString = stringProcessor.reverse(initString);
        assertEquals(expectedString, reversedString, "Wrong result!");
    }

    @Test
    public void userCanNotReverseNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessor.reverse(null);
        }, "Reversing of null string should lead to IllegalArgumentException");
    }
}
