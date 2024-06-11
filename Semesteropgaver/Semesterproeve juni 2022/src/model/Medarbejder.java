package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private final String navn;
    private final int antalTimerPrDag;
    private final LocalTime typiskMødetid;

    /**
     * Association 0..* --- 0..* Vagt
     */
    private final ArrayList<Vagt> vagter = new ArrayList<>();

    /**
     * Association 0..* --- 0..* Funktion
     */
    private final ArrayList<Funktion> funktioner = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    // adders
    // section S7
    /* Gammel metode:
    public void addVagt(Vagt vagt) {
        vagter.add(vagt);
    }*/
    /**
     * Knytter en medarbejder til en vagt, hvis medarbejderen ikke allerede har en
     * vagt indenfor samme tidstum.
     *
     * @param vagt Vagt, som medarbejder tilknyttes
     */
    public void addVagt(Vagt vagt) throws RuntimeException {
        boolean valid = true;
        for (int i = 0; valid && i < vagter.size(); i++) {
            Vagt v = vagter.get(i);
            LocalDateTime paramTidFra = vagt.getTidFra();
            LocalDateTime paramTidTil = vagt.getTidTil();
            LocalDateTime listTidFra = v.getTidFra();
            LocalDateTime listTidTil = v.getTidTil();

            if (paramTidFra.isBefore(listTidTil) &&
                    paramTidFra.isAfter(listTidFra) ||
                    paramTidTil.isBefore(listTidTil) &&
                            paramTidTil.isAfter(listTidFra) ||
                    paramTidFra.isEqual(listTidFra) &&
                            paramTidTil.isEqual(listTidTil)) {
                valid = false;
                String str = String.format("Medarbejder: %s, eksisterende vagt: %s", navn, v.getNavn());
                throw new RuntimeException(str);
            }
        }

        if (valid) {
            vagter.add(vagt);
            vagt.addMedarbejder(this);
        }
    }

    public void addFunktion(Funktion funktion) {
        funktioner.add(funktion);
    }

    // getters
    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return String.format("%s, Typisk mødetid: %s", navn, typiskMødetid);
    }
}
