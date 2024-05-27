package model;

import java.util.ArrayList;

public class Hotel {
    private final String navn;
    private final String adresse;
    private final int enkeltVærelsesPris;
    private final int dobbeltVærelsesPris;

    /**
     * Forced association 0..1 --> 1 Hotelbestyrer
     */
    private Hotelbestyrer hotelbestyrer;

    /**
     * Composition 1 --> 0..* Serice
     */
    private final ArrayList<Service> services;

    /**
     * Association 0..1 --> 0..* Tilmelding
     */
    private final ArrayList<Tilmelding> tilmeldinger;

    public Hotel(
            int dobbeltVærelsesPris,
            int enkeltVærelsesPris,
            String adresse,
            String navn,
            Hotelbestyrer hotelbestyrer
    ) {
        this.hotelbestyrer = hotelbestyrer;
        this.dobbeltVærelsesPris = dobbeltVærelsesPris;
        this.enkeltVærelsesPris = enkeltVærelsesPris;
        this.adresse = adresse;
        this.navn = navn;
        this.services = new ArrayList<>();
        this.tilmeldinger = new ArrayList<>();
    }

    /**
     * Tilføjer en ny service til dette hotel.
     *
     * @param service servicen der skal tilføjes
     */
    public void addService(Service service) {
        this.services.add(service);
    }

    public ArrayList<Service> hentServices() {
        return new ArrayList<>(this.services);
    }

    public void fjernTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.remove(tilmelding);
    }

    /**
     * Tilføjer en ny tilmelding til denne hotel.
     *
     * @param tilmelding Tilmelding, der skal tilføjes
     */
    public void addTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }

    public ArrayList<Tilmelding> hentTilmeldinger() {
        return new ArrayList<>(this.tilmeldinger);
    }

    public String hentNavn() {
        return navn;
    }

    public String hentAdresse() {
        return adresse;
    }

    public int hentEnkeltVærelsesPris() {
        return enkeltVærelsesPris;
    }

    public int hentDobbeltVærelsesPris() {
        return dobbeltVærelsesPris;
    }

    public Hotelbestyrer hentHotelbestyrer() {
        return hotelbestyrer;
    }

    public void setHotelbestyrer(Hotelbestyrer hotelbestyrer) {
        this.hotelbestyrer = hotelbestyrer;
    }

    @Override
    public String toString() {
        return String.format("%s", this.navn);
    }
}
