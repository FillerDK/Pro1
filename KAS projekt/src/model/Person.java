package model;

public class Person {
    private String navn;
    private String tlf;
    private String email;
    private String adresse;

    public Person(String navn, String tlf, String email, String adresse) {
        this.navn = navn;
        this.tlf = tlf;
        this.email = email;
        this.adresse = adresse;
    }

    public String hentNavn() {
        return navn;
    }

    public String hentEmail() {
        return email;
    }

    public String hentTlf() {
        return tlf;
    }

    public String hentAdresse() {
        return adresse;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
