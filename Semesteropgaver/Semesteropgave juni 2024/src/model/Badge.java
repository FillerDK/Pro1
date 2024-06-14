package model;

import storage.Storage;

import java.util.ArrayList;

@SuppressWarnings("GrazieInspection")
public class Badge {
    // section S1
    private final String beskrivelse;

    /**
     * Association 0..* --- 0..* Deltager
     */
    private final ArrayList<Deltager> deltagere = new ArrayList<>();

    public Badge(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    // getters
    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    // adders
    public void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    // removers
    public void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    // section S6
    /**
     * Returnerer den første deltager, som har det aktuelle badge.
     *
     * Note: nullable
     *
     * @return første deltager med det aktuelle badge.
     */
    public Deltager findDeltager() {
        Deltager deltager = null;
        boolean fundet = false;

        for (int i = 0; !fundet && i < deltagere.size(); i++) {
            Deltager deltager1 = deltagere.get(i);
            for (int j = 0; !fundet && j < deltager1.getBadges().size(); j++) {
                Badge badge = deltager1.getBadges().get(j);
                if (badge == this) {
                    fundet = true;
                    deltager = deltager1;
                }
            }
        }

        return deltager;
    }
}
