package classEx;

import java.util.Scanner;

public class ChildApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Age1 + gender1
        System.out.print("Write an age: ");
        int age1 = scan.nextInt();

        System.out.println("Is your child a boy? Y/N");
        String answer = scan.next();
        boolean isBoy;

        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            isBoy = true;
        } else {
            isBoy = false;
        }

        System.out.println(institution(age1));
        System.out.println(team(isBoy, age1));
        System.out.println();

        // Age2 + gender2
        System.out.print("Write an age: ");
        age1 = scan.nextInt();

        System.out.println("Is your child a boy? Y/N");
        answer = scan.next();

        if (answer.equals("y") || answer.equals("yes")) {
            isBoy = true;
        } else {
            isBoy = false;
        }

        System.out.println(institution(age1));
        System.out.println(team(isBoy, age1));

    }

    public static String institution (int age) {
        String institution;
        if (age == 0) {
            institution = "Home";
        } else if (age <= 2) {
            institution = "Nursery";
        } else if (age <= 5) {
            institution = "Kindergarten";
        } else if (age <= 16) {
            institution = "School";
        } else {
            institution = "Out of school";
        }
        return institution;
    }

    public static String team (boolean isBoy, int age) {
        String string;

        if (isBoy == true) {
            if (age < 8) {
                string = "Young cubs";
            } else {
                string = "Cool boys";
            }
        } else {
            if (age < 8) {
                string = "Tumbling girls";
            } else {
                string = "Springy girls";
            }
        }
        return string;
    }
}
