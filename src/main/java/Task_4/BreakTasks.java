package Task_4;

import java.util.Scanner;

public class BreakTasks {
    public static void main(String[] args) {
//        printPositiveSum();
//        printDigits();
        printPositiveNumbers();
//        askCommand();
    }

    public static void printPositiveSum() {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int num;
        while (true) {
            System.out.print("Введите число ");
            num = scan.nextInt();
            if (num < 0) break;
            sum += num;
        }
        System.out.println(sum);
    }

    public static void printDigits() {
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) continue;
            System.out.println(i);
        }
    }

    public static void printPositiveNumbers() {
        Scanner scan = new Scanner(System.in);
        int num;
        int count = 1;
        do {
            System.out.print("Введите число ");
            num = scan.nextInt();
            count++;
            if (num <= 0) continue;
            System.out.println(num);
        }
        while (num != 0);
    }

    public static void askCommand() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду ");
            String command = scan.nextLine();
            if (command.equals("stop")) break;
            System.out.println("Введенная команда " + command);
        }
    }
}
