package model;

import java.util.ArrayList;

public class Deltager implements Comparable<Deltager> {
    // section S1
    private final String navn;
    private final String mobil;

    /**
     * Association 1 --- 0..* Tur
     */
    private final ArrayList<Tur> ture = new ArrayList<>();

    /**
     * Association 0..* --- 0..* Badge
     */
    private final ArrayList<Badge> badges = new ArrayList<>();

    public Deltager(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    // getters
    public ArrayList<Tur> getTure() {
        return new ArrayList<>(ture);
    }

    public ArrayList<Badge> getBadges() {
        return new ArrayList<>(badges);
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    // adders
    public void addTur(Tur tur) {
        ture.add(tur);
    }

    public void addBadge(Badge badge) {
        badges.add(badge);
    }

    // removers
    public void removeTur(Tur tur) {
        ture.remove(tur);
    }

    public void removeBadge(Badge badge) {
        badges.remove(badge);
    }

    @Override
    public String toString() {
        return String.format("%s, mobil %s", navn, mobil);
    }

    // section S4
    /**
     * Returnerer samlet antal km deltageren har cyklet.
     *
     * @return km cyklet i alt over alle ture.
     */
    public int kmIAlt() {
        int kmIAlt = 0;

        for (Tur tur : ture) {
            kmIAlt += tur.getAntalKm();
        }

        return kmIAlt;
    }


    public int minIAlt() {
        int minIAlt = 0;

        for (Tur tur : ture) {
            minIAlt += tur.getAntalMinutter();
        }

        return minIAlt;
    }

    // section S10

    /**
     * Sammenligner 2 deltagere med hinanden, først på navn, dernæst på mobil.
     *
     * @param other objektet der skal sammenlignes med.
     * @return
     */
    @Override
    public int compareTo(Deltager other) {
        int firstCompare = this.navn.compareTo(other.navn);
        if (firstCompare == 0)
            return this.mobil.compareTo(other.mobil);
        else return firstCompare;
    }
}
