package ex4;

import java.util.ArrayList;

public class Episode {
    private int number;
    private ArrayList<String> guestActors = new ArrayList<>();
    private int lengthMinutes;

    public Episode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        this.number = number;
        this.guestActors = guestActors;
        this.lengthMinutes = lengthMinutes;
    }

    public int getNumber() {
        return number;
    }

    public int getLength() {
        return lengthMinutes;
    }

    public ArrayList<String> getGuestCast() {
        return guestActors;
    }
}
