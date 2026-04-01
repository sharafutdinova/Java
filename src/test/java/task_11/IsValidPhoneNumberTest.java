package task_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsValidPhoneNumberTest extends TestSetup {
    /**
     * Проверка метода, который проверяет валидность телефонного номера
     * Корректные номера
     * - "+1 1234567890" -> true
     * - "+44 9876543210" -> true
     * - "+999 1111111111" -> true
     * Некорректные номера
     * - без + "1 1234567890" -> false
     * - строковый "invalid" → false
     * - строки и числа "+1 abcdefghij" → false
     * - слишком длинный код страны "+1234 1234567890" → false
     * - недостаточно цифр "+1 123" → false
     * - пустая строка "" → false
     * Негативные тесты
     * - null -> NullPointerException
     */

    @ParameterizedTest
    @ValueSource(strings = {"+1 1234567890", "+44 9876543210", "+999 1111111111"})
    public void userCanCheckIsValidPhoneNumberForValidNumbers(String number) {
        boolean actualResult = methodsForTests.isValidPhoneNumber(number);
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 1234567890", "invalid", "+1 abcdefghij", "+1234 1234567890", "+1 123", ""})
    public void userCanCheckIsValidPhoneNumberForInValidNumbers(String number) {
        boolean actualResult = methodsForTests.isValidPhoneNumber(number);
        assertFalse(actualResult);
    }

    @Test
    public void userCanNotCheckIsValidPhoneNumberForNull() {
        assertThrows(NullPointerException.class, () -> {
            methodsForTests.isValidPhoneNumber(null);
        }, "Checking is phone valid for null value should lead to NullPointerException");
    }
}
