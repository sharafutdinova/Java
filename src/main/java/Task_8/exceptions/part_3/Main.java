package Task_8.exceptions.part_3;

public class Main {
    public static void main(String[] args) {
//        3. Создание и использование собственного проверяемого исключения
//        Условие задачи: Разработайте метод, который проверяет валидность возраста пользователя. Если возраст меньше 0 или больше 150,
//        метод должен выбрасывать проверяемое исключение.
        try {
            System.out.println(checkAge(-10));
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkAge(Integer age) throws AgeException {
        if (age >= 0 && age <= 150) return true;
        else throw new AgeException("Некорректный возраст");
    }
}
