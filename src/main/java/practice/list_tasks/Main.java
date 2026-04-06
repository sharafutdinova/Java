package practice.list_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static void main(String[] args) {
//        Stream.of("x", "y", "z")
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s + s;
//                })
//                .limit(2)
//                .forEach(s -> System.out.println("out: " + s));

        Stream.of("a", "bb", "ccc", "dd")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() > 1;
                })
                .sorted((a, b) -> {
                    System.out.println("comparing: " + a + " & " + b);
//                    return b.length() - a.length();//по возрастанию длины
                    System.out.println(a.length() - b.length());
                    return a.length() - b.length();//по убыванию длины
                })
                .forEach(System.out::println);
    }
}
