package classEx.ex3;

public class PersonApp {
    public static void main(String[] args) {
        Person person1 = new Person("Jørgen Sørensen", "Vej 3, 8800 Landsby");
        person1.setMonthlySalary(35000);
        person1.printPerson();
    }
}
