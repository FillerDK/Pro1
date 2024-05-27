package model;

public class Service {
    private final String navn;
    private final String beskrivelse;
    private final int pris;

    public Service(String navn, String beskrivelse, int pris) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }

    public int hentPris() {
        return pris;
    }

    public String hentNavn() {
        return navn;
    }

    public String hentBeskrivelse() {
        return beskrivelse;
    }

    @Override
    public String toString() {
        return String.format("%s\n\t- %d\n\t-%s", navn, pris, beskrivelse);
    }
}
