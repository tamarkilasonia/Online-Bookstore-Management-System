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

        while (true) {
            System.out.println("\n1. View Books");
            System.out.println("2. Buy a Book");
            System.out.println("3. View Purchase History");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bookStore.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter ISBN of the book you want to buy: ");
                    String isbn = scanner.nextLine();
                    Book selectedBook = bookStore.getBook(isbn);

                    if (selectedBook == null) {
                        System.out.println("Book not found!");
                        break;
                    }

                    System.out.println("Choose Payment Method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. PayPal");
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    PaymentMethod paymentMethod = (paymentChoice == 1) ? new CreditCardPayment() : new PayPalPayment();

                    System.out.print("Enter order priority (1 = Low, 5 = High): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Order order = new Order(user, selectedBook, priority, paymentMethod);
                    orderProcessor.placeOrder(order);

                    user.buyBook(selectedBook);
                    break;

                case 3:
                    user.showPurchaseHistory();
                    break;