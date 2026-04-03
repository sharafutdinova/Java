package task_13.user_validation;

import Task_13.user_validation.InvalidUserException;
import Task_13.user_validation.User;
import Task_13.user_validation.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorСheckNameTest {
    /**
     * Функциональные требования:
     * Проверка имени: Имя должно быть не пустым и начинаться с заглавной буквы.
     * Управление валидацией: Валидация данных должна происходить только если флаг validationEnabled установлен в true.
     * Исключения: При обнаружении невалидных данных необходимо выбрасывать InvalidUserException.
     * Валидное имя с вкл. флагом "Алсу" -> "Имя пользователя корректное"
     * Валидное имя с выкл. флагом "Алсу"
     * Невалидное имя с маленькой буквы с выкл. флагом "алсу"
     * Невалидное имя с маленькой буквы с вкл. флагом "алсу" -> InvalidUserException
     * Невалидное пустое имя с выкл. флагом "", null
     * Невалидное пустое имя с вкл. флагом "", null -> InvalidUserException
     */
    @Test
    public void userCanCheckValidNameWithTurnedOnFlag() {
        UserValidator.setValidationEnabled(true);
        User user = new User("Алсу", 30, "Al@mail.ru");
        assertDoesNotThrow(() -> UserValidator.checkName(user), "При проверке валидного имени с включенным флагом выбросилось исключение");
    }

    @Test
    public void userCanCheckValidNameWithTurnedOffFlag() {
        UserValidator.setValidationEnabled(false);
        User user = new User("Алсу", 30, "Al@mail.ru");
        assertDoesNotThrow(() -> UserValidator.checkName(user), "При проверке валидного имени с выключенным флагом выбросилось исключение");
    }

    @ParameterizedTest
    @ValueSource(strings = {"алсу", ""})
    public void userCanCheckInvalidNameWithTurnedOnFlag(String name) {
        UserValidator.setValidationEnabled(true);
        User user = new User(name, 30, "Al@mail.ru");
        assertThrows(InvalidUserException.class, () -> UserValidator.checkName(user), "При проверке невалидного имени с включенным флагом не выбросилось исключение InvalidUserException");
    }

    @ParameterizedTest
    @ValueSource(strings = {"алсу", ""})
    public void userCanCheckInvalidNameWithTurnedOffFlag(String name) {
        UserValidator.setValidationEnabled(false);
        User user = new User(name, 30, "Al@mail.ru");
        assertDoesNotThrow(() -> UserValidator.checkName(user), "При проверке невалидного имени с выключенным флагом выбросилось исключение");
    }

    @Test
    public void userCanCheckNullNameWithTurnedOnFlag() {
        UserValidator.setValidationEnabled(true);
        User user = new User(null, 30, "Al@mail.ru");
        assertThrows(InvalidUserException.class, () -> UserValidator.checkName(user), "При проверке имени = null с включенным флагом не выбросилось исключение InvalidUserException");
    }

    @Test
    public void userCanCheckNullNameWithTurnedOffFlag() {
        UserValidator.setValidationEnabled(false);
        User user = new User(null, 30, "Al@mail.ru");
        assertDoesNotThrow(() -> UserValidator.checkName(user), "При проверке имени = null с выключенным флагом выбросилось исключение");
    }
}
