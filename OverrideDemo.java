class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    double calculateFee() {
        return 0;
    }

    @Override
    public String toString() {
        return "Vehicle: " + regNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle)) return false;

        Vehicle v = (Vehicle) obj;
        return regNo.equals(v.regNo);
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee() {
        return 10;
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee() {
        return 30;
    }
}

public class OverrideDemo {
    public static void main(String[] args) {
        TwoWheeler bike =
            new TwoWheeler("TN01A1");

        Car car = new Car("TN02B2");

        System.out.println(
            bike + " Fee: Rs " + bike.calculateFee());

        System.out.println(
            car + " Fee: Rs " + car.calculateFee());

        System.out.println(
            new Car("TN02B2").equals(
                new Car("TN02B2")));
    }
}
