package Task_12;

public class DebugTask4 {
    public static void main(String[] args) {
        String str = "testString";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
