package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Vagt {
    // section S1
    private final String navn;
    private final LocalDateTime tidFra;
    private final LocalDateTime tidTil;

    /**
     * Association 1 --- 0..* Antal
     */
    private final ArrayList<Antal> antal = new ArrayList<>();

    /**
     * Association 0..* --- 0..* Medarbejder
     */
    private final ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    // adders
    public void addAntal(Antal antal) {
        this.antal.add(antal);
    }

    public void addMedarbejder(Medarbejder medarbejder) {
        medarbejdere.add(medarbejder);
    }

    // getters
    public ArrayList<Antal> getAntal() {
        return new ArrayList<>(antal);
    }

    public ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return String.format("%s", navn);
    }

    // section S2
    /**
     * Returnerer en medarbejder, som møder på den angivne tidspunkt,
     * og arbejder mindst det angivne antal timer.
     *
     * Note: nullable
     *
     * @param tidspunkt Tidspunkt angivet.
     * @param antalTimer Antal timer angivet.
     * @return en medarbejder passende til angivne parametre
     */
    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        Medarbejder medarbejder = null;

        for (int i = 0; medarbejder != null && i < medarbejdere.size(); i++) {
            Medarbejder m = medarbejdere.get(i);
            if (m.getTypiskMødetid().equals(tidspunkt) && m.getAntalTimerPrDag() == antalTimer) {
                medarbejder = m;
            }
        }

        return medarbejder;
    }

    // section S3
    /**
     * Returnerer vagtens samlede timeforbrug afrundet opad til nærmeste hele time.
     *
     * @return tilknyttede medarbejdere ganget med vagtens varighed
     */
    public int beregnTimeforbrug() {
        double vagtiTimer = ChronoUnit.HOURS.between(tidFra, tidTil);

        return (int) vagtiTimer * medarbejdere.size();
    }

    // section S4
    /**
     * Returnerer antal medarbejdere tilknyttet vagten med den angivne funktion.
     *
     * @param funktion Funktion angivet
     * @return antal med arbejdere tilknyttet vagten med den angivne funktion
     */
    public int antalMedarbejdereMedFunktion(Funktion funktion) {
        int antalMedarbejdere = 0;

        for (Medarbejder medarbejder : medarbejdere) {
            for (Funktion f : medarbejder.getFunktioner()) {
                if (f.equals(funktion)) {
                    antalMedarbejdere++;
                }
            }
        }

        return antalMedarbejdere;
    }

    // section S5
    /**
     * Returnerer et array med de medarbejdere på vagten, som typisk
     * har mødetid senere end vagtens start tid.
     *
     * @return et array med medarbejdere hvis mødetid er senere end
     * vagtens start tid
     */
    public Medarbejder[] skalAdviseresOmMødetid() {
        ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

        for (Medarbejder m : this.medarbejdere) {
            if (m.getTypiskMødetid().isAfter(LocalTime.of(tidFra.getHour(), tidFra.getMinute()))) {
                medarbejdere.add(m);
            }
        }

        Medarbejder[] medarbejders = new Medarbejder[medarbejdere.size()];
        for (int i = 0; i < medarbejders.length; i++) {
            medarbejders[i] = medarbejdere.get(i);
        }

        return medarbejders;
    }

    // section S6

    /**
     * Returnerer status for om der er nok eller manglende resourcer.
     *
     * @return "Resourcer tildelt" hvis nok resourcer.
     * Ellers returneres "Manglende resourcer".
     */
    public String status() {
        boolean nokRessourcer = true;
        String status = "Resourcer tildelt";
        ArrayList<Antal> antal = this.antal;

        for (int i = 0; nokRessourcer && i < antal.size(); i++) {
            int ant = 0;
            Funktion funktion = antal.get(i).getFunktion();
            for (Medarbejder medarbejder : medarbejdere) {
                boolean funktionFundet = false;
                ArrayList<Funktion> funktioner = medarbejder.getFunktioner();
                for (int j = 0; !funktionFundet && j < funktioner.size(); j++) {
                    if (funktioner.get(j) == funktion) {
                        funktionFundet = true;
                        ant++;
                    }
                }
            }
            if (ant != antal.get(i).getAntal()) {
                nokRessourcer = false;
                status = "Manglende resourcer";
            }
        }

        return status;
    }
}
