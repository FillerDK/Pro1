package classEx.ex3;

public class Person {
    private String name;
    private String address;
    private int monthlySalary;
    private double yearlySalary;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getMonthlySalary(int monthlySalary) {
        return this.monthlySalary = monthlySalary;
    }

    public int setMonthlySalary(int newMonthlySalary) {
        return this.monthlySalary = newMonthlySalary;
    }

    public double calcYearlySalary() {
        return this.yearlySalary = monthlySalary * 12 * 1.025;
    }

    public void printPerson() {
        int i = name.lastIndexOf(" ");
        System.out.println("*******************");
        System.out.println("First name: " + name.substring(0, i));
        System.out.println("Last name: " + name.substring(i));
        System.out.println("Address: " + address);
        System.out.println("Monthly salary: " + monthlySalary);
        System.out.printf("Yearly salary: %.2f \n", calcYearlySalary());
        System.out.println("*******************");
    }

    public String toString() {
        return String.format("A");
    }
}
