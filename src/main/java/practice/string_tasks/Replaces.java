package practice.string_tasks;

//Максимальная длина подстроки без повторений
public class Replaces {
    static void main(String[] args) {
        System.out.println(deleteSpaces(" a a   bb"));
        System.out.println(replaces(" (Hello! )"));
        System.out.println(deleteVowels(" (Hello Alsu! )"));
    }

    public static String deleteSpaces(String string) {
        return string.replaceAll("\s", "");
    }//Удаление пробелов

    public static String replaces(String string) {
        return string.replaceAll("[^A-Za-z]", "");//Удаление символов(кроме букв)
    }

    public static String deleteVowels(String string) {
        return string.replaceAll("(?i)[aeuioy]", "");//Удаление гласных независимо от регистра
    }
}
