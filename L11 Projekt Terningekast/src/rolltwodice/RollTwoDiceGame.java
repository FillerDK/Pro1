package rolltwodice;

public class RollTwoDiceGame {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        rolltwodice.Player player = new rolltwodice.Player();
        System.out.println("Playing RollTwoDice.");
        player.play();

        printResults(player);
        System.out.println();

        System.out.println("Thank you for playing RollTwoDice.");
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDice:");
        System.out.println("The player throws two dice for as long as they wants.");
        System.out.println("=====================================================");
    }

    public static void printResults(Player player) {
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("* Throw count: " + player.getThrowCount());
        System.out.println("* Total sum: " + player.getTotalSum());
        System.out.println("* Amount of times the dice have the same face value in one throw: " + player.getSameFaceValue());
        System.out.println("* Max amount rolled in one throw: " + player.getMaxSum());
        System.out.printf("* Average sum of throws: %.2f\n\n", player.getAverageSumOfThrows());
        player.printFaceValueCount();
    }
}
