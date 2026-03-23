package practice_4.solvers;

import practice_4.Season;

import java.util.Scanner;

public class WhileTaskSolver {
    public static void main(String[] args) {
//        printAllNumsBefore10();
//        commandReader();
        System.out.println(sumOfDigits(123));
    }

    public static void printAllNumsBefore10() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    public static void commandReader() {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {
            System.out.print("Введите команду: ");
            command = scanner.nextLine();
        }
        System.out.println("Exit");
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 9) {
            sum += num % 10;
            num = num / 10;
        }
        sum += num;
        return sum;
    }
}
