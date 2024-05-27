package controller;

import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    // section S7

    /**
     * Opretter en forestilling
     * og returnerer den.
     *
     * @param navn Navn på forestillingen.
     * @param startDato Start dato for forestillingen.
     * @param slutDato Slut dato for forestillingen.
     * @return
     */
    public static Forestilling opretForestilling(String navn, LocalDate startDato,
                                                 LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.addForestilling(forestilling);

        return forestilling;
    }

    /**
     * Opretter en kunde i systemet
     * og returnerer den.
     *
     * @param navn Navn på kunden.
     * @param mobil Mobilnummer på kunden.
     * @return
     */
    public static Kunde opretKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde);

        return kunde;
    }

    // section S7 + S10
    /**
     * Opretter forestillinger og kunder vha.
     * create metoderne i controlleren.
     */
    public static void initStorage() {
        // Forestillinger
        Forestilling evita = opretForestilling("Evita", LocalDate.of(2019, 01, 10),
                LocalDate.of(2019, 01, 20));
        Forestilling lykkePer = opretForestilling("Lykke Per", LocalDate.of(2019, 02, 01),
                LocalDate.of(2019, 02, 10));
        Forestilling chess = opretForestilling("Chess", LocalDate.of(2019, 01, 21),
                LocalDate.of(2019, 01, 30));

        // Kunder
        Kunde andersHansen = opretKunde("Anders Hansen", "11223344");
        Kunde peterJensen = opretKunde("Peter Jensen", "12345678");
        Kunde nielsMadsen = opretKunde("Niels Madsen", "12341234");

        // Bestillinger
        ArrayList<Plads> pladser1 = new ArrayList<>();
        pladser1.add(new Plads(10, 10, 100));
        pladser1.add(new Plads(10, 11, 100));
        Bestilling bestilling1 = opretBestillingMedPladser(evita, andersHansen,
                LocalDate.of(2019, 01, 15), pladser1);
    }

    // section S9
    /**
     * Opretter en bestilling og tilføjer de
     * valgte pladser til den.
     *
     * @param forestilling Forestilling, som bestilling oprettes til.
     * @param kunde Kunde, som opretter bestillingen.
     * @param dato Dato for hvornår bestillingen er gyldig.
     * @param pladser Pladser, som der tilføjes til bestillingen.
     * @throws RuntimeException hvis dato ikke er gyldig eller en
     *                          eller flere pladser ikke er ledige.
     * @return
     */
    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde,
                                                       LocalDate dato, ArrayList<Plads> pladser) {
        Bestilling bestilling = null;
        boolean pladserLedige = true;

        if (dato.isBefore(forestilling.getStartDato())
                || dato.isAfter(forestilling.getSlutDato())) {
            throw new RuntimeException("Dato er udenfor forestillingens periode");
        } else {
            for (int i = 0; pladserLedige && i < pladser.size(); i++) {
                Plads plads = pladser.get(i);
                int række = plads.getRække();
                int nr = plads.getNr();
                if (!forestilling.erPladsLedig(række, nr, dato)
                        && !pladserLedige) {
                    pladserLedige = false;
                    throw new RuntimeException(
                            "En eller flere af de valgte pladser er allerede optaget!");
                } else {
                    bestilling = new Bestilling(dato, kunde, forestilling);
                    bestilling.addPladser(pladser);
                    forestilling.addBestilling(bestilling);
                    kunde.addBestilling(bestilling);
                }
            }
        }

        return bestilling;
    }

    // section S11

}
