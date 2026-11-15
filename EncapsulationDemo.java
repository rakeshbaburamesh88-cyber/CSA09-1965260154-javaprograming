package parking;

class ParkingSlot {
    private int slotNo;
    private boolean occupied;

    ParkingSlot(int slotNo) {
        if (slotNo <= 0) {
            throw new IllegalArgumentException(
                "Invalid slot number");
        }

        this.slotNo = slotNo;
        this.occupied = false;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot(101);

        System.out.println("Slot Number: " +
                           slot.getSlotNo());

        System.out.println("Occupied: " +
                           slot.isOccupied());

        slot.setOccupied(true);

        System.out.println("Updated Status: " +
                           slot.isOccupied());

        Integer number = 101;

        System.out.println("Wrapper Value: " + number);
    }
}
