Book Store Application 📚💻

Overview 🚀

Welcome to the Book Store Application! This multi-threaded Java app simulates an online bookstore, allowing users to browse books, make purchases, and view purchase history. Admins can add/remove books, while orders are processed asynchronously with priority levels. 💥

This project showcases Polymorphism, Concurrency, and Data Structures in Java.

Key Features 🌟

User Management: Create a user, buy books, and view purchase history.
Admin Controls: Add/remove books from the store.
Order Processing: Orders are processed asynchronously with priority using ExecutorService and PriorityBlockingQueue.
Payment Methods: Simulate payments via Credit Card and PayPal.


Getting Started 🚀


Prerequisites 🔧

JDK 17+
IDE (IntelliJ IDEA/Eclipse)
Git (optional for cloning)
Installation 🛠️
Clone the Repository:

bash
Copy
Edit
git clone https://github.com/yourusername/book-store-app.git
Run the Application:

Open the project in your IDE and run the Main class.


Project Structure 🏗️
User: Represents users who can buy books and view their history.
Admin: Admin controls for adding/removing books.
BookStore: Manages the inventory of books.
OrderProcessor: Processes orders concurrently with priority.
Order: Represents user orders, including the book, user, and priority.
PaymentMethod: Abstract class for different payment methods (Credit Card, PayPal).


Technologies 🛠️

Java 17
ExecutorService (for concurrency)

PriorityBlockingQueue (for order priority)

LinkedList (for purchase history)


