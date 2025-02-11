import java.util.LinkedList;

class User {
    private String name;
    private LinkedList<Book> purchaseHistory = new LinkedList<>();

    public User(String name) {
        this.name = name;
    }

    // Add the getter method for name
    public String getName() {
        return name;
    }

    public void buyBook(Book book) {
        purchaseHistory.add(book);
        System.out.println(name + " bought " + book.title);
    }

    public void showPurchaseHistory() {
        System.out.println(name + "'s Purchase History:");
        for (Book book : purchaseHistory) {
            System.out.println("- " + book.title);
        }
    }
}

