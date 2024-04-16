package ex1.model;

import java.util.ArrayList;

public class Person {
    private String name;
    private final String cpr;
    private String phone;

    private final ArrayList<Dog> dogs = new ArrayList<>();

    public Person(String name, String cpr, String phone) {
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    public String getCpr(){
        return cpr;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, cpr: %s, phone: %s", name, cpr, phone);
    }

    // ------------------------------------------

    public ArrayList<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void removeDog(Dog dog) {
        dogs.remove(dog);
    }
}
