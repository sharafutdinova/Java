package practice_3;

public class Student {
    final static int MAX_YEARS = 11;
    static int count;
    private int age;
    protected String name;

    static {
        count = 0;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    int getAge() {
        return this.age;
    }

    static void printMaxYears() {
        System.out.println(MAX_YEARS);
    }

}
