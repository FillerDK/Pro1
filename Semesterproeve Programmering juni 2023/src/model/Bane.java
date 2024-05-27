package model;

import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    // section 1
    private final int nummer;
    private final boolean inde;
    private final LocalTime førsteTid;
    private final LocalTime sidsteTid;

    /**
     * Association 1 --> 0..* Booking
     */
    private final ArrayList<Booking> bookinger = new ArrayList<>();

    /**
     * Association 0..* --> 1 Kategori
     */
    private final Kategori kategori;

    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid,
                Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;
    }

    public void addBooking(Booking booking) {
        bookinger.add(booking);
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public Kategori getKategori() {
        return kategori;
    }

    public int getNummer() {
        return nummer;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }

    // section S2
    public int bookedeTimerPåDato(LocalDate dato) {
        int timer = 0;

        for (Booking booking : bookinger) {
            if (booking.getDato().isEqual(dato))
                timer++;
        }

        return timer;
    }

    // section S4
    public Booking[] antalBookningerPrTime() {
        // TODO
        Booking[] bookinger = new Booking[18];
        /*
        for (Booking booking : this.bookinger) {
            int test = (int) booking.getTid();
            bookinger[]
        }
        */

        return bookinger;
    }

    // section S8
    public boolean tidLedig(LocalDate dato, LocalTime tid) {
        boolean ledig = true;

        ArrayList<Spiller> spillere = new ArrayList<>(Storage.getSpillere());
        for (int i = 0; ledig && i < spillere.size(); i++) {
            ArrayList<Booking> bookinger = new ArrayList<>(spillere.get(i).getBookinger());
            for (int j = 0; ledig && j < bookinger.size(); j++) {
                Booking booking = bookinger.get(j);
                if (booking.getDato().equals(dato) &&
                    booking.getTid().equals(tid))
                    ledig = false;
            }
        }

        return ledig;
    }

    @Override
    public String toString() {
        String lokation;
        if (inde)
            lokation = "inde";
        else lokation = "ude";

        return String.format("Nr. %d %s (%s -> %s), %s",
                nummer, lokation, førsteTid, sidsteTid, kategori.getNavn());
    }
}
