package ex1.test;

import ex1.model.Student;
import ex1.model.Team;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Team t1 = new Team("24v", "A1.32");
        Student s1 = new Student("Søren");
        Student s2 = new Student("Sune");
        Student s3 = new Student("Sanne");
        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);
        s2.setActive(false);

        Team t2 = new Team("24y", "A1.28");
        Student s4 = new Student("Bjørn");
        Student s5 = new Student("Bjarne");
        Student s6 = new Student("Bjørk");
        t2.addStudent(s4);
        t2.addStudent(s5);
        t2.addStudent(s6);


        System.out.println(t1.toString());
        System.out.println("Aktive studerende på team1: " + Arrays.toString(t1.activeStudents()));
        System.out.println("Aktive studerende på team2: " + Arrays.toString(t2.activeStudents()) + "\n");

        t1.removeStudent("Søren");

        System.out.println("Efter studerende fjernet.");
        System.out.println(t2.toString());
        System.out.println("Aktive studerende på team1: " + Arrays.toString(t1.activeStudents()) + "\n");
    }
}
