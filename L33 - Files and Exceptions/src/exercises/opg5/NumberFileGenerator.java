package exercises.opg5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberFileGenerator {

	public static void main(String[] args) {
		int antal = 0;
		String filename = "L33 Files and Exceptions/src/exercises/opg5/";
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
			Random rnd = new Random();
			for (int i = 1; i <= antal; i++) {
				int number = rnd.nextInt(10000);
				printWriter.println(number);
			}
			System.out.println("Fil med " + antal + " tal nu er lavet.");
		}
		catch (FileNotFoundException ex) {
			System.out.println("Error finding or creating file: " + filename);
		}

		System.out.println(max(filename));
	}

	public static int max(String filename) {
		int max = 0;

		File file = new File(filename);
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				int line = Integer.parseInt(scanner.nextLine());
				if (line > max) {
					max = line;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fil ikke fundet!");
			System.err.println(e);
		}

		return max;
	}

	public static int min(String filename) {
		int min = 10000;

		File file = new File(filename);
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				int line = Integer.parseInt(scanner.nextLine());
				if (line < min) {
					min = line;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fil ikke fundet!");
			System.err.println(e);
		}

		return min;
	}

	public static double average(String filename) throws IOException {
		int average = 0;

		File file = new File(filename);


		return average;
	}
}
