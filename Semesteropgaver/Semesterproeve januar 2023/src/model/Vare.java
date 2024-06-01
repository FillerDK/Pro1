package model;

public class Vare {
    // section S1
    private final Varekategori kategori;
    private final String navn;
    private final int udbudspris;
    private boolean solgt = false;

    /**
     * Association 0..* --- 0..1 Salgsannonce
     */
    private Salgsannonce salgsannonce;

    public Vare(Varekategori kategori, String navn, int udbudspris) {
        this.kategori = kategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
    }

    // section getters
    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    // section setters
    public void setSalgsannonce(Salgsannonce salgsannonce) {
        this.salgsannonce = salgsannonce;
    }

    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }

    @Override
    public String toString() {
        String str = "";
        if (solgt) str = "solgt";
        else str = "til salg";
        return String.format("%-15s%4d %s", navn, udbudspris, str);
    }
}
