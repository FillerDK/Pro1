package model;

import java.util.ArrayList;

public class Deltager extends Person {

    private String adgangskode;

    /**
     * Association 1 --> 0..* Ledsager
     */
    private final ArrayList<Tilmelding> tilmeldinger;

    public Deltager(String name, String tlf, String email, String adresse, String adgangskode) {
        super(name, tlf, email, adresse);
        this.adgangskode = adgangskode;
        this.tilmeldinger = new ArrayList<>();
    }

    public ArrayList<Tilmelding> hentTilmedlinger() {
        return new ArrayList<>(this.tilmeldinger);
    }

    /**
     * Tilføjer en ny tilmelding til denne deltager.
     *
     * @param tilmelding Tilmelding, der skal tilføjes
     */
    public void addTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }

    public String hentAdgangskode() {
        return adgangskode;
    }

    public void setAdgangskode(String adgangskode) {
        this.adgangskode = adgangskode;
    }

}
