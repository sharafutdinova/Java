package Task_13.user_validation;

import lombok.Getter;

import java.util.Objects;

public class UserValidator {
    //    Описание:
//    Разработайте систему валидации для модели данных пользователя, которая проверяет корректность имени, возраста и электронной почты.
//    Валидация должна управляться через глобальный флаг validationEnabled, который может быть включен или выключен. Если данные не проходят валидацию,
//    должно выбрасываться специализированное исключение InvalidUserException.
//
//    Модель данных:
//    User: Класс пользователя с атрибутами для имени, возраста и электронной почты.
//    Класс валидатора:
//    UserValidator: Сервис, который предоставляет методы для проверки объектов User на соответствие определенным правилам.
//    Функциональные требования:
//    Проверка имени: Имя должно быть не пустым и начинаться с заглавной буквы.
//    Проверка возраста: Возраст должен быть в пределах от 18 до 100 лет.
//    Проверка email: Email должен соответствовать стандартному формату электронной почты.
//    Управление валидацией: Валидация данных должна происходить только если флаг validationEnabled установлен в true.
//    Исключения: При обнаружении невалидных данных необходимо выбрасывать InvalidUserException.
    @Getter
    private static boolean validationEnabled = true;

    public static void setValidationEnabled(boolean validationEnabled) {
        UserValidator.validationEnabled = validationEnabled;
    }

    public static void checkName(User user) throws InvalidUserException {
        if (validationEnabled) {
            String name = user.getName();
            boolean isCorrect = !Objects.equals(name, "") && name != null;
            if (isCorrect) isCorrect = Character.isUpperCase(name.charAt(0));
            if (!isCorrect)
                throw new InvalidUserException("Некорректное имя пользователя, имя должно быть не пустым и с заглавной буквы.");
        }
    }

    public static void checkAge(User user) throws InvalidUserException {
        if (validationEnabled) {
            int age = user.getAge();
            boolean isCorrect = age >= 18 && age <= 100;
            if (!isCorrect)
                throw new InvalidUserException("Некорректный возраст пользователя, должен быть в диапазоне от 18 до 100.");
        }
    }

    public static void checkEmail(User user) throws InvalidUserException {
        if (validationEnabled) {
            String email = user.getEmail();
            boolean isCorrect = email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
            if (!isCorrect) throw new InvalidUserException("Некорректный формат email пользователя");
        }
    }
}
