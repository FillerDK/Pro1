package ex3b.model;

import ex2.model.MultipleChoiceTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    private String name;
    private String room;
    private ArrayList<Student> students = new ArrayList<>();

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public int getStudentsAmount() {
        return students.size();
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
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

    public double averageGrades() {
        int totalGrade = 0;
        int noOfGrades = 0;
        for (Student student : students) {
            for (int grade : student.getGrades()) {
                totalGrade += grade;
                noOfGrades++;
            }
        } return totalGrade / noOfGrades;
    }

    public Student[] highScoreStudents(double minAverage) {
        int noOfStudents = 0;
        for (Student student : students) {
            if (student.averageGrade() >= minAverage) {
                noOfStudents++;
            }
        }
        Student[] studentsAboveScore = new Student[noOfStudents];
        for (int j = 0, i = 0; j < students.size(); j++) {
            if (students.get(j).isActive()) {
                studentsAboveScore[i] = students.get(j);
                i++;
            }
        }
        return studentsAboveScore;
    }

    public int[] correctAnswersPerStudents() {
        int[] noOfCorrectAnswers = new int[activeStudents().length];
        for (int i = 0, j = 0; i < activeStudents().length; i++) {
            if (students.get(i).isActive()) {
                noOfCorrectAnswers[j] = students.get(i).correctAnswersCount();
                j++;
            }
        }
        return noOfCorrectAnswers;
    }

    public String[] getInfoPerStudent() {
        String[] studentInfo = new String[activeStudents().length];

        for (int i = 0, j = 0; i < students.size(); i++) {
            if (students.get(i).isActive()) {
                studentInfo[j] = String.format("""
                                |  Name: %-15s |  Grade Avg: %.2f  |  Correct Answers: %4d  | %s's anwers: %s |                                
                                """, students.get(i).getName(), students.get(i).averageGrade(),
                        students.get(i).correctAnswersCount(), students.get(i).getName(),
                        Arrays.toString(students.get(i).getAnswers()));
                j++;
            }
        } return studentInfo;
    }

    public int[] numberOfCorrectAnswers() {
        char[] correctAnswers = MultipleChoiceTest.getCorrectAnswers();
        int[] correctAnswersAmount = new int[10];
        for (Student student : students) {
            for (int i = 0; i < student.getAnswers().length; i++) {
                if (student.getAnswers()[i] == correctAnswers[i] && student.isActive()) {
                    correctAnswersAmount[i]++;
                }
            }
        }
        return correctAnswersAmount;
    }

    public String toString() {
        return String.format("Team(name: %s, room: %s)", name, room);
    }
}
