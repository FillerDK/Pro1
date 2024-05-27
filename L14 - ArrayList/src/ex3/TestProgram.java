package ex3;

import java.util.ArrayList;

public class TestProgram {
    public static void main(String[] args) {
        Player p1 = new Player("Ib", 40);
        Player p2 = new Player("Bo", 35);
        Player p3 = new Player("Hans", 50);
        Player p4 = new Player("Jens", 45);

        p1.setScore(1000);
        p2.setScore(500);
        p3.setScore(1000);
        p4.setScore(400);

        Team hold = new Team("A-team");

        hold.addPlayer(p1);
        hold.addPlayer(p2);
        hold.addPlayer(p3);
        hold.addPlayer(p4);

        System.out.println(hold.toString());

        System.out.println(hold.getName());

        System.out.println(hold.getPlayers());

        hold.printPlayers();

        System.out.println(hold.calcAverageAge());

        System.out.println(hold.calcTotalScore());

        System.out.println(hold.calcOldPlayersScore(45));

        System.out.println(hold.maxScore());

        System.out.println(hold.bestPlayerNames());
    }
}
