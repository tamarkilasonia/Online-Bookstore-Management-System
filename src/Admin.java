class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public void addBook(BookStore bookStore, Book book) {
        bookStore.addBook(book);
        System.out.println("📚 Book added: " + book.title);
    }

    public void removeBook(BookStore bookStore, String isbn) {
        if (bookStore.removeBook(isbn)) {
            System.out.println("🗑️ Book removed.");
        } else {
            System.out.println("⚠️ Book not found.");
        }
    }
}
