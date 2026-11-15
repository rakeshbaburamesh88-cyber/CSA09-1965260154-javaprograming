class TicketCounter {
    static int count;

    static {
        count = 1000;
        System.out.println("System Initialized");
    }

    static int generateTicket() {
        return ++count;
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        System.out.println(
            "Ticket: " + TicketCounter.generateTicket());

        System.out.println(
            "Ticket: " + TicketCounter.generateTicket());

        System.out.println(
            "Ticket: " + TicketCounter.generateTicket());
    }
}
