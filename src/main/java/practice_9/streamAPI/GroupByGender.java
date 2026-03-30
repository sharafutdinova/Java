package practice_9.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGender {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alsu:W", "Anna:W", "Sam:M");
        Map<String, List<String>> groupedByGender = names.stream()
                .collect(Collectors.groupingBy(name -> {
                            System.out.println("Key " + name);
                            return name.split(":")[1];
                        },
                        Collectors.mapping(name -> {
                                    System.out.println("value " + name);
                                    return name.split(":")[0];
                                },
                                Collectors.toList()
                        )));

        System.out.println("Start");
        System.out.println(groupedByGender);
        System.out.println("End");
    }
}
