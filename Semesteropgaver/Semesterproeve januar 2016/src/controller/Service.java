package controller;

import model.Bane;
import model.Medlem;
import model.Reservation;

import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Service {
    // section S5
    public static Bane createBane(int nummer, String baneInfo) {
        Bane bane = new Bane(nummer, baneInfo);
        return bane;
    }

    public static Medlem createMedlem(String navn, String mobil, String mail) {
        Medlem medlem = new Medlem(navn, mobil, mail);
        return medlem;
    }

    public static void initStorage() {
        // medlemmer
        Medlem leneMikkelsen = createMedlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        Medlem finnJensen = createMedlem("Finn Jensen", "22331144", "fj@msn.com");

        // baner
        Bane bane1 = createBane(1, "Nord/syd vendt");
        Bane bane2 = createBane(2, "Under Egetræet");
        Bane bane3 = createBane(3, "Med tilskuerpladser");
    }

    // section S7
    /**
     * Note: nullable
     */
    public static Reservation createReservation(LocalDateTime dato, LocalTime startTid, Bane bane,
                                                Medlem booker, Medlem makker) {
        Reservation reservation = new Reservation(dato, startTid, bane, booker, makker);
        return reservation;
    }
}
