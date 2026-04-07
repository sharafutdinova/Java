package task_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class IsValidEmailTest extends TestSetup {
    /**
     * Проверка метода,  который проверяет, является ли строка валидным email
     * Положительные тесты
     * валидная почта
     * - "test@example.com" -> true
     * - с числами "123@mail.ru" -> true
     * - с тире "123-mail@mail.ru" -> true
     * - с точкой "123.mail@mail.ru" -> true
     * - с субдоменом "123@subdomain.mail.ru" -> true
     * невалидная почта
     * - некорректный домен "bad@.com" -> false
     * - некорректный домен "bad@mail.c" -> false
     * - нет имени "@test.com" -> false
     * - нет @ "123mail.ru" -> false
     * - нет . в домене "123@mail" -> false
     * - пробел "123 mail@mail.ru" -> false
     * - две @ "123mail@@mail.ru" -> false
     * - пустая строка "" -> false
     * Негативные тесты
     * - null -> IllegalArgumentException
     */

    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "123@mail.ru", "123-mail@mail.ru", "123.mail@mail.ru", "123@subdomain.mail.ru"})
    public void userCanCheckIsEmailValidForValidEmails(String email) {
        boolean actualResult = methodsForTests.isValidEmail(email);
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"bad@.com", "bad@mail.c", "@test.com", "123mail.ru", "123@mail", "123 mail@mail.ru", "123mail@@mail.ru", ""})
    public void userCanCheckIsEmailValidForInvalidEmails(String email) {
        boolean actualResult = methodsForTests.isValidEmail(email);
        assertFalse(actualResult);
    }

    @Test
    public void userCanNotCheckIsEmailValidForNull() {
        assertThrows(IllegalArgumentException.class, () ->
                methodsForTests.isValidEmail(null), "Checking is email valid for null value should lead to IllegalArgumentException");
    }
}
