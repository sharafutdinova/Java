package practice.string_tasks;

import java.util.HashMap;

//Количество каждого символа в строке
public class CountOfEachSymbol {
    static void main(String[] args) {
        System.out.println(calculateCountOfEachChar("aa"));//a 2
        System.out.println(calculateCountOfEachChar("race a car"));//r 2, c 2, a 3, e 1, 2
    }

    public static HashMap<Character, Integer> calculateCountOfEachChar(String string) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : string.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c,0) + 1);
        }
        return hashMap;
    }
}
