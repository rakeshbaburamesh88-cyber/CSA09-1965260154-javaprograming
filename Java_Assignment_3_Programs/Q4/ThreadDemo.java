class ScannerStation extends Thread {
    private int scripts;

    ScannerStation(String name, int scripts) {
        super(name);
        this.scripts = scripts;
    }

    public void run() {
        try {
            for (int i = 1; i <= scripts; i++) {
                Thread.sleep(100);
            }

            System.out.println(
                getName() + " scanned " + scripts + " scripts");
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args)
            throws InterruptedException {

        ScannerStation[] stations = {
            new ScannerStation("Station 1", 5),
            new ScannerStation("Station 2", 5),
            new ScannerStation("Station 3", 5),
            new ScannerStation("Station 4", 5)
        };

        for (ScannerStation s : stations)
            s.start();

        for (ScannerStation s : stations)
            s.join();

        System.out.println("All stations completed");
    }
}
