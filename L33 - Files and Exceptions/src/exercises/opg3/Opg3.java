package exercises.opg3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opg3 {
    public static void main(String[] args) {
        File file = new File("L33 Files and Exceptions/src/exercises/opg3/fil3.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 1)
                    writer.println(i);
            }
        } catch (FileNotFoundException e){
            System.out.println("Fil ikke fundet!");
            System.err.println(e);
        }
    }
}
