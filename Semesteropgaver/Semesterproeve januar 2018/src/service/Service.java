package service;

import model.Arrangement;
import model.Hold;
import model.Tutor;
import model.Uddannelse;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Service {
    // section S6
    // section create methods
    public static Uddannelse opretUddannelse(String navn) {
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.storeUddannelse(uddannelse);
        return uddannelse;
    }

    public static Hold opretHold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        Hold hold = new Hold(betegnelse, holdleder, uddannelse);
        uddannelse.addHold(hold);
        return hold;
    }

    public static Tutor opretTutor(String navn, String email) {
        Tutor tutor = new Tutor(navn, email);
        Storage.storeTutor(tutor);
        return tutor;
    }

    public static Arrangement opretArrangement(String titel, LocalDate dato, LocalTime startTid, LocalTime slutTid,
                                               double pris) {
        Arrangement arrangement = new Arrangement(titel, dato, startTid, slutTid, pris);
        Storage.storeArrangement(arrangement);
        return arrangement;
    }

    // både en del af S6 og S7
    public static void initStorage() {
        // Uddanelser
        Uddannelse dmu = opretUddannelse("DMU");
        Uddannelse finø = opretUddannelse("FINØ");

        // Hold
        Hold es = opretHold("1dmE17S", "Margrethe Dybdahl", dmu);
        Hold et = opretHold("1dmE17T", "Kristian Dorland", dmu);
        Hold eu = opretHold("1dmE17U", "Kell Ørhøj", dmu);
        Hold eb = opretHold("1fiE17B", "Karen Jensen", finø);

        // Tutore
        Tutor andersHansen = opretTutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor peterJensen = opretTutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor nielsMadsen = opretTutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor loneAndersen = opretTutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor madsMiller = opretTutor("Mads Miller", "mmm@students.eaaa.dk");

        // Arrangementer
        Arrangement rusfest = opretArrangement("Rusfest", LocalDate.of(2017, 8, 31),
                LocalTime.of(18, 00), LocalTime.of(23, 30), 250);
        Arrangement fodbold = opretArrangement("Fodbold", LocalDate.of(2017, 8, 30),
                LocalTime.of(14, 00), LocalTime.of(17, 30), 100);
        Arrangement brætspil = opretArrangement("Brætspil", LocalDate.of(2017, 8, 29),
                LocalTime.of(12, 00), LocalTime.of(16, 30), 25);
        Arrangement mindeparken = opretArrangement("Mindeparken", LocalDate.of(2017, 8, 30),
                LocalTime.of(18, 00), LocalTime.of(22, 00), 25);

        // links, tutor til hold
        linkTutorTilHold(andersHansen, es);
        linkTutorTilHold(loneAndersen, es);
        linkTutorTilHold(peterJensen, eu);
        linkTutorTilHold(nielsMadsen, eu);
        linkTutorTilHold(madsMiller, eb);

        // links, tutor til arrangement
        linkTutorTilArrangement(andersHansen, rusfest);
        linkTutorTilArrangement(peterJensen, rusfest);
        linkTutorTilArrangement(madsMiller, rusfest);
        linkTutorTilArrangement(nielsMadsen, fodbold);
        linkTutorTilArrangement(loneAndersen, brætspil);
        linkTutorTilArrangement(nielsMadsen, brætspil);
        linkTutorTilArrangement(madsMiller, mindeparken);
        linkTutorTilArrangement(andersHansen, mindeparken);
    }

    // section S7
    /**
     * Linker tutor til hold. Hvis tutor allerede er en del af et hold
     * fjernes tutoren fra dette hold.
     *
     * @param tutor Tutor, som skal linkes.
     * @param hold Hold, som skal linkes til.
     */
    public static void linkTutorTilHold(Tutor tutor, Hold hold) {
        if (tutor.getHold() == null) {
            tutor.setHold(hold);
        } else {
            Hold oldHold = tutor.getHold();
            oldHold.removeTutor(tutor);
            tutor.setHold(hold);
        }
    }

    /**
     * Linker tutor til arrangement.
     *
     * @param tutor Tutor, som skal linkes.
     * @param arrangement Arrangement, som skal linkes til.
     */
    public static void linkTutorTilArrangement(Tutor tutor, Arrangement arrangement) {
        if (!tutor.getHold().harTidsoverlap(arrangement))
            tutor.addArrangement(arrangement);
        else throw new RuntimeException("Arrangement overlapper med et andet arrangement!");
    }

    // section S8

    /**
     * Returnerer en ArrayList'e med alle hold uden
     * nogle tutorer tilknyttet.
     *
     * @return
     */
    public static ArrayList<Hold> holdUdenTutorer() {
        ArrayList<Hold> holdUdenTutorer = new ArrayList<>();

        for (Uddannelse uddannelse : Storage.getUddannelser()) {
            for (Hold hold : uddannelse.getHold()) {
                if (hold.getTutore().isEmpty()) {
                    holdUdenTutorer.add(hold);
                }
            }
        }

        return holdUdenTutorer;
    }

    // section S10
    /**
     * Skriver en tutor oversigt over alle tutorer der er en del af et
     * hold ud til en fil.
     *
     * @param filnavn
     */
    public static void tutorOversigtTilFil(String filnavn) {
        File out = new File("Semesteropgaver/Semesterproeve januar 2018/src/model/" + filnavn + ".txt");

        try (PrintWriter writer = new PrintWriter(out)) {
            for (Uddannelse uddannelse: Storage.getUddannelser()) {
                for (String str : uddannelse.tutorOversigt()) {
                    writer.println(str);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
