package controller;

import model.*;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    public static ArrayList<Salgsannonce> getSalgsannoncer() {
        ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();

        for (Sælger sælger : Storage.getSælgere()) {
            for (Salgsannonce salgsannonce : sælger.getSalgsannoncer())
            salgsannoncer.add(salgsannonce);
        }

        return salgsannoncer;
    }

    // section S6
    public static Salg createSalg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        Salg salg = new Salg(købersNavn, aftaltSamletPris, varer);
        Storage.storeSalg(salg);
        return salg;
    }
    
    public static Salgsannonce createSalgsannonce(Sælger sælger, ArrayList<Vare> varer) {
        Salgsannonce salgsannonce = new Salgsannonce(sælger, varer);
        sælger.addSalgsannonce(salgsannonce);
        for (Vare vare : varer) {
            vare.setSalgsannonce(salgsannonce);
        }
        return salgsannonce;
    }
    
    public static Sælger createSælger(String navn, int studiekortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studiekortNummer, mobil);
        Storage.storeSælger(sælger);
        return sælger;
    }

    public static Vare createVare(Varekategori kategori, String navn, int udbudspris) {
        Vare vare = new Vare(kategori, navn, udbudspris);
        Storage.storeVare(vare);
        return vare;
    }

    public static void initStorage() {
        // sælgere
        Sælger viktor = createSælger("Viktor", 23, "45344247");
        Sælger gustav = createSælger("Gustav", 35, "56124522");

        // varer
        Vare samsung = createVare(Varekategori.MOBILTELEFON, "Samsung mobil", 1200);
        Vare iPhone = createVare(Varekategori.MOBILTELEFON, "iPhone", 2000);
        Vare java = createVare(Varekategori.STUDIEBOG, "Java", 400);
        Vare android = createVare(Varekategori.STUDIEBOG, "Android", 300);
        Vare python = createVare(Varekategori.STUDIEBOG, "Python", 200);
        Vare regnjakke = createVare(Varekategori.TØJ, "Regnjakke", 100);
        Vare regnbukser = createVare(Varekategori.TØJ, "Regnbukser", 80);

        // salgsannoncer
        ArrayList<Vare> viktor1Varer = new ArrayList<>();
        viktor1Varer.add(samsung);
        Salgsannonce viktor1 = createSalgsannonce(viktor, viktor1Varer);

        ArrayList<Vare> viktor2Varer = new ArrayList<>();
        viktor2Varer.add(java);
        viktor2Varer.add(android);
        viktor2Varer.add(python);
        Salgsannonce viktor2 = createSalgsannonce(viktor, viktor2Varer);

        ArrayList<Vare> gustav1Varer = new ArrayList<>();
        gustav1Varer.add(iPhone);
        Salgsannonce gustav1 = createSalgsannonce(gustav, gustav1Varer);

        ArrayList<Vare> gustav2Varer = new ArrayList<>();
        gustav2Varer.add(regnjakke);
        gustav2Varer.add(regnbukser);
        Salgsannonce gustav2 = createSalgsannonce(gustav, gustav2Varer);

        // salg
        ArrayList<Vare> stineVarer = new ArrayList<>();
        stineVarer.add(android);
        stineVarer.add(python);
        Salg stine = createSalg("Stine", 450, stineVarer);

        ArrayList<Vare> lauraVarer = new ArrayList<>();
        lauraVarer.add(regnbukser);
        lauraVarer.add(regnjakke);
        Salg laura = createSalg("Laura", 120, lauraVarer);
    }

    // section S8
    /**
     * Udskriver alle salg der har været til en fil.
     *
     * @param filnavn Filnavn på vil man ønsker at udskrive til.
     */
    public static void salgTilFil(String filnavn) {
        String fnavn = "Semesteropgaver/Semesterproeve januar 2023/src/model/" + filnavn + ".txt";
        File out = new File(fnavn);

        try (PrintWriter writer = new PrintWriter(out)) {
            try {
                for (Salg salg : Storage.getSalg()) {
                    writer.println(salg.getKøbersNavn() + ":");
                    int totalPris = 0;
                    for (Vare vare : salg.getVarer()) {
                        writer.printf("\t%-11s%4d\n", vare.getNavn(), vare.getUdbudspris());
                        totalPris += vare.getUdbudspris();
                    }
                    int aftaltPris = salg.getAftaltSamletPris();
                    writer.printf("Aftalt pris: %-6drabat er: %d\n\n", aftaltPris, (totalPris - aftaltPris));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // section S9
    /**
     * Returnerer en liste med sælger objekter,
     * som også har foretaget et køb.
     *
     * @return
     */
    public static ArrayList<Sælger> sælgereDerHarForetagetKøb() {
        ArrayList<Sælger> sælgereMedKøb = new ArrayList<>();

        for (Sælger sælger : Storage.getSælgere()) {
            for (Salg salg : Storage.getSalg()) {
                if (sælger.getNavn().equals(salg.getKøbersNavn())) {
                    sælgereMedKøb.add(sælger);
                }
            }
        }

        return sælgereMedKøb;
    }
}
