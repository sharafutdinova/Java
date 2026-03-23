package Task_4;

import java.util.Scanner;

public class SwitchTasks {
    public static void main(String[] args) {
//        printWeekDay();
//        printTicketPrice();
//        convertDigits();
//        printMessage();
        mathOperations();
    }

    public static void printWeekDay() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число от 1 до 7: ");
        int day = scan.nextInt();
        String weekDay = switch (day) {
            case 1 -> "Понедельник";
            case 2 -> "Вторник";
            case 3 -> "Среда";
            case 4 -> "Четверг";
            case 5 -> "Пятница";
            case 6 -> "Суббота";
            case 7 -> "Воскресенье";
            default -> "Некорректное значение";
        };
        System.out.println(weekDay);
    }

    public static void printTicketPrice() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число от 1 до 7: ");
        int day = scan.nextInt();
        int price = 0;
        if (day >= 1 && day <= 5) price = 300;
        else if (day == 6 || day == 7) price = 450;
        System.out.println("стоимость билета в кино " + price + "руб.");
    }

    public static void convertDigits() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число от 0 до 100: ");
        int number = scan.nextInt();
        String value = "incorrect value";
        if (number >= 90 && number <= 100) {
            value = "A";
        } else if (number >= 80 && number < 90) {
            value = "B";
        } else if (number >= 70 && number < 80) {
            value = "C";
        } else if (number >= 60 && number < 70) {
            value = "D";
        } else if (number < 60) {
            value = "F";
        }
        System.out.println("Буквенная оценка: " + value);
    }

    public static void printMessage() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите команду: ");
        String command = scan.nextLine();
        String message = switch (command) {
            case "start" -> "Система запущена";
            case "stop" -> "Система остановлена";
            case "restart" -> "Система перезапущена";
            case "status" -> "Система работает";
            default -> "Некорректная команда";
        };
        System.out.println(message);
    }

    public static void mathOperations() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число 1: ");
        int num_1 = scan.nextInt();
        System.out.print("Введите число 2: ");
        int num_2 = scan.nextInt();
        scan.nextLine();
        System.out.print("Введите операцию +, -, *, /: ");
        String operation = scan.nextLine();
        int result = 0;
        String error = "";
        switch (operation) {
            case "+":
                result = num_1 + num_2;
                break;
            case "-":
                result = num_1 - num_2;
                break;
            case "*":
                result = num_1 * num_2;
                break;
            case "/":
                if (num_2 != 0)
                    result = num_1 / num_2;
                else error = "Нельзя делить на 0";
                break;
            default:
                error = "Некорректная операция";
        }
        if (!error.isEmpty())
            System.out.println(error);
        else
            System.out.println(result);
    }
}
