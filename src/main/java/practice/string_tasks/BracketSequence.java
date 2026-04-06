package practice.string_tasks;

import java.util.*;

public class BracketSequence {
    static void main(String[] args) {
        System.out.println(checkBracketSequence("((())"));
        System.out.println(checkBracketSequence("(({()})))"));
        System.out.println(checkBracketSequence("(({(){}}()))"));
        System.out.println(isBalanced("((())"));
        System.out.println(isBalanced("((())))"));
    }

    //Проверка скобочной последовательности
    public static boolean checkBracketSequence(String strings) {
        if (strings == null || strings.length() == 0)
            throw new IllegalArgumentException("String cannot be null or empty");
        LinkedList<Character> queue = new LinkedList<>() {
        };
        for (char c : strings.toCharArray()) {
            if (c == '(' || c == '{') {
                queue.addLast(c);
            } else if (c == ')' || c == '}') {
                if (queue.isEmpty())
                    return false;
                if ((c == ')' && queue.getLast() != '(') || (c == '}' && queue.getLast() != '{'))
                    return false;
                queue.removeLast();
            }
        }
        return queue.isEmpty();
    }

    public static boolean isBalanced(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}
