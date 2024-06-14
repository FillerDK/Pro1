package model;

import java.util.ArrayList;

public class Hold {
    // section S1
    private final String navn;

    /**
     * Association 1 --> 0..* Deltager
     */
    private final ArrayList<Deltager> deltagere = new ArrayList<>();

    public Hold(String navn) {
        this.navn = navn;
    }

    // getters
    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public String getNavn() {
        return navn;
    }

    // adders
    public void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    // removers
    public void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    @Override
    public String toString() {
        return navn;
    }

    // section S5
    /**
     * Holdet skal bestå af mindst en deltager.
     *
     * @return deltager med flest km.
     */
    public Deltager deltagerMedFlestKm() {
        Deltager deltagerMedFlestKm = deltagere.get(0);

        for (Deltager deltager : deltagere) {
            if (deltager.kmIAlt() > deltagerMedFlestKm.kmIAlt()) {
                deltagerMedFlestKm = deltager;
            }
        }

        return deltagerMedFlestKm;
    }

    // section S7
    /**
     * Returnerer en liste med alle de badges, deltagerne på holdet
     * har opnået. Ingen badges fremkommer mere end 1 gang.
     *
     * @return liste med alle badges et hold har opnået.
     */
    public ArrayList<Badge> holdBadges() {
        ArrayList<Badge> holdBadges = new ArrayList<>();

        for (Deltager deltager : deltagere) {
            for (Badge badge : deltager.getBadges()) {
                if (!holdBadges.contains(badge)) {
                    holdBadges.add(badge);
                }
            }
        }

        return holdBadges;

    }

    // section S8
    /**
     * Returnerer et array med de deltagere på holdet, som har cyklet en tur, hvis længde er
     * længere end kmGrænse, og hvis varighed er kortere end tidsGrænse.
     *
     * @param minutGrænse maks antal minutter en tur må tage.
     * @param kmGrænse minimum antal km en tur skal være.
     * @return et arrat med alle deltagere under kategorien "hurtige deltagere".
     */
    public Deltager[] hurtigeDeltagere(int minutGrænse, int kmGrænse) {
        int antalHurtigeDeltagere = 0;

        for (Deltager deltager : deltagere) {
            boolean godkendt = false;
            ArrayList<Tur> ture = deltager.getTure();
            for (int i = 0; !godkendt && i < ture.size(); i++) {
                Tur tur = ture.get(i);
                if (tur.getAntalKm() > kmGrænse &&
                        tur.getAntalMinutter() < minutGrænse) {
                    antalHurtigeDeltagere++;
                    godkendt = true;
                }
            }
        }

        Deltager[] hurtigeDeltagere = new Deltager[antalHurtigeDeltagere];
        int i = 0;

        for (Deltager deltager : deltagere) {
            boolean godkendt = false;
            ArrayList<Tur> ture = deltager.getTure();
            for (int j = 0; !godkendt && j < ture.size(); j++) {
                Tur tur = ture.get(j);
                if (tur.getAntalKm() > kmGrænse &&
                        tur.getAntalMinutter() < minutGrænse) {
                    hurtigeDeltagere[i] = deltager;
                    i++;
                }
            }
        }

        return hurtigeDeltagere;
    }
}
