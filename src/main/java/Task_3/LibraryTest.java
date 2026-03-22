package Task_3;

public class LibraryTest {

    public void testMethod() {
        Library lib = new Library();
        //lib.bookTitle = "new book";//ошибка компиляции
        lib.author = "new book";
        lib.year = 12;
        lib.category = "test";
        lib.setBookTitle("new bookTitle");
    }
}
