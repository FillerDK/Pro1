package model;

import java.util.ArrayList;

public class Sælger {
    // section S1
    private final String navn;
    private final int studiekortNummer;
    private final String mobil;

    /**
     * Association 1 --- 0..* Salgsannonce
     */
    private final ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
    }

    // section getters
    public ArrayList<Salgsannonce> getSalgsannoncer() {
        return salgsannoncer;
    }

    public String getNavn() {
        return navn;
    }

    // section adders
    public void addSalgsannonce(Salgsannonce salgsannonce) {
        salgsannoncer.add(salgsannonce);
    }

    // section S3
    /**
     * Returnerer en liste med alle ikke solgte varer
     * sælgeren har til salg i den angivne kategori.
     *
     * @param varekategori Varekategori, der skal sammenlignes med.
     * @return
     */
    public ArrayList<Vare> alleIkkesolgteVarerIKategori(Varekategori varekategori) {
        ArrayList<Vare> ikkeSolgteVare = new ArrayList<>();

        for (Salgsannonce salgsannonce : salgsannoncer) {
            for (Vare vare : salgsannonce.getVarer()) {
                if (vare.getKategori().equals(varekategori)) {
                    if (!vare.isSolgt()) {
                        ikkeSolgteVare.add(vare);
                    }
                }
            }
        }

        return ikkeSolgteVare;
    }
}
