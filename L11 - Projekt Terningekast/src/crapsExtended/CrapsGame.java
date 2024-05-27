package crapsExtended;

public class CrapsGame {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        Player player = new Player();
        System.out.println("Playing Craps...");
        player.play();
        System.out.println();

        System.out.println("Thank you for playing Craps.");
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Craps:");
        System.out.println("The player throws two dice and count the sum of the roll:");
        System.out.println("* If the player rolls 7 or 11 in the first try, they win!");
        System.out.println("* If the player rolls 2, 3 or 12 in the first try, they lose!");
        System.out.println("* Any other sum becomes the player's \"point\".\n");
        System.out.println("If the player gets a \"point\", they must try to reroll and get their \"point\".");
        System.out.println("If the player rolls a 7 instead of their \"point\", they lose!");
        System.out.println("Otherwise the player must keep rolling to win!");
        System.out.println("=====================================================");
    }
}
