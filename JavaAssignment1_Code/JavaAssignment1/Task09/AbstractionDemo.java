interface Chargeable {
    double chargingFee(int kWh);
}

abstract class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double ratePerHour();

    double calculateFee(int hours) {
        return hours * ratePerHour();
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 30;
    }
}

class ElectricCar extends Vehicle
                  implements Chargeable {
    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 30;
    }

    @Override
    public double chargingFee(int kWh) {
        return kWh * 12;
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        Car car = new Car("TN01AB1234");

        ElectricCar ev =
            new ElectricCar("TN02CD5678");

        System.out.println(
            "Car Fee: Rs " + car.calculateFee(2));

        System.out.println(
            "EV Parking Fee: Rs " +
            ev.calculateFee(2));

        System.out.println(
            "Charging Fee: Rs " +
            ev.chargingFee(10));
    }
}
