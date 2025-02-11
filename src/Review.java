class Review {
    private String userName;
    private String comment;
    private int rating; // 1 to 5 stars

    public Review(String userName, String comment, int rating) {
        this.userName = userName;
        this.comment = comment;
        this.rating = Math.min(5, Math.max(1, rating)); // Ensure rating is between 1 and 5
    }

    public void displayReview() {
        System.out.println(userName + " ⭐" + rating + ": " + comment);
    }
}
