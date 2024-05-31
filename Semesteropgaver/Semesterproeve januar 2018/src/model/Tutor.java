package model;

import java.util.ArrayList;

public class Tutor {
    // section S1
    private final String navn;
    private final String email;

    /**
     * Association 0..* --- 0..1 Hold
     */
    private Hold hold;

    /**
     * Association 0..* --> 0..* Arrangement
     */
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    // section adders
    public void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    // section getters
    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public Hold getHold() {
        return hold;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    // section setters
    public void setHold(Hold hold) {
        if (this.hold == null)
            this.hold = hold;
        else {
            this.hold.removeTutor(this);
            this.hold = hold;
        }
    }

    // section removers
    public void removeArrangement(Arrangement arrangement) {
        arrangementer.remove(arrangement);
    }

    @Override
    public String toString() {
        return String.format("%s %s", navn, email);
    }

    // section S2
    /**
     * Returnerer den totale pris for alle arrangementer denne
     * tutor har ansvaret for.
     *
     * @return
     */
    public double arrangementPris() {
        double totalPris = 0;

        for (Arrangement arrangement : arrangementer) {
            totalPris += arrangement.getPris();
        }

        return totalPris;
    }


}
