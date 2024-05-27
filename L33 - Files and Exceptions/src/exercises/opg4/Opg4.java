package exercises.opg4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opg4 {
    public static void main(String[] args) {
        File file = new File("L33 Files and Exceptions/src/exercises/opg4/fil4.txt");
        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(file)) {
            boolean finished = false;
            while (!finished) {
                System.out.print("Enter an integer (-1 ends program): ");
                int num = scanner.nextInt();
                if (num == -1) {
                    finished = true;
                    System.out.println("Program terminating...");
                } else if (num < -1) {
                    System.out.println("Integer must be positive!");
                } else {
                    scanner.nextLine();
                    writer.println(num);
                    System.out.printf("Integer written to file: %d\n\n", num);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke fundet!");
            System.err.println(e);
        }
    }
}
