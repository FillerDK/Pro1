package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    // section S1
    private static int antalAnnoncer = 0;
    private final int annonceNummer;
    private boolean aktiv = true;
    private final LocalDate udløbsdato;

    /**
     * Association 0..1 --- 0..* Vare
     */
    private final ArrayList<Vare> varer;

    /**
     * Forced association 0..* --- 1 Sælger
     */
    private final Sælger sælger;

    public Salgsannonce(Sælger sælger, ArrayList<Vare> varer) {
        antalAnnoncer++;
        this.annonceNummer = antalAnnoncer;
        udløbsdato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
        this.varer = varer;
    }

    // section getters
    public Sælger getSælger() {
        return sælger;
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    // section adders
    public void addVare(Vare vare) {
        varer.add(vare);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", annonceNummer, sælger.getNavn(), udløbsdato);
    }

    // section S2
    /**
     * Returnerer det samlede beløb, for alle de varer der indgår
     * i annoncen, hvis de sælges til udbudsprisen.
     *
     * @return
     */
    public int samletAnnonceUdbud() {
        int samletPris = 0;

        for (Vare vare : varer) {
            samletPris += vare.getUdbudspris();
        }

        return samletPris;
    }

    // section S7
    /**
     * Opdaterer om salgsannoncen skal være aktiv eller ikke.
     * Bliver kørt hver gang et salg bliver gennemført.
     */
    public void opdaterAnnonce() {
        boolean alleVarerSolgt = true;

        for (int i = 0; alleVarerSolgt && i < varer.size(); i++) {
            if (!varer.get(i).isSolgt()) {
                alleVarerSolgt = false;
            }
        }

        if (udløbsdato.isBefore(LocalDate.now()) || alleVarerSolgt) {
            aktiv = false;
        }
    }
}
