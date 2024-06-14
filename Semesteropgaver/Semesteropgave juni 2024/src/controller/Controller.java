package controller;

import model.Badge;
import model.Deltager;
import model.Hold;
import model.Tur;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Controller {
    // section S3
    // create
    public static Hold createHold(String navn) {
        Hold hold = new Hold(navn);
        Storage.storeHold(hold);
        return hold;
    }

    public static Deltager createDeltager(String navn, String mobil) {
        Deltager deltager = new Deltager(navn, mobil);
        return deltager;
    }

    public static Tur createTur(LocalDate dato, int antalMinutter, int antalKm, Deltager deltager) {
        Tur tur = new Tur(dato, antalMinutter, antalKm, deltager);
        deltager.addTur(tur);
        return tur;
    }

    public static Badge createBadge(String beskrivelse) {
        Badge badge = new Badge(beskrivelse);
        Storage.storeBadge(badge);
        return badge;
    }


    // sammenhænge
    public static void linkDeltagerTilHold(Deltager deltager, Hold hold) {
        hold.addDeltager(deltager);
    }

    public static void linkDeltagerTilBadge(Deltager deltager, Badge badge) {
        deltager.addBadge(badge);
        badge.addDeltager(deltager);
    }

    public static ArrayList<Deltager> getDeltagere() {
        ArrayList<Deltager> deltagere = new ArrayList<>();

        for (Hold hold : Storage.getHold()) {
            for (Deltager deltager : hold.getDeltagere()) {
                deltagere.add(deltager);
            }
        }

        return deltagere;
    }

    public static ArrayList<Tur> getTure(Deltager deltager) {
        ArrayList<Tur> ture = new ArrayList<>();

        for (Tur tur : deltager.getTure()) {
            ture.add(tur);
        }

        return ture;
    }

    // section S9
    /**
     * Returnerer en liste med en tekststrend (String) for hvert deltager på holdet.
     *
     * @param hold hold, man ønsker en liste over.
     * @return liste over deltagere på et hold.
     */
    public static ArrayList<String> deltagerOversigt(Hold hold) {
        ArrayList<String> deltagerOversigt = new ArrayList<>();

        for (Deltager deltager : hold.getDeltagere()) {
            StringBuilder badgeString = new StringBuilder();

            ArrayList<Badge> badges = deltager.getBadges();

            if (!badges.isEmpty()) {
                for (Badge badge : deltager.getBadges()) {
                    badgeString.append(badge.getBeskrivelse() + " ");
                }
            } else {
                badgeString.append("-ingen badges-");
            }

            String str = String.format("%s %s, %d km, badges: %s", deltager.getNavn(),
                    deltager.getMobil(), deltager.kmIAlt(), badgeString.toString());
            deltagerOversigt.add(str);
        }

        return deltagerOversigt;
    }

    // section S10
    /**
     * Udskriver alle hold deltageres navne, mobilnumre, antalkm samt badges.
     *
     * @param filnavn navn på den fil der udskrives til.
     */
    public static void udskrivDeltagerOversigt(String filnavn) {
        String fnavn = "Semesteropgaver/Semesteropgave juni 2024/src/model/" + filnavn + ".txt";
        File out = new File(fnavn);

        try (PrintWriter writer = new PrintWriter(out)) {
            for (Hold h : Storage.getHold()) {
                writer.println("Hold: " + h.getNavn());
                if (!h.getDeltagere().isEmpty()) {
                    ArrayList<String> oversigt = deltagerOversigt(h);
                    Collections.sort(oversigt);
                    for (String s : oversigt) {
                        writer.println(s);
                    }
                } else {
                    writer.println("- ingen deltagere -");
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
