public class MathOperations {
    public static void main(String[] args) {
        int x = 10;
        int y = 7;
        int add1 = add(x, y);
        int subtract1 = subtract(x, y);
        int multiply1 = multiply(x, y);
        double divide = divide(x, y);
        System.out.println("Сумма " + add1);
        System.out.println("Разница " + subtract1);
        System.out.println("Произведение " + multiply1);
        System.out.println("Деление " + divide);
        System.out.println("Максимум " + findMax(x, y));
        System.out.println("Модуль разницы " + difference(x, y));
        System.out.println("Модуль разницы " + difference(y, x));
        System.out.println("Площадь " + squareArea(x));
        System.out.println("Периметр " + squarePerimeter(x));
        System.out.println("Минуты " + convertSecondsToMinutes(120));
        System.out.println("Скорость " + averageSpeed(100, 50));
        System.out.println("Скорость " + averageSpeed(4560, 0));
        System.out.println("Гипотенуза " + findHypotenuse(2, 3));
        System.out.println("Гипотенуза " + findHypotenuse(x, y));
        System.out.println("Длина окружности " + circleCircumference(x));
        System.out.println("Длина окружности " + circleCircumference(y));
        System.out.println("Процент " + calculatePercentage(200, 25));
        System.out.println("Процент " + calculatePercentage(0, 12));
        System.out.println("В цельсий " + fahrenheitToCelsius(200));
        System.out.println("В фаренгейт " + celsiusToFahrenheit(20));
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static double divide(int x, int y) {
        return (double) x / y;
    }

    public static int findMax(int a, int b) {
        return Math.max(a, b);
    }

    public static int difference(int a, int b) {
        return Math.abs(a - b);
    }

    public static int squareArea(int side) {
        return side * side;
    }

    public static int squarePerimeter(int side) {
        return side * 4;
    }

    public static double convertSecondsToMinutes(int seconds) {
        return (double) seconds / 60;
    }

    public static double averageSpeed(double distance, double time) {
        if (time > 0) {
            return distance / time;
        } else {
            return -1;
        }
    }

    public static double findHypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static String calculatePercentage(double total, double part) {
        if (total != 0) {
            return part / total * 100 + "%";
        } else {
            return "Значение тотал не должно быть 0";
        }
    }

    public static double celsiusToFahrenheit(double c) {
        return c * 9 / 5 + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
}
