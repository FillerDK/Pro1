package ex1.controller;

import ex1.model.Dog;
import ex1.model.Person;

public abstract class Controller {
    public static void addDogToPerson(Dog dog, Person person) {
        if (dog.getPerson() != null) {
            dog.getPerson().removeDog(dog);
        }
        dog.setPerson(person);
        person.addDog(dog);
    }
}
