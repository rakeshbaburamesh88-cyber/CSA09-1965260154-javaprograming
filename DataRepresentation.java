import java.util.Scanner;

public class DataRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] slots = {
            new String[2],
            new String[3]
        };

        System.out.print("Enter Vehicle Number: ");
        String vehicleNo = sc.nextLine();

        System.out.print("Enter Duration: ");
        long duration = sc.nextLong();

        double rate = 30.0;
        double hours = duration / 60.0;
        double fee = hours * rate;

        System.out.println("Input: " + vehicleNo);
        System.out.println("Duration: " + duration);
        System.out.println("Parking Fee: Rs " + fee);

        sc.close();
    }
}
