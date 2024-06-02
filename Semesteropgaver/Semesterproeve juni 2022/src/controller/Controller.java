package controller;

import model.Antal;
import model.Funktion;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {
    // section S9
    public static Antal createAntal(int antal, Funktion funktion, Vagt vagt) {
        Antal a = new Antal(antal, funktion);
        vagt.addAntal(a);
        return a;
    }
    
    public static Funktion createFunktion(String navn) {
        Funktion funktion = new Funktion(navn);
        Storage.storeFunktion(funktion);
        return funktion;
    }
    
    public static Medarbejder createMedarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødeTid) {
        Medarbejder medarbejder = new Medarbejder(navn, antalTimerPrDag, typiskMødeTid);
        Storage.storeMedarbejder(medarbejder);
        return medarbejder;
    }

    public static Vagt createVagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        Vagt vagt = new Vagt(navn, tidFra, tidTil);
        Storage.storeVagt(vagt);
        return vagt;
    }

    public static void registrerFunktion(Medarbejder medarbejder, Funktion funktion) {
        medarbejder.addFunktion(funktion);
    }

    public static void initStorage() {
        // funktioner
        Funktion filetering = createFunktion("Filetering");
        Funktion grøntsager = createFunktion("Grøntsager");
        Funktion sovsOgTilbehør = createFunktion("Sovs og tilbehør");
        Funktion buffetopfyldning = createFunktion("Buffetopfyldning");

        // medarbejdere
        Medarbejder peter = createMedarbejder("Peter", 6, LocalTime.of(8, 00));
        Medarbejder anne = createMedarbejder("Anne", 8, LocalTime.of(8, 00));
        Medarbejder marie = createMedarbejder("Marie", 6, LocalTime.of(10, 00));
        Medarbejder torben = createMedarbejder("Torben", 8, LocalTime.of(7, 00));

        // vagter
        Vagt røgedeÅl = createVagt("Røgede ål til medarbejderne",
                LocalDateTime.of(2022, 6, 24, 8, 00),
                LocalDateTime.of(2022, 6, 24, 12, 30));

        Antal filetertingAntal = createAntal(2, filetering, røgedeÅl);
        Antal grøntsagerAntal = createAntal(1, grøntsager, røgedeÅl);
        Antal sovsOgTilbehørAntal = createAntal(1, sovsOgTilbehør, røgedeÅl);
        Antal buffetopfyldningAntal = createAntal(1, buffetopfyldning, røgedeÅl);

        registrerFunktion(peter, grøntsager);
        registrerFunktion(peter, sovsOgTilbehør);
        registrerFunktion(peter, buffetopfyldning);
        peter.addVagt(røgedeÅl);

        registrerFunktion(anne, grøntsager);
        registrerFunktion(anne, sovsOgTilbehør);
        registrerFunktion(anne, buffetopfyldning);
        anne.addVagt(røgedeÅl);

        registrerFunktion(marie, filetering);
        registrerFunktion(marie, grøntsager);
        registrerFunktion(marie, buffetopfyldning);
        marie.addVagt(røgedeÅl);

        registrerFunktion(torben, filetering);
        registrerFunktion(torben, sovsOgTilbehør);
    }

    // section S10
    /**
     * Udskriver en given vagt til en txt fil.
     *
     * @param vagt Vagt, som udskrives.
     * @param filnavn Filnavn på fil man ønsker at udskrive til.
     */
    public static void udskrivVagtplan(Vagt vagt, String filnavn) {
        String fnavn = "Semesteropgaver/Semesterproeve juni 2022/src/model/" + filnavn + ".txt";
        File out = new File(fnavn);

        try (PrintWriter writer = new PrintWriter(out)) {
            writer.println("--------------------------------------");
            writer.println(vagt.getTidFra());
            writer.println("--------------------------------------\n");
            writer.println("Funktioner:");
            for (Antal antal : vagt.getAntal()) {
                int medarbejdere = 0;
                for (Medarbejder medarbejder : vagt.getMedarbejdere()) {
                    ArrayList<Funktion> funktioner = medarbejder.getFunktioner();
                    boolean fundet = false;
                    for (int i = 0; !fundet && i < funktioner.size(); i++) {
                        if (funktioner.get(i) == antal.getFunktion()) {
                            medarbejdere++;
                        }
                    }
                }
                Funktion funktion = antal.getFunktion();
                String str = String.format("  %s(%d, %d medarbejdere)", funktion.getNavn(), antal.getAntal(), medarbejdere);
                writer.println(str);
            }
            writer.println("\nMedarbejdere:");
            writer.printf("\nStatus: %s", vagt.status());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
