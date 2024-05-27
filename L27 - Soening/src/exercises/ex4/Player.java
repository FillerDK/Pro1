package exercises.ex4;

import java.util.ArrayList;

public class Player {
    private String name;
    private int height;
    private double weight;
    private int scoredGoals;

    public Player(String name, int height, double weight, int scoredGoals) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.scoredGoals = scoredGoals;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, height: %d, weight: %.2f, goals scored: %s", name, height, weight, scoredGoals);
    }
}
