package practice.string_tasks;

//Проверка является ли строка числом
public class CheckIsNumber {
    static void main(String[] args) {
        System.out.println(isNumber("aa"));
        System.out.println(isNumber("12"));
        System.out.println(compare("1.2","2"));
        System.out.println(compare("2.0","2"));
    }

    public static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean compare(String v1, String v2) {
        String[] a = v1.split("\\.");
        String[] b = v2.split("\\.");
        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            int n1 = i < a.length ? Integer.parseInt(a[i]) : 0;
            int n2 = i < b.length ? Integer.parseInt(b[i]) : 0;
            if (n1 != n2) return false;
        }
        return true;
    }
}
