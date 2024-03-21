package ex1.model;

import java.util.ArrayList;

public class Team {
    private String name;
    private String room;
    private ArrayList<Student> students = new ArrayList<>();

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student[] activeStudents() {
        int noOfActiveStudents = 0;
        for (Student student : students) {
            if (student.isActive()) {
                noOfActiveStudents++;
            }
        }
        Student[] activeStudents = new Student[noOfActiveStudents];
        for (int j = 0, i = 0; j < students.size(); j++) {
            if (students.get(j).isActive()) {
                activeStudents[i] = students.get(j);
                i++;
            }
        }
        return activeStudents;
    }

    public void removeStudent(String name) {
        int i = 0;
        while (i < students.size()) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                students.remove(i);
            }
            i++;
        }
    }

    public String toString() {
        return String.format("Team(navn: %s, lokale: %s)", name, room);
    }
}
