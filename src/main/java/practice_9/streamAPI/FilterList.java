package practice_9.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FilterList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        IntStream intStream = numbers.stream()
                .filter(x -> {
                    System.out.println("Filter " + x);
                    return x % 2 == 0;
                })
                .mapToInt(n -> {
                    System.out.println("map " + n);
                    return n;
                });
        System.out.println("Start");
        int sum = intStream.sum();
        System.out.println("End");
        System.out.println(sum);
    }
}
