import java.util.concurrent.*;

class DeliveryService {
    private final ExecutorService deliveryExecutor = Executors.newFixedThreadPool(2);

    public void deliverOrder(Order order) {
        deliveryExecutor.submit(() -> {
            try {
                System.out.println("📦 Order for " + order.getUser().getName() + " is out for delivery...");
                Thread.sleep(3000); // Simulate delivery time
                System.out.println("✅ Order delivered: " + order.getBook().title + " to " + order.getUser().getName());
            } catch (InterruptedException e) {
                System.out.println("Delivery interrupted!");
            }
        });
    }
