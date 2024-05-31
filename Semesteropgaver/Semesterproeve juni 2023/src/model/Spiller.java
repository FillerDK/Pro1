package model;

import java.util.ArrayList;

public class Spiller {
    // section S1
    private final String navn;
    private final String uddannelse;

    /**
     * Association 1 --> 0..* Booking
     */
    private final ArrayList<Booking> bookinger = new ArrayList<>();

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    public void addBooking(Booking booking) {
        bookinger.add(booking);
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    // section S3
    public int samletPris(Kategori kategori) {
        int samletPris = 0;

        for (Booking booking : bookinger) {
            if (booking.getBane().getKategori() == kategori)
                samletPris += booking.beregnPris();
        }

        return samletPris;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", navn, uddannelse);
    }
}
