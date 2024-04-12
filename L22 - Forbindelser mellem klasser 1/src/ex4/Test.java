package ex4;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> castSeries1 = new ArrayList<>();
        String[] mainCast1 = {"Jennifer Aniston", "Courteney Cox", "Lisa Kudrow", "Matt LeBlanc", "Matthew Perry", "David Schwimmer"};

        for (String name : mainCast1) {
            castSeries1.add(name);
        }

        Series friends = new Series("Friends", castSeries1);

        ArrayList<String> guestActors1 = new ArrayList<>();
        String[] gA1Names = {"John Allen Nelson, Clea, Lewis"};

        for (String name : gA1Names) {
            guestActors1.add(name);
        }

        ArrayList<String> guestActors2 = new ArrayList<>();
        String[] gA2Names = {"Christina Pickles", "Anita Barone", "Jessica Hecht", "Mitchell Whitfield", "Elliot Gould"};

        for (String name : gA2Names) {
            guestActors1.add(name);
        }

        friends.addEpisode(1, guestActors1, 22);
        friends.addEpisode(2, guestActors1, 22);

        System.out.println("Title: " + friends.getTitle());
        System.out.println("Cast: " + friends.getCast());
        System.out.println("Episodes:\n" + friends.getEpisodes().toString());
    }
}
