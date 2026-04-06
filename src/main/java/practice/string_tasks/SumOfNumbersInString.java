package practice.string_tasks;

//Сумма чисел в строке
public class SumOfNumbersInString {
    static void main(String[] args) {
        System.out.println(sumOfNumbersInString("10 b 67 p"));//77
    }

    public static int sumOfNumbersInString(String string) {
        int sum = 0;
        int num = 0;
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                sum += num;
                num = 0;
            }
        }
        return sum + num;
    }
}
