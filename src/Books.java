import java.util.ArrayList;

abstract class Books {
    protected String title;
    protected String author;
    protected String ISBN;
    protected double price;
    private ArrayList<Review> reviews = new ArrayList<>();

    public Books(String title, String author, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void displayReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews for this book.");
            return;
        }
        System.out.println("Reviews for " + title + ":");
        for (Review r : reviews) {
            r.displayReview();
        }
    }

    public abstract void displayDetails();
}
