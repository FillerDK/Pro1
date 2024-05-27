package controller;

import model.Deltagelse;
import model.Fag;
import model.Lektion;
import model.Studerende;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {
    public static ArrayList<Fag> getFag() {
        return Storage.getAlleFag();
    }

    public static ArrayList<Lektion> getLektioner(Fag fag) {
        return fag.getLektioner();
    }

    public static ArrayList<Deltagelse> getDeltagelser(Lektion lektion) {
        return lektion.getDeltagelser();
    }

    public static Studerende createStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.storeStuderende(studerende);
        return studerende;
    }

    public static Fag createFag(String navn, String klasse) {
        Fag fag = new Fag(navn, klasse);
        Storage.storeFag(fag);
        return fag;
    }

    public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        Lektion lektion = new Lektion(dato, startTid, lokale);
        fag.addLektion(lektion);
        return lektion;
    }

    public static void initStorage() {
        createStuderende("Peter Hansen", "ph@stud.dk");
        createStuderende("Tina Jensen", "tj@stud.dk");
        createStuderende("Sasche Petersen", "sp@stud.dk");

        Fag fag = new Fag("PRO1", "20S");
        createFag(fag.getNavn(), fag.getKlasse());
        createFag("PRO1", "20T");
        createFag("SU1", "20S");

        createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30), "A1.32", fag);
        createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30), "A1.32", fag);
        createLektion(LocalDate.of(2021, 3, 2), LocalTime.of(8, 30), "A1.32", fag);
        createLektion(LocalDate.of(2021, 3, 2), LocalTime.of(10, 30), "A1.32", fag);
    }

    public static void opretDeltagelser(Fag fag) {

    }
}
