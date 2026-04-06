package practice.string_tasks;

//Переворот слов в строке
public class ReverseString {
    static void main(String[] args) {
        System.out.println(reverseWord("aa bb"));//bb aa
        System.out.println(reverseWord("A man, a plan, a canal: Panama"));
        System.out.println(reverseWord("race a car"));//car a race
    }

    public static String reverseWord(String string) {
        String[] arr = string.replaceAll(" {2}", " ").split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
