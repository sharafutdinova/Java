package Task_4;

import java.util.Scanner;

public class WhileTasks {
    public static void main(String[] args) {
        factorial();
//        printChetnoe();
//        printCountdown();
    }

    public static void factorial() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите положительное число ");
        int num = scan.nextInt();
        if (num < 0) {
            System.out.println("введенное число не может быть отрицательным");
            return;
        }
        int i = 1;
        int mult = num == 0 ? 0 : 1;
        while (i <= num) {
            mult = mult * i;
            i++;
        }
        System.out.println(mult);
    }

    public static void printChetnoe() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();
        int i = 1;
        while (i <= num) {
            if (i % 2 == 0)
                System.out.println(i);
            i++;
        }
    }

    public static void printCountdown() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();
        int i = num;
        while (i > 0) {
            System.out.println(i);
            i--;
        }
    }
}
