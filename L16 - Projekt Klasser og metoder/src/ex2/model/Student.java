package ex2.model;

import java.util.Arrays;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;
    private char[] answers = new char[10];

    public Student(String name) {
        this.name = name;
        active = true;
        answers = MultipleChoiceTest.getRandomAnswers();
        grades = new int[]{getGrade()};
    }

    private int getGrade() {
        if (correctAnswersCount() == 10)
            return 12;
        else if (correctAnswersCount() >= 8) {
            return 10;
        } else if (correctAnswersCount() >= 6) {
            return 7;
        } else if (correctAnswersCount() >= 4) {
            return 4;
        } else if (correctAnswersCount() >= 2) {
            return 02;
        } else if (correctAnswersCount() == 1) {
            return 00;
        } else return -3;
    }

    public char[] getAnswers() {
        return answers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean isActive) {
        active = isActive;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', active=" + active + ", grades=" + Arrays.toString(grades) + '}';
    }

    public int highestGrade() {
        int highestGrade = -3;
        for (int grade : grades) {
            if (grade > highestGrade)
                highestGrade = grade;
        } return highestGrade;
    }

    public double averageGrade() {
        double totalGrades = 0;
        double noOfGrades = grades.length;
        for (int grade : grades) {
            totalGrades += grade;
        }
        double average = totalGrades / noOfGrades;
        return average;
    }

    public int correctAnswersCount() {
        int correctAnswers = 0;
        for (int i = 0; i < MultipleChoiceTest.getCorrectAnswers().length; i++) {
            if (answers[i] == MultipleChoiceTest.getCorrectAnswers()[i]) {
                correctAnswers++;
            }
        } return correctAnswers;
    }
}
