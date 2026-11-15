class ParkingTicket {
    int ticketNo;
    String vehicleNo, entryTime;

    ParkingTicket(int ticketNo, String vehicleNo) {
        this(ticketNo, vehicleNo, "09:00 AM");
    }

    ParkingTicket(int ticketNo, String vehicleNo,
                  String entryTime) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
        this.entryTime = entryTime;
    }

    void display() {
        System.out.println("Ticket: " + ticketNo);
        System.out.println("Vehicle: " + vehicleNo);
        System.out.println("Entry: " + entryTime);
    }
}

public class TicketDemo {
    public static void main(String[] args) {
        ParkingTicket t1 =
            new ParkingTicket(101, "TN01AB1234");

        ParkingTicket t2 =
            new ParkingTicket(102, "TN02CD5678",
                              "10:30 AM");

        t1.display();
        t2.display();
    }
}
