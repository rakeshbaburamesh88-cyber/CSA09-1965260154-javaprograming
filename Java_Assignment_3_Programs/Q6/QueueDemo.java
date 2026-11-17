import java.util.concurrent.*;

public class QueueDemo {
    public static void main(String[] args)
            throws InterruptedException {

        BlockingQueue<Integer> queue =
            new ArrayBlockingQueue<>(5);

        queue.put(10);
        queue.put(20);

        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
