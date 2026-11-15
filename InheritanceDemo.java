class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    void display() {
        System.out.println("Vehicle: " + regNo);
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo);
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }
}

class ElectricCar extends Car {
    ElectricCar(String regNo) {
        super(regNo);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        TwoWheeler bike =
            new TwoWheeler("TN01A1");

        Car car = new Car("TN02B2");

        ElectricCar ev =
            new ElectricCar("TN03C3");

        bike.display();
        car.display();
        ev.display();
    }
}
