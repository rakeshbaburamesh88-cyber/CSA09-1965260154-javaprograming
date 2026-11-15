import java.time.*;

interface PricingRule {
    double calculate(int minutes, LocalTime entry);
}

class FlatPricing implements PricingRule {
    public double calculate(int minutes, LocalTime entry) {
        return minutes == 0 ? 0 : 25;
    }
}

class PeakPricing implements PricingRule {
    public double calculate(int minutes, LocalTime entry) {
        int hours = (minutes + 59) / 60;

        boolean peak =
            !entry.isBefore(LocalTime.of(9, 0)) &&
             entry.isBefore(LocalTime.of(17, 0));

        return hours * (peak ? 60 : 30);
    }
}

interface ParkingPass {
    boolean isValid(LocalDate date);
}

class OneDayPass implements ParkingPass {
    LocalDate validDate;

    OneDayPass(LocalDate date) {
        validDate = date;
    }

    public boolean isValid(LocalDate date) {
        return validDate.equals(date);
    }
}

class Vehicle {
    String regNo;
    PricingRule pricing;

    Vehicle(String regNo, PricingRule pricing) {
        this.regNo = regNo;
        this.pricing = pricing;
    }

    double calculateFee(int minutes, LocalTime entry) {
        return pricing.calculate(minutes, entry);
    }
}

public class AdaptedParking {
    public static void main(String[] args) {
        int[] slots = {20, 30, 25, 40, 35};

        int total = 0;
        for (int count : slots)
            total += count;

        Vehicle ebike =
            new Vehicle("TN01EB100", new FlatPricing());

        Vehicle van =
            new Vehicle("TN02DV200", new PeakPricing());

        System.out.println("Floors: " + slots.length);
        System.out.println("Total Slots: " + total);

        System.out.println("E-Bike Fee: Rs " +
            ebike.calculateFee(120,
                LocalTime.of(10, 0)));

        System.out.println("Van Peak Fee: Rs " +
            van.calculateFee(120,
                LocalTime.of(10, 0)));

        System.out.println("Van Off-Peak Fee: Rs " +
            van.calculateFee(120,
                LocalTime.of(18, 0)));

        LocalDate today = LocalDate.of(2026, 11, 15);

        ParkingPass pass = new OneDayPass(today);

        System.out.println("Pass Valid: " +
            pass.isValid(today));

        System.out.println("Visitor Fee: Rs " +
            (pass.isValid(today) ? 0 : 60));
    }
}
