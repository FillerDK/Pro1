package controller;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Controller {
    public static ArrayList<Bane> getBaner() {
        return Storage.getBaner();
    }

    public static ArrayList<Spiller> getSpillere() {
        return Storage.getSpillere();
    }

    // section S6
    public static Spiller opretSpiller(String navn, String uddannelse) {
        Spiller spiller = new Spiller(navn, uddannelse);
        Storage.storeSpiller(spiller);
        return spiller;
    }

    public static Booking opretBooking(LocalDate dato, LocalTime tid, boolean single,
                                       Spiller spiller, Bane bane) {
        Booking booking = new Booking(dato, tid, single, spiller, bane);
        spiller.addBooking(booking);
        bane.addBooking(booking);
        return booking;
    }

    public static Bane opretBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid,
                                 Kategori kategori) {
        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);
        Storage.storeBane(bane);
        return bane;
    }

    public static Kategori opretKategori(String navn, int prisKrSingle, int prisKrDouble) {
        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);
        Storage.storeKategori(kategori);
        return kategori;
    }

    // section S7
    public static int samletBooketDoubleTid(String uddannelse, Kategori kategori) {
        int bookedeTider = 0;

        for (Spiller spiller : Storage.getSpillere()) {
            String spillerUddannelse = spiller.getUddannelse();
            if (spillerUddannelse.equalsIgnoreCase(uddannelse))
                for (Booking booking : spiller.getBookinger()) {
                    Kategori kat = booking.getBane().getKategori();
                    if (!booking.isSingle() && kat.equals(kategori))
                        bookedeTider++;
                }
        }

        return bookedeTider;
    }

    // section S9

    /**
     * Returnerer en bane hvis der er en ledig, ellers returnerer null.
     * <p>
     * Note: nullable
     *
     * @param dato     Dato, som tjekkes for.
     * @param tid      Tid, som tjekkes for.
     * @param kategori Kategori, som tjekkes for.
     * @return
     */
    public static Bane findLedigBane(LocalDate dato, LocalTime tid, Kategori kategori) {
        Bane ledigBane = null;

        ArrayList<Bane> baner = Storage.getBaner();
        for (int i = 0; ledigBane != null && i < baner.size(); i++) {
            Bane bane = baner.get(i);
            if (bane.tidLedig(dato, tid)) {
                ledigBane = bane;
            }
        }

        return ledigBane;
    }

    // section S10
    public static void udskrivBookingerTilTekstFil(String filename) {
        String fname = "Semesterproeve Programmering juni 2023/src/model/" + filename + ".txt";
        File out = new File(fname);

        try (PrintWriter writer = new PrintWriter(out)) {
            try {
                ArrayList<Booking> bookinger = new ArrayList<>();
                for (Spiller spiller : Storage.getSpillere()) {
                    bookinger.addAll(spiller.getBookinger());
                }

                for (Booking booking : bookinger) {
                    String størrelse;
                    if (booking.isSingle())
                        størrelse = "Single";
                    else størrelse = "Double";
                    writer.printf("Bane nr: %d, dag: %s kl. %s, spil: %s, spiller: %s\n",
                            booking.getBane().getNummer(), booking.getDato(),
                            booking.getTid(), størrelse, booking.getSpiller().getNavn());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
