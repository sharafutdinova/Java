package practice.array_tasks;

public class ConcatToString {
    static void main(String[] args) {
        String[] words = {"Hello", "i", "am", "Alsu"};
        System.out.println(concatToString(words));
    }

    //Объединение массива строк в строку
    public static String concatToString(String[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String word: arr){
            stringBuilder.append(word);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
