package practice_4.solvers;

import practice_4.Season;

public class SwithcTaskSolver {
    public static void main(String[] args) {
        System.out.println(dayOfWeek(1));
        System.out.println(dayOfWeek(10));
        System.out.println(describeSeason(Season.AUTUMN));
    }

    public static String dayOfWeek(int day) {
        return switch (day) {
            case 1 -> "Пон";
            case 2 -> "Вт";
            case 3 -> "Ср";
            case 4 -> "Чт";
            case 5 -> "Пт";
            case 6 -> "Сб";
            case 7 -> "Вс";
            default -> "not exists";
        };
    }

    public static String describeSeason(Season season) {
        return switch (season) {
            case WINTER -> "Холодно";
            case SUMMER -> "Жарко";
            case AUTUMN -> "Цветение";
            case SPRING -> "Листопад";
        };
    }
}
