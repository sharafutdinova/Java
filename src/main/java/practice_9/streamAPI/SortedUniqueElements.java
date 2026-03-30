package practice_9.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortedUniqueElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 7, 0, 1, 5, 2, 3, 4, 5, 6, 7);
        List<Integer> uniqueSorted = numbers.stream()
                .distinct()
                .peek(n->System.out.println("distinct " + n))
                .sorted()
                .peek(n->System.out.println("sorted " + n))
                .toList();
        System.out.println("Start");
        System.out.println(uniqueSorted);
        System.out.println("End");
    }
}
