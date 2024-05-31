package model;

import storage.Storage;

import java.util.ArrayList;

public class Uddannelse {
    // section S1
    private final String navn;

    /**
     * Association 1 --- 0..* Hold
     */
    private ArrayList<Hold> hold = new ArrayList<>();

    public Uddannelse(String navn) {
        this.navn = navn;
    }

    // section adders
    public void addHold(Hold hold) {
        this.hold.add(hold);
    }

    // section getters
    public ArrayList<Hold> getHold() {
        return hold;
    }

    @Override
    public String toString() {
        return String.format("%s", navn);
    }

    // section S9
    /**
     * Returnerer en ArrayList'e af strings objekter. Hver String i listen indeholder oplysninger
     * om en tutor der er tilknyttet et hold.
     * String objektet består af: navn på tutor, uddannelsens navn, holdets betegnelse, tutorens
     * email, og holdets holdleder, i den angivne rækkefølge.
     *
     * @return
     */
    public ArrayList<String> tutorOversigt() {
        ArrayList<String> tutorOversigt = new ArrayList<>();

        for (Tutor tutor : Storage.getTutorer()) {
            Hold hold = tutor.getHold();
            if (hold != null) {
                String str = String.format("%s %s %s %s %s", tutor.getNavn(), navn, hold.getBetegnelse(),
                        tutor.getEmail(), hold.getHoldleder());
                tutorOversigt.add(str);
            }
        }

        return tutorOversigt;
    }

}
