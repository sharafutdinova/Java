package Task_9.func_interface;

@FunctionalInterface
public interface MathOperation {
    double operate  (double x, double y) throws ArithmeticException;
}
