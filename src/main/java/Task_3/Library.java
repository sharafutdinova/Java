package Task_3;

public class Library {
    private String bookTitle;
    protected String author;
    int year;
    public String category;

    public String getBookTitle() {
        return this.bookTitle;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getCategory() {
        return this.category;
    }

    public int getYear() {
        return this.year;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void setBookTitle(String newBookTitle) {
        this.bookTitle = newBookTitle;
    }

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    public void setYear(int newYear) {
        this.year = newYear;
    }
}
