package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private final String navn;
    private final LocalDate startDato;
    private final LocalDate slutDato;
    private final String beskrivelse;
    private final LocalDate tilmeldingsfrist;
    private final String lokation;
    private final int konferenceAfgift;

    /**
     * Composition 1 --> 0..* Tilmelding
     */
    private final ArrayList<Tilmelding> tilmeldinger;

    /**
     * Association 0..* --> 0..* Hotel
     */
    private final ArrayList<Hotel> hoteller;

    /**
     * Composition 1 --> 0..* Udflugter
     */
    private final ArrayList<Udflugt> udflugter;

    public Konference(
            int konferenceAfgift,
            String lokation,
            LocalDate tilmeldingsfrist,
            String beskrivelse,
            LocalDate slutDato,
            LocalDate startDato,
            String navn
    ) {
        this.konferenceAfgift = konferenceAfgift;
        this.lokation = lokation;
        this.tilmeldingsfrist = tilmeldingsfrist;
        this.beskrivelse = beskrivelse;
        this.slutDato = slutDato;
        this.startDato = startDato;
        this.navn = navn;
        this.tilmeldinger = new ArrayList<>();
        this.hoteller = new ArrayList<>();
        this.udflugter = new ArrayList<>();
    }

    public void addTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }

    public void addHotel(Hotel hotel) {
        this.hoteller.add(hotel);
    }

    public void addUdflugt(Udflugt udflugt) {
        this.udflugter.add(udflugt);
    }

    public ArrayList<Tilmelding> hentTilmeldinger() {
        return new ArrayList<>(this.tilmeldinger);
    }

    public void fjernTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.remove(tilmelding);
    }

    public ArrayList<Hotel> hentHoteller() {
        return new ArrayList<>(this.hoteller);
    }

    public ArrayList<Udflugt> hentUdflugter() {
        return new ArrayList<>(this.udflugter);
    }

    public int hentKonferenceAfgift() {
        return konferenceAfgift;
    }

    public String hentNavn() {
        return navn;
    }

    public LocalDate hentTilmeldingsfrist() {
        return tilmeldingsfrist;
    }

    public LocalDate hentStartDato() {
        return startDato;
    }

    public LocalDate hentSlutDato() {
        return slutDato;
    }

    public String hentBeskrivelse() {
        return beskrivelse;
    }

    public String hentLokation() {
        return lokation;
    }

    @Override
    public String toString() {
        return String.format("%s (Fra %s til %s)", navn, startDato, slutDato);
    }
}
