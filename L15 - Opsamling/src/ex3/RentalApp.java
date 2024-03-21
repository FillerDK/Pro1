package ex3;

import java.time.LocalDate;

public class RentalApp {
    public static void main(String[] args) {
        Rental rental1 = new Rental(1, 7, LocalDate.now().plusMonths(10), 1000);
        Rental rental2 = new Rental(1, 7, LocalDate.now().plusMonths(1).withDayOfMonth(1), 2000);

        rental1.printRental();
        rental2.printRental();
        rental1.printTimeBetweenRentals(rental2);
        rental1.printDaysBetweenEndAndStartDateOfTwoRentals(rental2);
    }
}
