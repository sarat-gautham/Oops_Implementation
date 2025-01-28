class Car {
    final void start() {
        System.out.println("Car is starting.");
    }
}

class ElectricCar extends Car {
    // Cannot override start() because it's final in the parent class
    void charge() {
        System.out.println("Electric car is charging.");
    }
}

public class Cars {
    public static void main(String[] args) {
        ElectricCar eCar = new ElectricCar();
        eCar.start();
        eCar.charge();
    }
}
