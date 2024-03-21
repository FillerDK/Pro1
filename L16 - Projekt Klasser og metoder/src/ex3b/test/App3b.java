package ex3b.test;

import ex3b.model.Student;
import ex3b.model.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App3b {
    public static void main(String[] args) {
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        boolean finished = false;
        while (!finished) {
            System.out.println("Menu");
            System.out.println("1: Create a team");
            System.out.println("2: Create a student");
            System.out.println("3: Show one student's info and results");
            System.out.println("4: Show one team's info and results (for active students)");
            System.out.println("5: Show info and results for all teams (for active students)");
            System.out.println("6: Exit program");
            Scanner input = new Scanner(System.in);
           int num = input.nextInt();
           input.nextLine();
           if (num >= 1 && num <= 6) {
               if (num == 1) {
                   boolean errorMade = true;
                   while (errorMade) {
                       System.out.print("Enter team name: ");
                       String teamName = input.nextLine();
                       for (int i = 0; i < teams.size(); i++) {
                           if (teams.get(i).getName().equalsIgnoreCase(teamName)) {
                               System.out.print("Team name already exists, enter another name: ");
                               teamName = input.nextLine();
                           }
                       }
                       System.out.print("Enter team room: ");
                       String teamRoom = input.nextLine();

                       // after entering team name and room, if statement checks if both have been entered,
                       // if not you're sent back and asked to type it again

                       if (teamName.equalsIgnoreCase("") || teamRoom.equalsIgnoreCase("")) {
                           System.out.println("Error, missing information, either team name or room haven't been input!\n");
                       } else {
                           errorMade = false; // to end the loop
                           Team team = new Team(teamName, teamRoom); // creating a team
                           teams.add(team); // adding created team to teams list
                           System.out.printf("--> Team created with name and room set to %s and %s\n\n", team.getName(), team.getRoom());
                       }
                   }
               } else if (num == 2) {
                   if (teams.size() >= 1) {
                       System.out.print("Name of student's team: ");
                       String teamName = input.nextLine();
                       int count = 0;

                       // checking if the team name entered exists
                       // if not, you're sent back to the menu

                       for (int i = 0; i < teams.size(); i++) {
                           if (teamName.equalsIgnoreCase(teams.get(i).getName()))
                               count = i + 1;
                       }

                       if (count > 0) {
                           System.out.print("Student's name: ");
                           String name = input.nextLine();
                           System.out.print("Set student activity status (true/false): ");
                           String isActive = input.nextLine();
                           boolean active = false;
                           if (isActive.equalsIgnoreCase("true")) active = true;
                           else if (isActive.equalsIgnoreCase("false")) active = false;

                           while (!isActive.equalsIgnoreCase("true") && !isActive.equalsIgnoreCase("false")) {
                               System.out.print("Not a valid activity status! Use \"true\" or \"false\": ");
                               isActive = input.nextLine();
                               if (isActive.equalsIgnoreCase("true")) active = true;
                               else if (isActive.equalsIgnoreCase("false")) active = false;
                           }
                           Student student = new Student(name, active); // creating student
                           students.add(student); // adding student to students list
                           teams.get(count - 1).addStudent(student); // adding student to teams list
                           System.out.print("Student's number of grades: ");
                           int grades = input.nextInt();
                           input.nextLine(); // check for int input
                           while (grades < 1) {
                               System.out.print("Amount too low, number of grades has to be atleast 1, type a new amount: ");
                               grades = input.nextInt();
                               input.nextLine();
                           }
                           student.setGradeAmount(grades);
                           System.out.printf("Student's %d grades: ", student.getGradeAmount());
                           for (int i = 0; i < student.getGradeAmount(); i++) {
                               /*while (!input.hasNextInt()) {
                                   System.out.print("Not an integer, enter an integer: ");
                                   input.nextInt();
                               }*/
                               // fix this with a try catch
                               student.setGrades(input.nextInt(), i);
                           }
                           System.out.printf("--> Student %s(%s) with grades %s created in team %s\n\n", student.getName(), student.activeOr(), Arrays.toString(student.getGrades()), teamName);
                       } else {
                           System.out.println("Error, team not existing, create a team to add a student to it!\n");
                       }
                   } else {
                       System.out.println("No teams created, create a team to view this window.\n");
                   }
               } else if (num == 3) {
                   if (students.size() >= 1) {
                       System.out.print("Enter name for the student you want to recieve info and results about: ");
                       String studentNameCheck = input.nextLine();
                       int count = 0;
                       for (int i = 0; i < students.size(); i++) {
                           if (studentNameCheck.equalsIgnoreCase(students.get(i).getName()))
                               count = i + 1;
                       }
                       if (count > 0) {
                           System.out.println(students.get(count - 1).toString() + "\n");
                       } else {
                           System.out.println("Error, name not found! Check if the name was correctly spelled or add a new student.\n");
                       }
                   } else {
                       System.out.println("No students created, create a student to view this window.\n");
                   }
               } else if (num == 4) {
                   if (teams.size() >= 1) {
                       System.out.print("Enter name for the team you want to recieve info and results about: ");
                       String teamNameCheck = input.nextLine();
                       int count = 0;
                       for (int i = 0; i < teams.size(); i++) {
                           if (teamNameCheck.equalsIgnoreCase(teams.get(i).getName()))
                               count = i + 1;
                       }
                       if (count > 0) {
                           System.out.println(teams.get(count - 1).toString());
                           for (int i = 0; i < teams.get(count - 1).getInfoPerStudent().length; i++) {
                               System.out.print(teams.get(count - 1).getInfoPerStudent()[i]);
                           }
                           System.out.println();
                       } else {
                           System.out.println("Error, name not found! Check if the name was correctly spelled or add a new team.\n");
                       }
                   } else {
                       System.out.println("No teams created, create a team to view this window.\n");
                   }
               } else if (num == 5) {
                   if (teams.size() >= 1) {
                       for (int i = 0; i < teams.size(); i++) {
                           System.out.println(teams.get(i).toString());
                           for (int j = 0; j < teams.get(i).getStudentsAmount(); j++) {
                               System.out.print(teams.get(i).getInfoPerStudent()[j]);
                           }
                           System.out.println();
                       }
                   } else {
                       System.out.println("No teams created, create a team to view this window.\n");
                   }
               } else if (num == 6) {
                   System.out.println("Exiting program...");
                   finished = true;
               }
           } else {
               System.out.println("Not a valid number, the number has to be between 1-6.\n");
           }
        }
    }
}