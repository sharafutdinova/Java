package Task_9.func_interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    static void main(String[] args) {
//        3. Лямбда-выражение с Predicate
//        Задача: Напишите лямбду, которая проверяет, является ли число чётным.
        Predicate<Integer> parityCheck = (x) -> x % 2 == 0;
        System.out.println("Проверка на четность: " + parityCheck.test(5));
        System.out.println("Проверка на четность: " + parityCheck.test(4));

//        4. Лямбда-выражение с Function
//        Задача: Создайте лямбду, которая принимает строку и возвращает её длину.
        Function<String, Integer> getLength = String::length;
        System.out.println("Длина строки: " + getLength.apply("Hello"));
        System.out.println("Длина строки: " + getLength.apply(""));

//        5. Использование Consumer
//        Задача: Напишите лямбду, которая принимает строку и печатает её в консоль.
        Consumer<String> printString = System.out::println;
        printString.accept("Hello!");
    }
}
