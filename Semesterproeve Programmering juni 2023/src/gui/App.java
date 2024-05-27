package gui;

import controller.Controller;
import javafx.application.Application;
import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    // section S6
    public static void main(String[] args) {
        initStorage();
        Controller.udskrivBookingerTilTekstFil("bookinger");
        Application.launch(Gui.class);
    }

    public static void initStorage() {
        // kategorier
        Kategori luksus = Controller.opretKategori("Luksus", 100, 200);
        Kategori mellem = Controller.opretKategori("Mellem", 50, 100);
        Kategori begynder = Controller.opretKategori("Begynder", 25, 50);

        // baner
        Bane bane1 = Controller.opretBane(1, true, LocalTime.of(9, 00), LocalTime.of(17, 00),
                luksus);
        Bane bane2 = Controller.opretBane(2, true, LocalTime.of(9, 00), LocalTime.of(17, 00),
                luksus);
        Bane bane3 = Controller.opretBane(3, true, LocalTime.of(9, 00), LocalTime.of(17, 00),
                mellem);
        Bane bane4 = Controller.opretBane(4, false, LocalTime.of(9, 00), LocalTime.of(17, 00),
                mellem);
        Bane bane5 = Controller.opretBane(5, false, LocalTime.of(9, 00), LocalTime.of(17, 00),
                begynder);
        Bane bane6 = Controller.opretBane(6, false, LocalTime.of(9, 00), LocalTime.of(17, 00),
                begynder);

        // spillere
        Spiller andreas = Controller.opretSpiller("Andreas", "DMU");
        Spiller petra = Controller.opretSpiller("Petra", "DMU");
        Spiller henrik = Controller.opretSpiller("Henrik", "ITA");
        Spiller ulla = Controller.opretSpiller("Ulla", "ITA");

        // bookinger
        Booking booking1 = Controller.opretBooking(LocalDate.of(2023, 06, 20),
                LocalTime.of(10, 00), true, andreas, bane3);
        Booking booking2 = Controller.opretBooking(LocalDate.of(2023, 06, 22),
                LocalTime.of(10, 00), false, andreas, bane2);
        Booking booking3 = Controller.opretBooking(LocalDate.of(2023, 06, 20),
                LocalTime.of(11, 00), false, henrik, bane3);
        Booking booking4 = Controller.opretBooking(LocalDate.of(2023, 06, 20),
                LocalTime.of(16, 00), false, ulla, bane3);
        Booking booking6 = Controller.opretBooking(LocalDate.of(2023, 06, 23),
                LocalTime.of(17, 00), true, ulla, bane5);
    }
}
