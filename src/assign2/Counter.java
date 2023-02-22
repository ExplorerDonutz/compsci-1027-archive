/* Michael Quick
 * Feb 21 2023
 * Calculates the number of points from a cribbage hand
 */
package assign2;

import java.util.Arrays;

public class Counter {
    private PowerSet<Card> cardps;
    private Card starter;

    public Counter(Card[] hand, Card starter) {
        this.starter = starter;
        cardps = new PowerSet<>(hand);
    }

    public int countPoints() {
        int total = 0;

        // Calculate each way to score
        total += getPairs(cardps);
        total += getRuns(cardps);
        total += getFifteen(cardps);
        total += getKnob(cardps);
        total += getFlush(cardps);
        return total;
    }

    private int getPairs(PowerSet<Card> ps) {
        int score = 0;

        // Loop through each set in the power set
        for (int i = 0; i < ps.getLength(); i++) {
            Set<Card> set = ps.getSet(i);

            // If the set has a length of 2 then it could contain a pair of cards
            if (set.getLength() == 2) {
                // If the labels are equal then the cards are a pair and should raise the score by two
                if (set.getElement(0).getLabel().equals(set.getElement(1).getLabel()))
                    score += 2;
            }
        }

        return score;
    }

    private int getRuns(PowerSet<Card> ps) {
        int score = 0;

        // Set initial value to minimum length of a run
        int maxRunLength = 3;

        for (int i = 0; i < ps.getLength(); i++) {
            Set<Card> set = ps.getSet(i);

            // If the length of the set is greater than or equal to the biggest run length, it could hold a bigger or equal run
            if (set.getLength() >= maxRunLength) {

                // Create a temporary array to hold the values in the set
                int[] runRanks = new int[set.getLength()];

                // Loop through the current set
                for (int j = 0; j < set.getLength(); j++) {
                    // Populate the array with the run ranks of the elements in set
                    runRanks[j] = set.getElement(j).getRunRank();
                }
                // Sort the ranks in ascending order
                Arrays.sort(runRanks);
                boolean isRun = true;

                for (int j = 0; j < runRanks.length - 1; j++) {
                    if (runRanks[j + 1] != runRanks[j] + 1) {
                        // The run is over as the next value does not equal the current value + 1
                        isRun = false;
                        break;
                    }
                }

                // Check if run is the biggest, or equal to the biggest run
                if (isRun && runRanks.length > maxRunLength) {
                    // Reset the score to the current run length and set the max run length to the current run length
                    score = runRanks.length;
                    maxRunLength = runRanks.length;
                } else if (isRun && runRanks.length == maxRunLength) {
                    // Run is same length as the biggest run so add the value of its length to the score
                    score += runRanks.length;
                }
            }
        }
        return score;
    }

    private int getFifteen(PowerSet<Card> ps) {
        int score = 0;
        for (int i = 0; i < ps.getLength(); i++) {
            Set<Card> set = ps.getSet(i);

            int isFifteen = 0;
            // Loop through each element in the set
            for (int j = 0; j < set.getLength(); j++) {
                // Add up the sum of the fifteen ranks in the set
                isFifteen += set.getElement(j).getFifteenRank();
            }

            // If the sum is 15 then the set contains a combination of cards that adds to 15
            if (isFifteen == 15)
                score += 2;
        }
        return score;
    }

    private int getKnob(PowerSet<Card> ps) {
        // Create a card that would be the "knob" for this set
        Card knob = new Card(starter.getSuit(), "J");

        for (int i = 0; i < ps.getLength(); i++) {
            Set<Card> set = ps.getSet(i);

            // If the set has "his knobs", return a score of 1
            if (set.contains(knob) && !starter.equals(knob)) {
                return 1;
            }
        }
        return 0;
    }

    private int getFlush(PowerSet<Card> ps) {
        int flushNum = 0;
        for (int i = 0; i < ps.getLength(); i++) {
            Set<Card> set = ps.getSet(i);
            if (set.getLength() >= 4) {

                // Start the flush count at 1
                flushNum = 1;

                // Loop through each element of the suit
                for (int j = 0; j < set.getLength() - 1; j++) {
                    // If the suit of the element at j is equal to the one next to it in the set then add to the flush count
                    if (set.getElement(j).getSuit().equals(set.getElement(j + 1).getSuit())) {
                        flushNum++;

                    // If the element at j and the next element are not the starter card, then there is no flush in this set
                    } else if (!set.getElement(j).getSuit().equals(starter.getSuit()) && !set.getElement(j + 1).getSuit().equals(starter.getSuit())) {
                        return 0;
                    }
                }
            }
        }
        return flushNum;
    }
}
