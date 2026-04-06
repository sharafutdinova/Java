package practice.string_tasks;

//Проверка строки на палиндром
public class IsPalindrome {
    static void main(String[] args) {
        System.out.println(isPalindrome("aa"));//true
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));//true
        System.out.println(isPalindrome("race a car"));//false
    }

    public static boolean isPalindrome(String string) {
        String cleanStr = string.replaceAll("[^A-Za-z]", "").toLowerCase();
//        String cleanStr = string.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversed);
    }
}
