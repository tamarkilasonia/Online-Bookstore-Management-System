import java.util.concurrent.*;

class OrderProcessor {
    private final ExecutorService executor = Executors.newFixedThreadPool(3);
    private final PriorityBlockingQueue<Order> orderQueue = new PriorityBlockingQueue<>(10,
            (o1, o2) -> Integer.compare(o2.getPriority(), o1.getPriority()) // Compare priorities using getPriority()
    );

    public void placeOrder(Order order) {
        orderQueue.add(order);
        executor.submit(() -> processOrder(order));
    }

    private void processOrder(Order order) {
        System.out.println("Processing order for " + order.getUser().getName());
        try {
            Thread.sleep(2000);  // Simulate order processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order completed: " + order.getBook().title);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
