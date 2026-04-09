package task_13.user_validation;

import Task_13.user_validation.InvalidUserException;
import Task_13.user_validation.User;
import Task_13.user_validation.UserValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorCheckAgeTest {
//    Проверка возраста: Возраст должен быть в пределах от 18 до 100 лет.
//    Управление валидацией: Валидация данных должна происходить только если флаг validationEnabled установлен в true.
//    Исключения: При обнаружении невалидных данных необходимо выбрасывать InvalidUserException.

    /**
     * Валидный возраст с вкл. флагом - 30
     * Валидный возраст с выкл. флагом - 30
     * Валидные граничные значения с вкл. флагом - 18, 100
     * Невалидные граничные значения с вкл. флагом - 17, 101 -> InvalidUserException
     * Невалидный возраст с выкл. флагом - 0
     */

    @ParameterizedTest
    @ValueSource(ints = {30, 18, 100})
    public void userCanCheckValidAgeWithTurnedOnFlag(int age) {
        UserValidator.setValidationEnabled(true);
        User user = new User("Алсу", age, "Al@mail.ru");
        assertDoesNotThrow(() -> UserValidator.checkAge(user), "При проверке валидного возраста с включенным флагом выбросилось исключение");
    }

    @ParameterizedTest
    @ValueSource(ints = {30, 18, 100})
    public void userCanCheckValidAgeWithTurnedOffFlag(int age) {
        UserValidator.setValidationEnabled(false);
        User user = new User("Алсу", age, "Al@mail.ru");
        assertDoesNotThrow(() -> UserValidator.checkAge(user), "При проверке валидного возраста с выключенным флагом выбросилось исключение");
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 101, 0})
    public void userCanCheckInvalidAgeWithTurnedOffFlag(int age) {
        UserValidator.setValidationEnabled(false);
        User user = new User("Алсу", age, "Al@mail.ru");
        assertDoesNotThrow(() -> UserValidator.checkAge(user), "При проверке невалидного возраста с выключенным флагом выбросилось исключение");
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 101, 0})
    public void userCanCheckInvalidAgeWithTurnedOnFlag(int age) {
        UserValidator.setValidationEnabled(true);
        User user = new User("Алсу", age, "Al@mail.ru");
        assertThrows(InvalidUserException.class, () -> UserValidator.checkAge(user), "При проверке невалидного возраста с включенным флагом не выбросилось исключение InvalidUserException");
    }
}
