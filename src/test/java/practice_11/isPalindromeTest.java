package practice_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class isPalindromeTest extends StringProcessorTest {
    /**
     * Тесты для проверки, является ли строка палиндромом:
     * позитивные кейсы:
     * - четное количество: "QWEEWQ" -> "true"
     * - нечетное количество "QWEWQ" -> "true"
     * негативные кейсы:
     * - "Alsu" -> false
     * - "Aa" -> false
     * corner cases:
     * - "a" -> true
     * - "" -> true
     * - null -> IllegalArgumentException
     */
    @ParameterizedTest
    @ValueSource(strings = {"QWEEWQ", "QWEWQ", "a", "", " "})
    public void userCanCheckIfValidStringIsPalindrome(String initString) {
        boolean actualResult = stringProcessor.isPalindrome(initString);
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Alsu", "Aa"})
    public void userCanCheckIfValidStringIsNotPalindrome(String initString) {
        boolean actualResult = stringProcessor.isPalindrome(initString);
        assertFalse(actualResult);
    }


    @Test
    public void userCanNotCheckIfNullStringIsPalindrome() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessor.isPalindrome(null);
        }, "Checking of null string is palindrome should lead to IllegalArgumentException");
    }
}
