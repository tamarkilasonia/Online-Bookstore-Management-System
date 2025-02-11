import java.util.concurrent.*;

class DeliveryService {
    private final ExecutorService deliveryExecutor = Executors.newFixedThreadPool(2);