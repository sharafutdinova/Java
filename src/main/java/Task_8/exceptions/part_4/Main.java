package Task_8.exceptions.part_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //        4. Создание и использование собственного непроверяемого исключения
    //        Условие задачи: Напишите функцию, которая принимает строку в качестве аргумента и проверяет, является ли строка правильным электронным адресом.
    //        Если строка не удовлетворяет критериям, функция должна выбрасывать непроверяемое исключение.
    private static final String EMAIL_PATTERN =
            "^[\\w-\\.]+@([\\w-]+\\.)+[a-z]{2,4}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static void main(String[] args) {
        System.out.println(checkEmail("test@mail"));
    }

    public static boolean checkEmail(String email) {
        if (email == null) throw new EmailException("Null email");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) return true;
        else throw new EmailException("Invalid email");
    }
}
