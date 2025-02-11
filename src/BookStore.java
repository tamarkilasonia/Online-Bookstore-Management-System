import java.util.HashMap;

class BookStore {
    private HashMap<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.ISBN, book);
    }

    public boolean removeBook(String isbn) {
        return books.remove(isbn) != null;
    }

    public void displayBooks() {
        for (Book book : books.values()) {
            book.displayDetails();
        }

    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }
}
