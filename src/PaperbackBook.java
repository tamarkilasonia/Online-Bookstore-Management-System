class PaperbackBook extends Book {
    private int stock;

    public PaperbackBook(String title, String author, String ISBN, double price, int stock) {
        super(title, author, ISBN, price);
        this.stock = stock;
    }

    @Override
    public void displayDetails() {
        System.out.println("Paperback: " + title + " by " + author + " [Stock: " + stock + "]");
    }
}
