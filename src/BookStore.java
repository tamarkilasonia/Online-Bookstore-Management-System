import java.util.HashMap;

class BookStore {
    private HashMap<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.ISBN, book);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            book.displayDetails();
        }
    }
}

