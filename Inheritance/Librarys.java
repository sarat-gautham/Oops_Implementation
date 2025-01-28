class Library {
    protected String libraryName = "City Library";

    protected void displayLibrary() {
        System.out.println("Library: " + libraryName);
    }
}

class Book extends Library {
    String bookTitle;

    Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    void displayBook() {
        displayLibrary();
        System.out.println("Book Title: " + bookTitle);
    }
}

public class Librarys {
    public static void main(String[] args) {
        Book book = new Book("Java Programming");
        book.displayBook();
    }
}
