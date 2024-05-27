package ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Ex4 {
    public static void main(String[] args) {
        mergeFiles("filename1", "filename2", "filename3");
    }

    /**
     * Merge the integers in the two text files with the names fileName1 and fileName 2
     * into the text file with name fileName3.
     * Pre: The integers in the two text files are sorted in non-descending order.
     * Pre: The last number in both text files is 2147483647 (=Integer.MAX_VALUE).
     */
    public static void mergeFiles(String filename1, String filename2, String filename3) {
        File file1 = new File("L34 - Fletning/src/ex4/" + filename1 + ".txt");
        try (Scanner scanner = new Scanner(file1)) {
            int sum = 0;
            while (scanner.hasNextInt()) {;
                int line = scanner.nextInt();
                try {
                    sum += line;
                } catch (NumberFormatException ex) {
                    System.out.println("Not a double.");
                }
            }
            System.out.println("Sum is " + sum);
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry! An unexpected error has occurred.");
            System.out.println("Technical message: " + ex.getMessage());
        }
    }

    public static void createFile() {
        int antal = 0;
        String filename = "L34 - Fletning/src/ex4/";
        try (Scanner scanner = new Scanner(System.in)) {
            while (antal <= 0) {
                try {
                    System.out.println("Filename:");
                    filename += scanner.next() + ".txt";
                    System.out.print("Antal tal der skal skrives i filen: ");
                    antal = scanner.nextInt();
                }
                catch (InputMismatchException ex) {
                    System.out.println("Antal skal være et positivt heltal.");

                }
            }
        }

        try (PrintWriter printWriter = new PrintWriter(filename)) {
            ArrayList<Integer> ints = new ArrayList<>();

            Random rnd = new Random();
            int oldNum = -1;
            for (int i = 1; i < antal; i++) {
                int number = rnd.nextInt(2147483646);
                ints.add(number);
            }
            ints.add(2147483547);

            Collections.sort(ints);
            removeDuplicates(ints);

            for (Integer i : ints) {
                printWriter.println(i);
            }

            System.out.println("Fil med " + antal + " tal nu er lavet.");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error finding or creating file: " + filename);
        }
    }

    /**
     * Fjerner dubletter fra en ArrayList af typen Integer.
     *
     * @param list ArrayList af typen Integer, som skal have fjernet dubletter.
     */
    public static void removeDuplicates(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int last = list.get(i-1);
            if (last == i) {
                list.remove(i);
            }
        }
    }
}
