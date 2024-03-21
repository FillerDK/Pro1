import java.util.Scanner;

public class AppPhilipSI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Indtast personens navn:");
        String name = input.nextLine();

        System.out.println("Indtast personens vægt i kg:");
        int vægtKg = input.nextInt();
        input.nextLine();

        System.out.println("Indtast personens højde i m:");
        double højde = input.nextDouble();
        input.nextLine();

        double bmi = vægtKg / Math.pow(højde, 2);
        String bmiBeskrivelse = "";

        if (bmi < 18.5) {
            bmiBeskrivelse = "undervægtig";
        } else if (bmi >=18.5 && bmi < 25) {
            bmiBeskrivelse = "normal vægt";
        } else if (bmi >= 25 && bmi < 30) {
            bmiBeskrivelse = "overvægt";
        } else {
            bmiBeskrivelse = "fedme";
        }
        System.out.println("Beregnet BMI: " + bmi);
        System.out.printf("%s,  BMI siger: %s", name, bmiBeskrivelse);
    }
}
