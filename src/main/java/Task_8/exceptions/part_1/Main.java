package Task_8.exceptions.part_1;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
//        1. Обработка проверяемого исключения
//        Условие задачи:
//        Напишите программу, которая пытается открыть файл с именем "data.txt".
//        Если файл не найден, программа должна обработать исключение и вывести сообщение: "Файл не найден".
        try {
            FileReader fileReader = new FileReader("data.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
