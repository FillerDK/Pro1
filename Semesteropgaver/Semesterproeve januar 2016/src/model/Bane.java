package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    // section S1
    private final int nummer;
    private final String baneInfo;

    /**
     * Assoaciation 1 --- 0..* Reservation
     */
    private final ArrayList<Reservation> reservationer = new ArrayList<>();

    public Bane(int nummer, String baneInfo) {
        this.nummer = nummer;
        this.baneInfo = baneInfo;
    }

    // getters
    public int getNummer() {
        return nummer;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    // adders
    /*public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }*/

    // sectiond S9
    public void addReservation(Reservation reservation) {
        
    }

    // section S2
    /**
     * Returnerer TRUE, hvis pladsen er ledig og FALSE, hvis banen er optaget.
     *
     * @param dato Dato, der tjekkes for
     * @param tid Tid, der tjekkes for
     * @return TRUE eller FALSE
     */
    public boolean isLedig(LocalDate dato, LocalTime tid) {
        boolean ledig = true;

        for (int i = 0; ledig && i < reservationer.size(); i++) {
            Reservation reservation = reservationer.get(i);
            if (reservation.getDato().equals(dato) &&
                reservation.getStartTid().equals(tid)) {
                ledig = false;
            }
        }

        return ledig;
    }

    // section S3
    /**
     * Returnerer en ArrayList af ledige tider indenfor åbningstiden (6:00-22:00),
     * på den angivne dato.
     *
     * Note: nullable
     *
     * @param dato Dato angivet.
     * @return ArrayList af typen LocalTime
     */
    public ArrayList<LocalTime> getLedigePaaDag(LocalDate dato) {
        ArrayList<LocalTime> ledigeTiderPaaDag = new ArrayList<>();
        for (int i = 6; i <= 22; i++) {
            ledigeTiderPaaDag.add(LocalTime.of(i, 00));
        }

        for (Reservation reservation : reservationer) {
            if (reservation.getDato().equals(dato)) {
                ledigeTiderPaaDag.remove(reservation.getStartTid());
            }
        }

        return ledigeTiderPaaDag;
    }
}
