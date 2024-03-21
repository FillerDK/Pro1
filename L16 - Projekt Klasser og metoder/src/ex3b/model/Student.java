package ex3b.model;

import java.util.Arrays;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;
    private char[] answers = new char[10];

    public Student(String name, boolean active) {
        this.name = name;
        this.active = active;
        answers = MultipleChoiceTest.getRandomAnswers();
    }

    public void setGradeAmount(int amount) {
        grades = new int[amount];
    }

    public int getGradeAmount() {
        return grades.length;
    }

    public void setGrades(int grade, int i) {
        grades[i] = grade;
    }

    private int[] getGrade() {
        return grades;
    }

    public char[] getAnswers() {
        return answers;
    }

    public boolean isActive() {
        return active;
    }

    public String activeOr() {
        String isActive = active? "actice" : "inactive";
        return isActive;
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
        return String.format("Student %s (%s), grades: %s, answers: %s", name, activeOr(), Arrays.toString(grades), Arrays.toString(answers));
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
