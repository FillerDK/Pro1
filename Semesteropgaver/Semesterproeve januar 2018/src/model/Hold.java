package model;

import java.util.ArrayList;

public class Hold {
    // section S1
    private final String betegnelse;
    private final String holdleder;

    /**
     * Forced association 0..* --- 1 Uddannelse
     */
    private final Uddannelse uddannelse;

    /**
     * Association 0..1 --- 0..* Tutor
     */
    private ArrayList<Tutor> tutore = new ArrayList<>();

    public Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;
        this.uddannelse = uddannelse;
    }

    // section adders
    public void addTutor(Tutor tutor) {
        tutore.add(tutor);
    }

    // section getters
    public ArrayList<Tutor> getTutore() {
        return new ArrayList<>(tutore);
    }

    public Uddannelse getUddannelse() {
        return uddannelse;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    // section removers
    public void removeTutor(Tutor tutor) {
        tutore.remove(tutor);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", uddannelse, betegnelse, holdleder);
    }

    // section S3
    /**
     * Returnerer den samlede pris for arrangementerne
     * som holdet deltager i.
     *
     * @return
     */
    public double arrangementPris() {
        double totalPris = 0;

        for (Tutor tutor : tutore) {
            totalPris += tutor.arrangementPris();
        }

        return totalPris;
    }

    // section S4
    /**
     * Returnerer TRUE såfremt holdet allrede har et arrangement,
     * der tidsmæssigt overlapper med det arrangement,
     * der gives som parameter.
     *
     * @param arrangement Arrangement, der tjekkes for overlap.
     * @return
     */
    public boolean harTidsoverlap(Arrangement arrangement) {
        boolean tidsoverlap = false;

        for (int i = 0; tidsoverlap && i < tutore.size(); i++) {
            Tutor tutor = tutore.get(i);
            ArrayList<Arrangement> arrangementer = tutor.getArrangementer();
            for (int j = 0; tidsoverlap && i < arrangementer.size(); j++) {
                Arrangement a = arrangementer.get(j);
                if (a.getDato().equals(arrangement.getDato())) {
                    tidsoverlap = true;
                }
            }
        }

        return tidsoverlap;
    }


}
