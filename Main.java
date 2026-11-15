class Vehicle {
    String regNo, type;

    Vehicle(String regNo, String type) {
        this.regNo = regNo;
        this.type = type;
    }
}

class ParkingSlot {
    int slotNo;
    boolean occupied;

    ParkingSlot(int slotNo) {
        this.slotNo = slotNo;
        occupied = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("TN01AB1234", "Car");
        ParkingSlot s = new ParkingSlot(1);

        System.out.println("Vehicle: " + v.regNo);
        System.out.println("Type: " + v.type);
        System.out.println("Slot: " + s.slotNo);
        System.out.println("Occupied: " + s.occupied);
    }
}
