package classEx.ex2;

public class Employee {
    // The name of the employee.
    String name;
    // The age of the employee.
    int age;
    // Whether the employee is a trainee or not.
    boolean trainee;

    /** Create an employee. */
    public Employee(String name, int age, boolean trainee) {
        this.name = name;
        this.age = age;
        this.trainee = true;
    }

    public int birthday() {
        return this.age++;
    }

    @Override
    public String toString() {
        return String.format("Employee(%s, %s, %s)", name, age, trainee);
    }

    /** Print a description of the employee. */
    public void printEmployee() {
        int i = name.lastIndexOf(" ");
        System.out.println("*******************");
        System.out.println("First name: " + name.substring(0, i));
        System.out.println("Last name: " + name.substring(i));
        System.out.println("Age: " + age);
        System.out.println("Trainee: " + trainee);
        System.out.println("*******************");
    }
}
