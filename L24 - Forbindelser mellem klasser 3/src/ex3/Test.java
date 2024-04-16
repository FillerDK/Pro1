package ex3;

import ex3.model.Gift;
import ex3.model.Person;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("John", 40);
        Person p2 = new Person("Rasmus", 30);
        Person p3 = new Person("Signe", 45);
        Person p4 = new Person("Karoline", 35);

        Gift g1 = new Gift("A ball that rolls", p1);
        Gift g2 = new Gift("It runs, like a clock", p2);
        Gift g3 = new Gift("It's loud like a drumset", p3);
        Gift g4 = new Gift("Heavy like a weight", p4);
        Gift g5 = new Gift("Light like a feather", p2);

        g1.setPrice(50);
        g2.setPrice(100);
        g3.setPrice(200);
        g4.setPrice(75);
        g5.setPrice(25);

        g1.addReciever(p2);
        p2.addGift(g1);
        g2.addReciever(p4);
        p4.addGift(g2);
        g3.addReciever(p1);
        p1.addGift(g3);
        g4.addReciever(p3);
        p3.addGift(g4);
        g5.addReciever(p3);
        p3.addGift(g5);

        System.out.println("Value of all gifts p1: " + p1.totalValueOfGifts());
        System.out.println("P1's gift givers: " + p1.getGiftGivers());
        System.out.println("Value of all gifts p2: " + p2.totalValueOfGifts());
        System.out.println("P2's gift givers: " + p2.getGiftGivers());
        System.out.println("Value of all gifts p3: " + p3.totalValueOfGifts());
        System.out.println("P3's gift givers: " + p3.getGiftGivers());
        System.out.println("Value of all gifts p4: " + p4.totalValueOfGifts());
        System.out.println("P4's gift givers: " + p4.getGiftGivers());

    }
}
