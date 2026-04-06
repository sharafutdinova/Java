package practice.string_tasks;

//Количество уникальных символов
public class UniqueSymbols {
    static void main(String[] args) {
        System.out.println(getCountOfUniqueElements("Test"));
        System.out.println(getCountOfUniqueElements("aAbbaa"));
    }

    public static long getCountOfUniqueElements(String s) {
        return s.toLowerCase().chars().distinct().count();
    }
}
