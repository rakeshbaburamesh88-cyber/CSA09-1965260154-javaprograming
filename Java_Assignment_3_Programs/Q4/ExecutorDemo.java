import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService pool =
            Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 4; i++) {
            final int station = i;

            pool.submit(() ->
                System.out.println("Station " + station + " completed"));
        }

        pool.shutdown();
    }
}
