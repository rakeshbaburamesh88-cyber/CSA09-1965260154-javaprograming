class Vehicle {
    double rate;

    Vehicle(double rate) {
        this.rate = rate;
    }

    double calculateFee(int hours) {
        return hours * rate;
    }

    double calculateFee(int hours, double discount) {
        return calculateFee(hours) - discount;
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler() {
        super(10);
    }

    @Override
    double calculateFee(int hours) {
        return hours * rate;
    }
}

class Car extends Vehicle {
    Car() {
        super(30);
    }

    @Override
    double calculateFee(int hours) {
        return hours * rate;
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new TwoWheeler(),
            new Car()
        };

        for (Vehicle v : vehicles) {
            System.out.println(
                "Fee: Rs " + v.calculateFee(3));
        }

        System.out.println(
            "Discount Fee: Rs " +
            vehicles[1].calculateFee(3, 10));
    }
}
