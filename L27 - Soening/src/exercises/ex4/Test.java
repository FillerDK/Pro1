package exercises.ex4;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();

        /*Player p1 = new Player("Peter", 192, 90, 65);
        Player p2 = new Player("Konrad", 150, 60, 23);
        Player p3 = new Player("Søren", 175, 85, 6);
        Player p4 = new Player("Sune", 169, 73, 2);
        Player p5 = new Player("Ole", 186, 80, 1);
        Player p6 = new Player("Mads", 154, 58, 0);
*/
        Player p1 = new Player("Peter", 162, 90, 65);
        Player p2 = new Player("Konrad", 150, 60, 23);
        Player p3 = new Player("Søren", 175, 85, 6);
        Player p4 = new Player("Sune", 169, 73, 2);
        Player p5 = new Player("Ole", 186, 80, 1);
        Player p6 = new Player("Mads", 154, 58, 0);

        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);

        System.out.println(findPlayerLinear(players, 0));
        System.out.println(findPlayerLinear(players, 1));
        System.out.println(findPlayerLinear(players, 2));
        System.out.println(findPlayerLinear(players, 3));
        System.out.println(findPlayerLinear(players, 4));
        System.out.println(findPlayerLinear(players, 5));
        System.out.println(findPlayerLinear(players, 6));

        System.out.println();

        System.out.println(findPlayerBinary(players, 0));
        System.out.println(findPlayerBinary(players, 1));
        System.out.println(findPlayerBinary(players, 2));
        System.out.println(findPlayerBinary(players, 3));
        System.out.println(findPlayerBinary(players, 4));
        System.out.println(findPlayerBinary(players, 5));
        System.out.println(findPlayerBinary(players, 6));

        System.out.println();

        System.out.println(findPlayerName(players));
    }

    public static Player findPlayerLinear(ArrayList<Player> players, int score) {
        int i = 0;
        Player player = null;

        while (player == null && i < players.size()) {
            int sg = players.get(i).getScoredGoals();
            if (sg == score) {
                player = players.get(i);
            } else i++;
        }

        return player;
    }

    public static Player findPlayerBinary(ArrayList<Player> players, int score) {
        Player player = null;
        int left = 0;
        int right = players.size() - 1;

        while (player == null && left <= right) {
            int middle = (left + right) / 2;
            Player k = players.get(middle);
            if (k.getScoredGoals() == score) {
                player = k;
            } else if (k.getScoredGoals() < score) {
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return player;
    }

    public static String findPlayerName(ArrayList<Player> players) {
        String name = "";
        int i = 0;

        while (name.equals("") && i < players.size()) {
            int height = players.get(i).getHeight();
            int goals = players.get(i).getScoredGoals();
            if (height < 170 && goals > 50) {
                name = players.get(i).getName();
            } else {
                i++;
            }
        }

        return name;
    }
}
