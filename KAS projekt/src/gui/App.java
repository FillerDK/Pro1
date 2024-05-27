package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }

    private static void initStorage() {
        // Hotelbestyrer
        Hotelbestyrer hotelbestyrer = Controller.opretHotelbestyrer("Hotelbetystere",
                "12345678", "hotelbestyrer@email.dk", "adresse 123");

        // Hotel
        Hotel denHvideSvane = Controller.opretHotel(1250, 1050,
                "Den hvide svane 123", "Den hvide svane", hotelbestyrer);

        // Services
        Service WIFI = Controller.opretService("WIFI", "WOW",
                50, denHvideSvane);

        // Konference
        Konference havoghimmel = Controller.opretKonference(1500,
                "Odense Universitet", LocalDate.of(2024, 5, 15),
                "Beskrivelse...", LocalDate.of(2024, 5, 20),
                LocalDate.of(2024, 5, 18), "Hav og Himmel");
        Controller.addHotelTilKonference(havoghimmel, denHvideSvane);

        // Deltagere
        Deltager deltager = Controller.opretDeltager("Finn Madsen", "00000000",
                "email@email.dk", "adresse 123", "1234");
        Deltager deltager1 = Controller.opretDeltager("Niels Petersen", "00000000",
                "email@email.dk", "adresse 123", "1234");
        Deltager deltager2 = Controller.opretDeltager("Ulla Hansen", "00000000",
                "email@email.dk", "adresse 123", "1234");
        Deltager deltager3 = Controller.opretDeltager("Peter Sommer", "00000000",
                "email@email.dk", "adresse 123", "1234");
        Deltager deltager4 = Controller.opretDeltager("Lone Jensen", "00000000",
                "email@email.dk", "adresse 123", "1234");

        // Firma
        Firma firma = Controller.opretFirma("Google", "88888888", "CVR");

        // Ledsagere
        Ledsager ledsager0 = Controller.opretLedsager("Hans Hansen", "99999999",
                "email@ledsager.dk", "adresse 321");
        Ledsager ledsager1 = Controller.opretLedsager("Mie Sommer", "99999999",
                "email@ledsager.dk", "adresse 321");
        Ledsager ledsager2 = Controller.opretLedsager("Jan Madsen", "99999999",
                "email@ledsager.dk", "adresse 321");

        // Udflugter
        Udflugt odense = Controller.opretUdflugt("Beskrivelse", 125,
                LocalDate.of(2024, 5, 25), "Odense",
                "Byrundtyr Odense", havoghimmel);
        Udflugt egeskov = Controller.opretUdflugt("Beskrivelse", 75,
                LocalDate.of(2024, 5, 19), "Egeskov",
                "Egeskov", havoghimmel);
        Udflugt trapholt = Controller.opretUdflugt("Beskrivelse", 200,
                LocalDate.of(2024, 5, 20),
                "Tapholt Museum, Kolding", "Traphold", havoghimmel);

        // Valgte Udlugter
        Controller.addLedsagerTilUdflugt(odense, ledsager0);

        Controller.addLedsagerTilUdflugt(egeskov, ledsager1);
        Controller.addLedsagerTilUdflugt(trapholt, ledsager1);

        Controller.addLedsagerTilUdflugt(egeskov, ledsager2);
        Controller.addLedsagerTilUdflugt(odense, ledsager2);

        // Tilmeldinger
        Tilmelding tilmelding0 = Controller.opretTilmelding(false,
                LocalDate.of(2024, 5, 18),
                LocalDate.of(2024, 5, 20), deltager, havoghimmel);

        Tilmelding tilmelding1 = Controller.opretTilmelding(false,
                LocalDate.of(2024, 5, 18),
                LocalDate.of(2024, 5, 20), deltager1, havoghimmel);
        Controller.addTilmeldingTilHotel(denHvideSvane, tilmelding1);

        Tilmelding tilmelding2 = Controller.opretTilmelding(false,
                LocalDate.of(2024, 5, 18),
                LocalDate.of(2024, 5, 19), deltager2, havoghimmel);
        Controller.addLedsagerTilTilmelding(tilmelding2, ledsager0);

        Tilmelding tilmelding3 = Controller.opretTilmelding(false,
                LocalDate.of(2024, 5, 18),
                LocalDate.of(2024, 5, 20), deltager3, havoghimmel);
        Controller.addTilmeldingTilHotel(denHvideSvane, tilmelding3);
        Controller.addLedsagerTilTilmelding(tilmelding3, ledsager1);
        Controller.addServiceTilTilmelding(tilmelding3, WIFI);

        Tilmelding tilmelding4 = Controller.opretTilmelding(true,
                LocalDate.of(2024, 5, 18),
                LocalDate.of(2024, 5, 20), deltager4, havoghimmel);
        Controller.addTilmeldingTilHotel(denHvideSvane, tilmelding4);
        Controller.addLedsagerTilTilmelding(tilmelding4, ledsager2);
        Controller.addServiceTilTilmelding(tilmelding4, WIFI);
        Controller.addFirmaTilTilmelding(tilmelding4, firma);

        System.out.println("Finn Madsen: " + tilmelding0.beregnPris());
        System.out.println("Niels Petersen: " + tilmelding1.beregnPris());
        System.out.println("Ulla Hansen: " + tilmelding2.beregnPris());
        System.out.println("Peter sommer: " + tilmelding3.beregnPris());
        System.out.println("Lone Jensen: " + tilmelding4.beregnPris());

    }
}
