package ex3;

import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";

        // a) Udskriv ord1 med store bogstaver.
        System.out.println("a) " + ord1.toUpperCase());

        // b) Udskriv ord2 med små bogstaver.
        System.out.println("b) " + ord2.toLowerCase());

        // c) Sammensæt ord1 og ord2 med et mellemrum imellem og udskriver resultatet.
        System.out.println("c) " + ord1 + " " + ord2);

        // d) Lav en ny variabel ord3, som er en sammensætning af ord1 og ord2,
        // hvor ord2 er med små bogstaver. Udskriv ord3.
        String ord3 = ord1.toLowerCase() + " " + ord2;
        System.out.println("d) " + ord3);

        // e) Udskriv længden af strengen fr aopgave d).
        System.out.println("e) " + ord3.length());

        // f) Udskriv de første 7 bogstaver af ord1.
        System.out.println("f) " + ord1.substring(0, 7));

        // g) Udskriv bogstav 3-7 fra ord2.
        System.out.println("g) " + ord2.substring(2,7));

        // h) Udskriv den sidste halvdel af strengen fra opgave d).
        // (Brug ord3.length() metoden)
        System.out.println("h) " + ord3.substring(ord3.length() / 2));
    }
}
