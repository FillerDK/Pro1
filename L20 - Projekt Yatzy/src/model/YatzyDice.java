package model;

import java.util.Random;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6 for i in [0..4]
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private final Random random = new Random();

    /**
     * Return the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the 5 face values of the dice.<br/>
     * Pre: 1 <= values[i] <= 6 for i in [0..4].<br/>
     * Note: This method is only to be used in tests.
     */
    void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Return the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Reset the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Roll the 5 dice. Only roll dice that are not hold.<br/>
     * Note: holdStatus[i] is true, if die number i is hold (for i in [0..4]).
     */
    public void throwDice(/*boolean[] holdStatus*/) {
        throwCount++;
    }

    // -------------------------------------------------------------------------

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[16];
        for (int i = 1; i <= 6; i++) {
            results[i] = this.sameValuePoints(i);
        }
        results[7] = this.onePairPoints();
        results[8] = this.twoPairPoints();
        results[9] = this.threeSamePoints();
        results[10] = this.fourSamePoints();
        results[11] = this.fullHousePoints();
        results[12] = this.smallStraightPoints();
        results[13] = this.largeStraightPoints();
        results[14] = this.chancePoints();
        results[15] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    private int[] frequency() {
        int[] frequency = new int[7];
        for (int v = 0; v < values.length; v++) {
            frequency[values[v]]++;
        }
        return frequency;
    }

    /**
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6.
     */
    public int sameValuePoints(int value) {
        return value * frequency()[value];
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        return samePoints(2);
    }

    /**
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        int[] frequency = frequency();
        for (int i = frequency.length - 1; i >= 0; i--)
            if (frequency[i] >= 2) {
                for (int j = i - 1; j >= 0; j--)
                    if (frequency[j] >= 2) {
                        return i * 2 + j * 2;
                    }
            }
        return 0;
    }

    /**
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        return samePoints(3);
    }

    /**
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {
        return samePoints(4);
    }

    /**
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {
        int[] frequency = frequency();
        for (int i = frequency.length - 1; i >= 0; i--)
            if (frequency[i] >= 2) {
                if (frequency[i] >= 3) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (frequency[j] >= 2) {
                            return i * 3 + j * 2;
                        }
                    }
                } else {
                    for (int j = i - 1; j >= 0; j--) {
                        if (frequency[j] >= 2) {
                            return i * 2 + j * 3;
                        }
                    }
                }
            }
        return 0;
    }

    /**
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int[] frequency = frequency();
        for (int i = 1; i <= 5; i++) {
            if (frequency[i] != 1) {
                return 0;
            }
        }
        return 15;
    }

    /**
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int[] frequency = frequency();
        for (int i = 2; i <= 6; i++) {
            if (frequency[i] != 1) {
                return 0;
            }
        }
        return 20;
    }

    /**
     * Return points for chance (the sum of face values).
     */
    public int chancePoints() {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        } return sum;
    }

    /**
     * Return points for yatzy (50 points).<br/>
     * Return 0, if there aren't 5 dice with the same face value.
     */
    public int yatzyPoints() {
        int[] frequency = frequency();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == 5)
                return 50;
        }
        return 0;
    }

    // -------------------------------------------------------------------------
    // helper method
    private int samePoints(int value) {
        int[] frequency = frequency();
        for (int i = frequency.length - 1; i >= 0; i--)
            if (frequency[i] >= value) return (i * value);
        return 0;
    }
}
