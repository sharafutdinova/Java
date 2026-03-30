package Task_9.func_interface;

public class Main {
    public static void main(String[] args) {
//        1. Создайте свой функциональный интерфейс
//        Задача: Напишите интерфейс MathOperation, который принимает два числа и возвращает результат операции.
//        Реализуйте его с помощью лямбда-выражений: сложение, вычитание, умножение, деление.
        MathOperation sum = Double::sum;
        MathOperation subtraction = (x, y) -> x - y;
        MathOperation multiplication = (x, y) -> x * y;
        MathOperation division = (x, y) -> {
            if (y == 0) throw new ArithmeticException("Нельзя делить на 0");
            return x / y;
        };
        System.out.println("Сумма: " + sum.operate(1.0, 2.0));
        System.out.println("Вычитание: " + subtraction.operate(1.0, 2.0));
        System.out.println("Умножение: " + multiplication.operate(1.0, 2.0));
        System.out.println("Деление: " + division.operate(10.0, 5.0));
        try {
            System.out.println("Деление на 0: " + division.operate(1.0, 0.0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
