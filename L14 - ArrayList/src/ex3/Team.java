package ex3;

import java.util.ArrayList;

public class Team {
    private String name;

    private ArrayList<Player> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Team(%s)", name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.print(player.toString() + " ");
        }
        System.out.println();
    }

    public double calcAverageAge() {
        int ageSum = 0;
        for (Player player : players)
            ageSum += player.getAge();
        return ageSum / players.size();
    }

    public int calcTotalScore() {
        int totalScore = 0;
        for (Player player : players)
            totalScore += player.getScore();
        return totalScore;
    }

    public int calcOldPlayersScore(int ageLimit) {
        int totalOldScore = 0;
        for (Player player : players)
            if (player.getAge() >= ageLimit)
                totalOldScore += player.getScore();
        return totalOldScore;
    }

    public int maxScore() {
        int highestScore = 0;
        for (Player player : players)
            if (player.getScore() > highestScore)
                highestScore = player.getScore();
        return highestScore;
    }

    public ArrayList<String> bestPlayerNames() {
        ArrayList<String> bestPlayers = new ArrayList<>();
        for (Player player : players)
            if (player.getScore() == maxScore())
                bestPlayers.add(player.getName());
        return bestPlayers;
    }
}
