package Task_4;

import java.util.Scanner;

public class DoWhileTasks {
    public static void main(String[] args) {
//        printPositiveNumber();
//        checkPassword();
//        printDigits();
//        waitExit();
        countOfDigits();
    }

    public static void printPositiveNumber() {
        Scanner scan = new Scanner(System.in);
        int num;
        do {
            System.out.print("Введите число: ");
            num = scan.nextInt();
        }
        while (num <= 0);
        System.out.println(num);
    }

    public static void checkPassword() {
        Scanner scan = new Scanner(System.in);
        String correctPass = "123";
        String pass;
        do {
            System.out.print("Введите пароль: ");
            pass = scan.nextLine();
        }
        while (!pass.equals(correctPass));
        System.out.println(pass);
    }

    public static void printDigits() {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        }
        while (i <= 10);
    }

    public static void waitExit() {
        Scanner scan = new Scanner(System.in);
        String command;
        do {
            System.out.print("Введите команду: ");
            command = scan.nextLine();
        }
        while (!command.equals("exit"));
        System.out.println(command);
    }

    public static void countOfDigits() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = scan.nextInt();
        int count = 0;
        do {
            num = num / 10;
            count++;
        }
        while (num > 0);
        System.out.println(count);
    }
}
