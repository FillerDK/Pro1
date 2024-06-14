package storage;

import model.Badge;
import model.Deltager;
import model.Hold;

import java.util.ArrayList;

public abstract class Storage {
    // section S2
    private static final ArrayList<Hold> alleHold = new ArrayList<>();
    private static final ArrayList<Badge> badges = new ArrayList<>();

    // store
    public static void storeHold(Hold hold) {
        alleHold.add(hold);
    }

    public static void storeBadge(Badge badge) {
        badges.add(badge);
    }

    // getters
    public static ArrayList<Hold> getHold() {
        return new ArrayList<>(alleHold);
    }

    public static ArrayList<Badge> getBadges() {
        return new ArrayList<>(badges);
    }

    // removers
    public static void removeHold(Hold hold) {
        alleHold.remove(hold);
    }

}
