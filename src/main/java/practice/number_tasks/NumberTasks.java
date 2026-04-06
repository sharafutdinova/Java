package practice.number_tasks;

public class NumberTasks {
    static void main(String[] args) {
//        System.out.println(factorial(4));
//        System.out.println(isSimple(13));
//        System.out.println(isSimple(21));
//        formatNumber(3.1423);
//        System.out.println(isPalindrome(101));
//        System.out.println(isPalindrome(200));
        System.out.println(isPalindrome_v2(1212));
        System.out.println(isPalindrome_v2(1234321));
        System.out.println(factorialRecurs(4));
    }

    //Факториал
    public static int factorial(int num) {
        if (num < 0) throw new IllegalArgumentException("Number cannot be negative");
        if (num == 0 || num == 1) return 1;
        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    //Факториал с рекурсией
    public static int factorialRecurs(int n) {
        if (n <= 1) return 1;
        return n * factorialRecurs(n - 1);
    }

    //Проверка на простоту
    public static boolean isSimple(int num) {
        if (num < 0) throw new IllegalArgumentException("Number cannot be negative");
        if (num == 0 || num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Форматированный вывод числе
    public static void formatNumber(double num) {
        System.out.printf("%.2f", num);
        System.out.println(String.format("%.2f", num));
    }

    public static boolean isPalindrome(int n) {
        int rev = 0, original = n;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
            System.out.println("n = " + n);
            System.out.println("rev = " + rev);
        }
        return original == rev;
    }

    public static boolean isPalindrome_v2(int n) {
        String num = String.valueOf(n);
        int len = num.length() - 1;
        int counter = 0;
        while (counter <= len / 2) {
            if (num.charAt(counter) == num.charAt(len - counter)) {
                counter++;
            } else return false;
        }
        return true;
    }
}
