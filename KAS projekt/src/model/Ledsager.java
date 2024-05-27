package model;

import java.util.ArrayList;

public class Ledsager extends Person {

    /**
     * Association 0..* --> 0..* Udflugt
     */
    private final ArrayList<Udflugt> udflugter;

    /**
     * Forced association 0..1 --> 0..1 Tilmelding
     * Note: Nullable
     */
    private Tilmelding tilmelding;


    public Ledsager(String name, String tlf, String email, String adresse) {
        super(name, tlf, email, adresse);
        this.udflugter = new ArrayList<>();
    }


    /**
     * Returnerer prisen for ledsagerens udflugter
     */
    public int prisForUdflugter() {
        int pris = 0;
        if (!this.udflugter.isEmpty()) {
            for (Udflugt udflugt : this.udflugter) {
                pris += udflugt.hentPris();
            }
        }
        return pris;
    }

    public void addUdflugt(Udflugt udflugt) {
        this.udflugter.add(udflugt);
    }

    public void fjernUdflugt(Udflugt udflugt) {
        this.udflugter.remove(udflugt);
    }

    public ArrayList<Udflugt> hentUdflugter() {
        return new ArrayList<>(this.udflugter);
    }

    /**
     * Note: Nullable return value
     */
    public Tilmelding hentTilmelding() {
        return tilmelding;
    }

    // Setter methods

    /**
     * Note: Nullable param group
     */
    public void setTilmelding(Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
    }

    @Override
    public String toString() {
        return String.format(
                "%s (%s %s)",
                this.hentNavn(),
                this.tilmelding.hentDeltager().hentNavn(),
                this.tilmelding.hentDeltager().hentTlf()
        );
    }


}
