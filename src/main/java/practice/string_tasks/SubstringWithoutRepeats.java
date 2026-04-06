package practice.string_tasks;

//Максимальная длина подстроки без повторений
public class SubstringWithoutRepeats {
    static void main(String[] args) {
        System.out.println(substringWithoutRepeats("abcda"));//4
        System.out.println(substringWithoutRepeats("A man, a plan, a canal: Panama"));
        System.out.println(substringWithoutRepeats("aabb"));//2
    }

    public static int substringWithoutRepeats(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = 0;
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (stringBuilder.indexOf(String.valueOf(charArray[i])) >= 0) {
                length = Math.max(stringBuilder.length(), length);
                stringBuilder.setLength(0);
            }
            stringBuilder.append(charArray[i]);
        }
        return length;
    }
}
