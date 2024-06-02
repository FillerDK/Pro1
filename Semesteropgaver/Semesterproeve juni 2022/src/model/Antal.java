package model;

public class Antal {
    private final int antal;

    /**
     * Forced association 0..* --> 1 Funktion
     */
    private final Funktion funktion;

    public Antal(int antal, Funktion funktion) {
        this.antal = antal;
        this.funktion = funktion;
    }

    // getters
    public int getAntal() {
        return antal;
    }

    public Funktion getFunktion() {
        return funktion;
    }
}
