import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new PaperbackBook("Java for Beginners", "John Doe", "ISBN123", 20.99, 10);
        Book book2 = new EBook("Advanced Java", "Jane Smith", "ISBN456", 15.49, "www.download-link.com");
        Book book3 = new PaperbackBook("Data Structures", "Alice Johnson", "ISBN789", 30.99, 5);

        // Store books in a HashMap
        BookStore bookStore = new BookStore();
        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        // Create an OrderProcessor (Thread Manager)
        OrderProcessor orderProcessor = new OrderProcessor();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Bookstore!");
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);
