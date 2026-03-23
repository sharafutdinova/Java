package practice_4.solvers;

import practice_4.Season;

public class IfElseTaskSolver {
    public static void main(String[] args) {
        System.out.println(checkParity(13));
        System.out.println(checkParity(90));
        System.out.println(checkAge(90));
        System.out.println(checkAge(18));
        System.out.println(checkMax(18, 90, 34));
        System.out.println(checkMax(18, 90, 340));
    }

    public static String checkParity(int number) {
        return number % 2 == 0 ? "Четное" : "Нечетное";
    }

    public static String checkAge(int age) {
        String ageDescr = "";
        if (age < 18) {
            ageDescr = "Несовершеннолетний";
        } else if (age <= 60) {
            ageDescr = "Совершеннолетний";
        } else
            ageDescr = "Пожилой";
        return ageDescr;
    }

    public static int checkMax(int a, int b, int c) {
        int max = a;
        if (a < b) max = b;
        if (max < c) max = c;
        return max;

    }
}
