class Order {
    private User user;
    private Book book;
    private int priority;
    private PaymentMethod paymentMethod;

    public Order(User user, Book book, int priority, PaymentMethod paymentMethod) {
        this.user = user;
        this.book = book;
        this.priority = priority;
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public int getPriority() {
        return priority;
    }

    public void processOrder() {
        System.out.println("Processing order for: " + user.getName() + " - " + book.title);
        paymentMethod.pay(book.price);
    }
}
