package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private String navn;
    private String klasse;

    private ArrayList<Lektion> lektioner = new ArrayList<>();

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
    }

    public String getNavn() {
        return navn;
    }

    public String getKlasse() {
        return klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return new ArrayList<>(lektioner);
    }

    public void addLektion(Lektion lektion) {
        lektioner.add(lektion);
    }

    public void removeLektion(Lektion lektion) {
        lektioner.remove(lektion);
    }

    public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {
        ArrayList<Studerende> sygeStuds = new ArrayList<>();
        for (Lektion l : lektioner) {
            if (l.getDato().equals(dato)) {
                for (Deltagelse d : l.getDeltagelser()) {
                    if (d.getStatus() == DeltagerStatus.SYG && !sygeStuds.contains(d.getStuderende())) {
                        sygeStuds.add(d.getStuderende());
                    }
                }
            }
        }
        return sygeStuds;
    }
}
