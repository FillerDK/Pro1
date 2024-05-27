package exercises.opg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opg1 {
    public static void main(String[] args) {
        File file = new File("L33 Files and Exceptions/src/exercises/opg1/fil1.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int line = scanner.nextInt() * 2;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke fundet!");
            System.err.println(e);
        }
    }
}
