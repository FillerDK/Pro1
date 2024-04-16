package ex2;

import ex2.controller.Controller;
import ex2.model.Car;
import ex2.model.Rental;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Rental r1 = new Rental(1, LocalDate.now().toString(), 5);
        Rental r2 = new Rental(2, LocalDate.now().toString(), 10);

        Car c1 = new Car("887sd87sd7862", "2017");

        c1.setPricePerDay(1000);

        Car c2 = new Car("718734hjdfsf6", "2004");

        c2.setPricePerDay(200);

        Car c3 = new Car("sadhwi7678162", "2010");

        c3.setPricePerDay(600);

        Controller.addCarToRental(c1, r1);
        Controller.addCarToRental(c2, r1);
        Controller.addCarToRental(c3, r2);

        System.out.printf("Reg.no: %s, reg.y: %s, price per day: %d\n", c1.getNo(), c1.getYear(), c1.getPricePerDay());
        System.out.printf("Reg.no: %s, reg.y: %s, price per day: %d\n", c2.getNo(), c2.getYear(), c2.getPricePerDay());
        System.out.printf("Reg.no: %s, reg.y: %s, price per day: %d\n", c3.getNo(), c3.getYear(), c3.getPricePerDay());

        System.out.printf("\nRental no: %d, date for rental: %s, days of rental: %02d, rental price: %d", r1.getNo(), r1.getDate(), r1.getDays(), r1.getPrice());
        System.out.printf("\nRental no: %d, date for rental: %s, days of rental: %02d, rental price: %d", r2.getNo(), r2.getDate(), r2.getDays(), r2.getPrice());

        System.out.printf("\n\nMost days %s was rented: %d", c1.getNo(), Controller.getLongestRentalForCar(c1));
    }
}
