package Task_8.exceptions.part_2;

public class Main {
    public static void main(String[] args) {
//        2. Обработка непроверяемого исключения
//        Условие задачи: Напишите метод, который принимает на вход два числа и выполняет их деление. Обработайте ситуацию,
//        когда второе число равно нулю, чтобы избежать исключения при делении.
        try {
            System.out.println(division(1, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double division(double a, double b) throws RuntimeException {
        if (b == 0) throw new ArithmeticException("Деление на 0");
        return a / b;
    }
}
