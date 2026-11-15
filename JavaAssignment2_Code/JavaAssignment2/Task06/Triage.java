import java.util.Comparator;
import java.util.PriorityQueue;

class Patient {
    final String name;
    final int severity;
    final long arrival;

    Patient(String name, int severity, long arrival) {
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return name + "(S" + severity + ")";
    }
}

public class Triage {
    private long counter = 0;

    private final PriorityQueue<Patient> queue =
        new PriorityQueue<>(
            Comparator.comparingInt(
                (Patient p) -> p.severity)
            .thenComparingLong(p -> p.arrival)
        );

    void admit(String name, int severity) {
        if (severity < 1 || severity > 5) {
            throw new IllegalArgumentException(
                "Invalid Severity");
        }

        queue.add(new Patient(
            name, severity, counter++));
    }

    Patient next() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Triage t = new Triage();

        t.admit("Arun", 3);
        t.admit("Bala", 1);
        t.admit("Charan", 2);
        t.admit("David", 1);
        t.admit("Ezhil", 5);
        t.admit("Farhan", 3);
        t.admit("Gokul", 2);
        t.admit("Hari", 4);

        System.out.println("Treatment Order:");

        Patient p;

        while ((p = t.next()) != null) {
            System.out.println(p);
        }
    }
}
