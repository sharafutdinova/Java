package practice_3;

import MathOperations.MathOperations;

public class Main {
    public static void main(String[] args) {
        Student alsu = new Student("alsu", 30);
        Student sasha = new Student("Sasha", 34);
        alsu.name = "AlsuSha";
//        alsu.age = 18;
        System.out.println(Student.count);
        Student.printMaxYears();

        int sum = MathOperations.add(12, 23);
    }
}
