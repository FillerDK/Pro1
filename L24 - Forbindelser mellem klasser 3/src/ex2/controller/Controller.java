package ex2.controller;

import ex2.model.Car;
import ex2.model.Rental;

public class Controller {
    public static void addCarToRental(Car car, Rental rental) {
        rental.addCar(car);
        car.addRental(rental);
    }

    public static int getLongestRentalForCar(Car car) {
        return car.getLongestRental();
    }
}
