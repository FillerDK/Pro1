package ex1.model;

import java.util.Arrays;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;

    public Student(String name) {
        this.name = name;
        active = true;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", active=" + active +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }
}
