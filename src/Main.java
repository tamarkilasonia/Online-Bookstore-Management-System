import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        OrderProcessor orderProcessor = new OrderProcessor();
        DeliveryService deliveryService = new DeliveryService();
        Scanner scanner = new Scanner(System.in);

        // Sample books
        bookStore.addBook(new PaperbackBook("Java Mastery", "John Doe", "ISBN111", 25.99, 10));
        bookStore.addBook(new EBook("Python Basics", "Jane Smith", "ISBN222", 15.49, "www.download-py.com"));

        System.out.println("Welcome to the Online Bookstore!");
        System.out.print("Are you (1) a User or (2) an Admin? ");
        int userType = scanner.nextInt();
        scanner.nextLine();

        if (userType == 2) {
            Admin admin = new Admin("admin", "1234");
            System.out.print("Enter Admin Username: ");
            String adminUser = scanner.nextLine();
            System.out.print("Enter Password: ");
            String adminPass = scanner.nextLine();

            if (!admin.login(adminUser, adminPass)) {
                System.out.println("❌ Invalid credentials!");
                return;
            }

            System.out.println("🔹 Admin Dashboard");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            int adminChoice = scanner.nextInt();
            scanner.nextLine();

            if (adminChoice == 1) {
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Enter Price: ");
                double price = scanner.nextDouble();
                admin.addBook(bookStore, new PaperbackBook(title, author, isbn, price, 5));
            } else if (adminChoice == 2) {
                System.out.print("Enter ISBN to Remove: ");
                String isbn = scanner.nextLine();
                admin.removeBook(bookStore, isbn);
            }
            return;
        }

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        while (true) {
            System.out.println("\n1. View Books");
            System.out.println("2. Buy a Book");
            System.out.println("3. Leave a Review");
            System.out.println("4. View Reviews");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                bookStore.displayBooks();
            } else if (choice == 2) {
                System.out.print("Enter ISBN of book: ");
                String isbn = scanner.nextLine();
                Book book = bookStore.getBook(isbn);
                if (book == null) {
                    System.out.println("❌ Book not found!");
                    continue;
                }

                System.out.println("Choose Discount: 1. New User  2. Loyalty");
                int discountType = scanner.nextInt();
                scanner.nextLine();
                DiscountStrategy discount = (discountType == 1) ? new NewUserDiscount() : new LoyaltyDiscount();
                double finalPrice = discount.applyDiscount(book.price);

                System.out.print("Enter Priority (1-5): ");
                int priority = scanner.nextInt();
                scanner.nextLine();

                Order order = new Order(user, book, priority, new CreditCardPayment());
                orderProcessor.placeOrder(order);
                deliveryService.deliverOrder(order);
            } else if (choice == 3) {
                // Review functionality
            } else if (choice == 5) {
                break;
            }
        }

        orderProcessor.shutdown();
        deliveryService.shutdown();
    }
}
