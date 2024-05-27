package model;

import java.awt.print.PageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Forestilling {
    // section S1
    private final String navn;
    private final LocalDate startDato;
    private final LocalDate slutDato;

    /**
     * Association 1 --> 0..* Bestilling
     */
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    // section gettere
    /**
     * Henter alle bestillinger for denne forestilling.
     *
     * Note: nullable
     */
    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    /**
     * Henter start dato for denne forestilling.
     *
     * @return
     */
    public LocalDate getStartDato() {
        return startDato;
    }

    /**
     * Henter slut dato for denne forestilling.
     *
     * @return
     */
    public LocalDate getSlutDato() {
        return slutDato;
    }

    // section addere
    /**
     * Tilføjer en ny bestilling til denne forestilling.
     *
     * @param bestilling Bestilling, der skal tilføjes
     */
    public void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    // section S3
    /**
     * Returnerer hvor mange pladser der er bestilt,
     * på en specifik dato.
     *
     * @param dato Dato, som der tjekkes igennem.
     * @return
     */
    public int antalBestiltePladserPåDag(LocalDate dato) {
        int pladser = 0;

        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDato().equals(dato))
                for (Plads plads : bestilling.getPladser()) {
                    pladser++;
                }
        }

        return pladser;
    }

    // section S4
    /**
     * Returnerer den dag der har været flest pladser
     * bestilt til forestillingen.
     * Hvis der er flere dage returneres kun en af disse.
     *
     * Note: nullable
     *
     * @return
     */
    public LocalDate succesDato() {
        int bedsteDag = 0;

        LocalDate succesDato = null;
        LocalDate dato = startDato;
        Period period = Period.between(startDato, slutDato);

        for (int i = 0; i < period.getDays(); i++) {
            int bestiltePladser = antalBestiltePladserPåDag(dato);
            if (bestiltePladser > bedsteDag) {
                bedsteDag = bestiltePladser;
                succesDato = dato;
            }

            dato = dato.plusDays(1);
        }

        return succesDato;
    }

    // section S8
    /**
     * Returnerer TRUE hvis pladsen er ledig
     * og FALSE hvis pladsen ikke er ledig.
     *
     * @param række Række der tjekkes på.
     * @param nr Nummer der tjekkes på.
     * @param dato Dato der tjekkes på.
     * @return
     */
    public boolean erPladsLedig(int række, int nr, LocalDate dato) {
        boolean pladsLedig = true;

        for (int i = 0; pladsLedig && i < bestillinger.size(); i++) {
            Bestilling bestilling = bestillinger.get(i);
            if (bestilling.getDato().equals(dato)) {
                ArrayList<Plads> pladser = new ArrayList<>(bestilling.getPladser());
                for (int j = 0; pladsLedig && j < pladser.size(); j++) {
                    Plads plads = pladser.get(j);
                    if (plads.getRække() == række && plads.getNr() == nr)
                        pladsLedig = false;
                }
            }
        }

        return pladsLedig;
    }
}
