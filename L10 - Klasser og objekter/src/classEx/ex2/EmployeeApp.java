package classEx.ex2;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans Jensen", 40, true);
        System.out.println("Test: " + e1);
        System.out.println();

        e1.printEmployee();
        e1.birthday();
        e1.printEmployee();
    }
}
