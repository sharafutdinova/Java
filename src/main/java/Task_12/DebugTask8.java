package Task_12;

public class DebugTask8 {
    public static void main(String[] args) {
        double epsilon = 1e-9;
        double a = 0.1 * 3;
        double b = 0.3;
        if (areEqual(a, b, epsilon)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }

    public static boolean areEqual(double d1, double d2, double epsilon) {
        return Math.abs(d1 - d2) < epsilon;
    }
}

