package practice_4.solvers;

public class ForTaskSolver {
    public static void main(String[] args) {
//        multTable(5);
        System.out.println(sumOfAllNumbers(6));
        System.out.println(checkNumIsSimple(6));
        System.out.println(checkNumIsSimple(7));
//        printSimpleNums();
    }

    public static void multTable(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i * number);
        }
    }

    public static int sumOfAllNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean checkNumIsSimple(int num) {
        boolean isSimple = true;
        for (int i = 2; i <= num - 1; i++) {
            if (num % i == 0) {
                isSimple = false;
                break;
            }
        }
        return isSimple;
    }

    public static void printSimpleNums() {
        for (int i = 2; i <= 100; i++) {
            if (checkNumIsSimple(i)) {
                System.out.println(i);
            }
        }
    }
}
