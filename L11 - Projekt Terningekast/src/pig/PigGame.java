package pig;

public class PigGame {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        System.out.println("Playing Pig.");
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPlayerName(1);
        player2.setPlayerName(2);

        startGame(player1, player2);

        printResults(player1, player2);
        System.out.println();

        System.out.println("Thank you for playing Pig.");
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Pig:");
        System.out.println("The player throws one die until they get 100 points.");
        System.out.println("If they roll a 1, they get 0 points and their turn ends.");
        System.out.println("The player must decide whether to gamble or play it safe!");
        System.out.println("The second player may start their turn, when the other rolls a 1 or stops.");
        System.out.println("=====================================================");
    }

    private static void startGame(Player player1, Player player2) {
        while (!player1.isWinnerFound() && !player2.isWinnerFound()) {
            player1.play();
            System.out.println("Next players turn.\n");
            player2.play();
            if (!player1.isWinnerFound() && !player2.isWinnerFound()) {
                System.out.println("Next players turn.\n");
            }
        }
    }

    private static void printResults(Player player1, Player player2) {
        if (player1.getTotalSum() > player2.getTotalSum()) {
            System.out.printf("The winner is: %s", player1.getPlayerName());
        } else if (player1.getTotalSum() < player2.getTotalSum()) {
            System.out.printf("The winner is: %s", player2.getPlayerName());
        } else {
            System.out.println("It's a draw.");
        }
    }
}
