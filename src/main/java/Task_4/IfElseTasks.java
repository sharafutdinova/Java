package Task_4;

import java.util.Scanner;

public class IfElseTasks {
    public static void main(String[] args) {
//        checkNum();
//        findMax();
//        printGrade();
//        System.out.println(checkChetnost());
//        calcDiscount();
        printTestResult();
    }

    public static void checkNum() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();
        if (num > 0) {
            System.out.println("Число положительное");
        } else if (num < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число равно нулю");
        }
    }

    public static void findMax() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число 1: ");
        int num_1 = scan.nextInt();
        System.out.print("Введите число 2: ");
        int num_2 = scan.nextInt();
        System.out.println(Math.max(num_1, num_2));
    }

    public static void printGrade() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число от 1 до 5: ");
        int num = scan.nextInt();
        String result = switch (num) {
            case 1 -> "Неудовлетворительно";
            case 2 -> "Неудовлетворительно";
            case 3 -> "Удовлетворительно";
            case 4 -> "Хорошо";
            case 5 -> "Отлично";
            default -> "Недопустимое значение";
        };
        System.out.println(result);
    }

    public static String checkChetnost() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();
        return (num % 2 == 0) ? "чётное" : "нечетное";
    }

    public static void calcDiscount() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите возраст: ");
        int age = scan.nextInt();
        int discount = 0;
        if (age < 18) discount = 25;
        else if (age >= 65) discount = 30;
        System.out.println("Скидка " + discount + "%");
    }

    public static void printTestResult() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите баллы: ");
        int points = scan.nextInt();
        String result = "";
        if (points >= 90) result = "Отлично";
        else if (points >= 75) result = "Хорошо";
        else if (points >= 60) result = "Удовлетворительно";
        else result = "Неудовлетворительно";
        System.out.println(result);
    }
}
