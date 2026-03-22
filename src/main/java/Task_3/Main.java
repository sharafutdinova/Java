package Task_3;

public class Main {
    public static void main(String[] args) {
        Company employee_1 = new Company(1, "Alsu");
        Company employee_2 = new Company(2, "Anna");
        Company employee_3 = new Company(3, "Mary");
        Company.printCompanyName();
        Company.companyName = "Another name";
        Company.printCompanyName();
//        employee_1.employeeID = 2;//ошибка компиляции

        System.out.println("Area " + MathConstants.calculateCircleArea(5));
        System.out.println("Area " + MathConstants.calculateCircleArea(3));
        System.out.println("Length " + MathConstants.calculateCircumference(3));
        System.out.println("Length " + MathConstants.calculateCircumference(5));
        System.out.println("Exponential " + MathConstants.calculateExponentialGrowth(2, 1.3, 5));

        LibraryTest lib = new LibraryTest();
        lib.testMethod();

        University student_1 = new University(1, "Alsu");
        University student_2 = new University(2, "Anna");
        University student_3 = new University(3, "Mary");
        University.changeUniversityName("KFU");
        student_1.printStudentInfo();
        student_2.printStudentInfo();
        student_3.printStudentInfo();
        System.out.println(University.universityName);

        GameSettings game_1 = new GameSettings("GTA", 5);
        GameSettings game_2 = new GameSettings("Sims", 8);
        game_1.printGameStatus();
        GameSettings.setMaxPlayers(15);
        game_1.addPlayer();
        game_1.printGameStatus();

        Person person_1 = new Person("Alsu", "Sharaf", "123-345");
        Person person_2 = new Person("Anna", "Smith", "999-345");
        Person person_3 = new Person("Mary", "Test", "003-120");
        person_3.setFirstName("Kate");
        person_3.printPersonInfo();
    }
}
