package model;

public class Firma {

    private final String navn;
    private final String tlf;
    private final String cvr;

    public Firma(String navn, String tlf, String cvr) {
        this.navn = navn;
        this.tlf = tlf;
        this.cvr = cvr;
    }

    public String hentNavn() {
        return navn;
    }
}
