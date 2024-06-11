package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Medlem {
    // section S1
    private final String navn;
    private final String mobil;
    private final String mail;

    /**
     * Association 1 --- 0..* Reservation
     */
    private final ArrayList<Reservation> reservationer = new ArrayList<>();

    public Medlem(String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
    }

    // adders
    public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    // getters
    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    // section S6
    /**
     * Returnerer TRUE såfremt der er en aktiv reservation for det pågældende medlem,
     * ellers returneres FALSE.
     * Et medlem har en aktiv reservation såfremt medlemmet enten har lavet en reservation
     * eller er makker på en reservation der endnu ikke er passeret.
     *
     * @return TRUE eller FALSE
     */
    public boolean hasAktivReservation() {
        boolean hasAktiv = false;

        for (int i = 0; !hasAktiv && i < reservationer.size(); i++) {
            Reservation reservation = reservationer.get(i);
            if (reservation.getDato().isBefore(LocalDateTime.now())) {
                hasAktiv = true;
            }
        }

        return hasAktiv;
    }
}
