package Task_2;

public class Main {
    public static void main(String[] args) {
        Car volvo = new Car("Volvo", 2010);
        volvo.setYear(2020);
        volvo.print();

        Rectangle rect = new Rectangle(10, 5);
        rect.setWidth(4);
        System.out.println(rect.calculateArea());

        Book book_1 = new Book("QA Auto", "Sasha");
        book_1.setAuthor("Alsu");
        book_1.printInfo();

        BankAccount acc = new BankAccount("Alsu", 1000);
        acc.deposit(1500);
        acc.withdraw(500);
        acc.printBalance();

        Point point = new Point(2, 4);
        point.setX(3);
        point.print();

        StudentGroup group_1 = new StudentGroup("Test group", 10);
        group_1.setStudentCount(11);
        group_1.printInfo();

        Circle circle = new Circle(3);
        circle.setRadius(5);
        System.out.println("Area " + circle.calculateArea());
        System.out.println("Length " + circle.calculateCircumference());

        Teacher teacher = new Teacher("Sasha", "QA");
        teacher.setSubject("QA Auto");
        teacher.printInfo();

        Product apple = new Product("apple", 130);
        apple.setPrice(100);
        apple.applyDiscount(10);
        apple.printInfo();
        System.out.println("price is " + apple.getPrice());

        Laptop mac = new Laptop("Macbook", 10000);
        mac.setPrice(50000);
        mac.printInfo();
    }
}
