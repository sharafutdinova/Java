package practice_9.func_interface;

@FunctionalInterface
public interface Checker {
    boolean check(int number);

    default void printIfValid(int number) {
        if (check(number))
            System.out.println(number);
    }
}
