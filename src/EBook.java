class EBook extends Book {
    private String downloadLink;

    public EBook(String title, String author, String ISBN, double price, String downloadLink) {
        super(title, author, ISBN, price);
        this.downloadLink = downloadLink;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-Book: " + title + " by " + author + " [Download: " + downloadLink + "]");
    }
}
