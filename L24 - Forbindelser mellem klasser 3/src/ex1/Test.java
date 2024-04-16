package ex1;

import ex1.controller.Controller;
import ex1.model.Dog;
import ex1.model.Person;

public class Test {
    public static void main(String[] args) {
        Person jan = new Person("Jan", "0101010202", "80808080");
        Person pia = new Person("Pia", "0202020303", "70707070");

        Dog dog1 = new Dog(0001, "Søren");
        Dog dog2 = new Dog(0002, "Mary");

        Controller.addDogToPerson(dog1, jan);
        Controller.addDogToPerson(dog2, pia);

        System.out.println("Jan's hunde" + jan.getDogs());
        System.out.println("Pia's hunde" + pia.getDogs());
        System.out.println("Hund 1's ejer" + dog1.getPerson());
        System.out.println("Hund 2's ejer" + dog2.getPerson());

        Controller.addDogToPerson(dog2, jan);

        System.out.println();
        System.out.println("Jan's hunde" + jan.getDogs());
        System.out.println("Pia's hunde" + pia.getDogs());
        System.out.println("Hund 1's ejer" + dog1.getPerson());
        System.out.println("Hund 2's ejer" + dog2.getPerson());
    }
}
