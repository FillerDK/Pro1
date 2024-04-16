package ex3.model;

import java.util.ArrayList;

public class Person {
    private final String name;
    private int age;

    private final ArrayList<Gift> givedGifts = new ArrayList<>();
    private final ArrayList<Gift> receivedGifts = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return String.format("Name: %s, age: %d", name, age);
    }

    // --------------------------------------------------

    public ArrayList<Gift> getReceivedGifts() {
        return new ArrayList<>(receivedGifts);
    }

    public void addGift(Gift gift) {
        receivedGifts.add(gift);
    }

    public void removeGift(Gift gift) {
        receivedGifts.remove(gift);
    }

    // --------------------------------------------------

    public int totalValueOfGifts() {
        int totalValue = 0;
        if (receivedGifts != null) {
            for (Gift gift : receivedGifts) {
                totalValue += gift.getPrice();
            }
        }
        return totalValue;
    }

    public ArrayList<Person> getGiftGivers() {
        ArrayList<Person> giftGivers = new ArrayList<>();
        for (Gift giver : receivedGifts) {
            giftGivers.add(giver.getGives());
        }
        return giftGivers;
    }
}
