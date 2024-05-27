package exercises.opg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opg2 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();

        File file = new File("L33 Files and Exceptions/src/exercises/opg1/fil1.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                int line = Integer.parseInt(scanner.nextLine());
                integers.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke fundet!");
            System.err.println(e);
        }

        for (int i = integers.size() - 1; i >= 0; i--) {
            System.out.println(integers.get(i));
        }
    }
}
