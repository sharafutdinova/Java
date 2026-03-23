package Task_4;

import java.util.Scanner;

public class ForTasks {
    public static void main(String[] args) {
//        printNumbers();
//        printSum();
//        printMultiplicationTable();
//        checkIsSimple();
        printDigits();
    }

    public static void printNumbers() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0)
                System.out.println(i);
        }
    }

    public static void printSum() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println("Сумма = " + sum);
    }

    public static void printMultiplicationTable() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * " + num + " = " + i * num);
        }
    }

    public static void checkIsSimple() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.print(isPrime ? "Простое" : "Непростое");
    }

    public static void printDigits() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
