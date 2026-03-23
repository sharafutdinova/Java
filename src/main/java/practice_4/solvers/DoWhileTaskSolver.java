package practice_4.solvers;

import java.util.Random;
import java.util.Scanner;

public class DoWhileTaskSolver {
    public static void main(String[] args) {
//        findNum(5);
//        findMin();
        checkCreds();
    }

    public static void findNum(int bound) {
        Scanner scan = new Scanner(System.in);

        int rand = new Random().nextInt(bound);
        int num;
        do {
            System.out.println("Enter num: ");
            num = scan.nextInt();
        }
        while (num != rand);
        System.out.println("Correct");
    }

    public static void findMin() {
        Scanner scan = new Scanner(System.in);
        int num;
        int min = 2147483647;
        do {
            System.out.print("Enter num: ");
            num = scan.nextInt();
            if (num < min && num >= 0) min = num;
        }
        while (num >= 0);
        System.out.println(min);
    }

    public static void checkCreds() {
        Scanner scan = new Scanner(System.in);
        String login;
        String pass;
        do {
            System.out.print("Enter login: ");
            login = scan.nextLine();
            System.out.print("Enter password: ");
            pass = scan.nextLine();
        }
        while (!login.equals("admin") || !pass.equals("123"));
        System.out.println("Loged in");
    }

}
