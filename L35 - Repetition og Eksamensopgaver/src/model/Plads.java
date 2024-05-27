package model;

public class Plads {
    // section S1
    private final int række;
    private final int nr;
    private final int pris;

    public Plads(int række, int nr, int pris) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
    }

    /**
     * Returnerer pris for plads.
     *
     * @return
     */
    public int getPris() {
        return pris;
    }

    /**
     * Returnerer pladsens række.
     *
     * @return
     */
    public int getRække() {
        return række;
    }

    /**
     * Returnerer pladsens nummer.
     *
     * @return
     */
    public int getNr() {
        return nr;
    }
}
