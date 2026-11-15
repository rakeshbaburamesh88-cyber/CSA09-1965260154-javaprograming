import java.util.*;

public class SmartParking {
    static String[][] slots = {
        new String[2],
        new String[2]
    };

    static int ticketCounter = 1000;

    static HashMap<String, Integer> tickets =
        new HashMap<>();

    static int[] allocate(String regNo) {
        if (tickets.containsKey(regNo)) {
            System.out.println("Duplicate Vehicle");
            return null;
        }

        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = regNo;
                    tickets.put(regNo, ++ticketCounter);

                    System.out.println(
                        "Ticket: " + ticketCounter);

                    return new int[]{f, s};
                }
            }
        }

        System.out.println("Parking Full");
        return null;
    }

    static double calculateFee(int minutes,
                               double rate) {
        if (minutes < 0)
            throw new IllegalArgumentException(
                "Invalid Duration");

        int hours = (minutes + 59) / 60;
        return hours * rate;
    }

    static boolean release(int floor, int slot) {
        if (floor < 0 || floor >= slots.length)
            return false;

        if (slot < 0 || slot >= slots[floor].length)
            return false;

        String regNo = slots[floor][slot];

        if (regNo == null)
            return false;

        slots[floor][slot] = null;
        tickets.remove(regNo);

        return true;
    }

    public static void main(String[] args) {
        System.out.println("SMART PARKING SYSTEM");

        int[] position = allocate("TN01AB1234");

        System.out.println("Position: " +
            Arrays.toString(position));

        System.out.println("Parking Fee: Rs " +
            calculateFee(130, 30));

        System.out.println("Duplicate Test:");
        allocate("TN01AB1234");

        System.out.println("Release: " +
            release(0, 0));

        System.out.println("Invalid Slot: " +
            release(5, 0));

        System.out.println("Zero Minute Fee: Rs " +
            calculateFee(0, 30));
    }
}
