package task_13.user_validation;

import Task_13.user_validation.InvalidUserException;
import Task_13.user_validation.User;
import Task_13.user_validation.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorСheckEmailTest {
//    Проверка email: Email должен соответствовать стандартному формату электронной почты.
//    Управление валидацией: Валидация данных должна происходить только если флаг validationEnabled установлен в true.
//    Исключения: При обнаружении невалидных данных необходимо выбрасывать InvalidUserException.

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
    public void userCanCheckValidEmailWithTurnedOnFlag(String email) {
        UserValidator.setValidationEnabled(true);
        User user = new User("Алсу", 30, email);
        assertDoesNotThrow(() -> UserValidator.checkEmail(user), "При проверке валидного email с включенным флагом выбросилось исключение");
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "123@mail.ru", "123-mail@mail.ru", "123.mail@mail.ru", "123@subdomain.mail.ru"})
    public void userCanCheckValidEmailWithTurnedOffFlag(String email) {
        UserValidator.setValidationEnabled(false);
        User user = new User("Алсу", 30, email);
        assertDoesNotThrow(() -> UserValidator.checkEmail(user), "При проверке валидного email с выключенным флагом выбросилось исключение");
    }

    @ParameterizedTest
    @ValueSource(strings = {"bad@.com", "bad@mail.c", "@test.com", "123mail.ru", "123@mail", "123 mail@mail.ru", "123mail@@mail.ru", ""})
    public void userCanCheckInvalidEmailWithTurnedOffFlag(String email) {
        UserValidator.setValidationEnabled(false);
        User user = new User("Алсу", 30, email);
        assertDoesNotThrow(() -> UserValidator.checkEmail(user), "При проверке невалидного email с выключенным флагом выбросилось исключение");
    }

    @ParameterizedTest
    @ValueSource(strings = {"bad@.com", "bad@mail.c", "@test.com", "123mail.ru", "123@mail", "123 mail@mail.ru", "123mail@@mail.ru", ""})
    public void userCanCheckInvalidEmailWithTurnedOnFlag(String email) {
        UserValidator.setValidationEnabled(true);
        User user = new User("Алсу", 30, email);
        assertThrows(InvalidUserException.class, () -> UserValidator.checkEmail(user), "При проверке невалидного email с включенным флагом не выбросилось исключение InvalidUserException");
    }

    @Test
    public void userCanCheckNullEmailWithTurnedOnFlag() {
        UserValidator.setValidationEnabled(true);
        User user = new User("Алсу", 30, null);
        assertThrows(InvalidUserException.class, () -> UserValidator.checkEmail(user), "При проверке email=null с включенным флагом не выбросилось исключение InvalidUserException");
    }

    @Test
    public void userCanCheckNullEmailWithTurnedOffFlag() {
        UserValidator.setValidationEnabled(false);
        User user = new User("Алсу", 30, null);
        assertDoesNotThrow(() -> UserValidator.checkEmail(user), "При проверке email=null с выключенным флагом выбросилось исключение");
    }
}
