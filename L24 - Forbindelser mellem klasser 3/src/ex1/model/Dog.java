package ex1.model;

public class Dog {
    private int number;
    private String name;

    private Person person; // nullable

    public Dog(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, number: %d", name, number);
    }

    // ---------------------------------------------

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void removePerson() {
        this.person = null;
    }
}
