abstract class Book {
    protected String title;
    protected String author;
    protected String ISBN;
    protected double price;

    public Book(String title, String author, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }

    public abstract void displayDetails();
}
