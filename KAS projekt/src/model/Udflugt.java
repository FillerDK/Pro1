package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt implements Comparable<Udflugt> {
    private final String navn;
    private final String lokation;
    private final LocalDate dato;
    private final int pris;
    private final String beskrivelse;

    /**
     * Association 0..* --> 0..*
     */
    private final ArrayList<Ledsager> ledsagere;

    public Udflugt(String beskrivelse, int pris, LocalDate dato, String lokation, String navn) {
        this.beskrivelse = beskrivelse;
        this.pris = pris;
        this.dato = dato;
        this.lokation = lokation;
        this.navn = navn;
        this.ledsagere = new ArrayList<>();
    }

    public void addLedsager(Ledsager ledsager) {
        this.ledsagere.add(ledsager);
    }

    public void fjernLedsager(Ledsager ledsager) {
        this.ledsagere.remove(ledsager);
    }

    public ArrayList<Ledsager> hentLedsagere() {
        return new ArrayList<>(this.ledsagere);
    }

    public int hentPris() {
        return pris;
    }

    public String hentNavn() {
        return navn;
    }

    public String hentLokation() {
        return lokation;
    }

    public LocalDate hentDato() {
        return dato;
    }

    public String hentBeskrivelse() {
        return beskrivelse;
    }

    @Override
    public String toString() {
        return String.format("%s\n\t- %d\n\t-%s", navn, pris, beskrivelse);
    }

    /**
     * Compare to method (Samlign dato)
     */
    @Override
    public int compareTo(Udflugt other) {
        return this.dato.compareTo(other.dato);
    }
}
