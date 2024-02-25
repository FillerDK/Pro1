package classEx.ex1;

public class CarApp {

    public static void main(String[] args) {
        // Test car
        Car myCar = new Car("VW UP", "White", "AB 12.345", 50000);
        myCar.setKm(65000);

        // New car
        Car myCar2 = new Car("Fiat Panda", "Black", "CB 43.689", 0);
        myCar2.setKm(5000);

        myCar.printCar();
        myCar2.printCar();
    }
}
