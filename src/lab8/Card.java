package lab8;

public class Card implements Comparable<Card> {

    private String suit; // S (spade), H (heart), D (diamond), or C (club)
    private String rank; // A (ace), 2, 3, ..., 10, J (jack), Q (queen), or K (king)

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card other) {
        if (this.equals(other)) return 0;

        if (this.getRankValue() > other.getRankValue()) return 1;
        else if (this.getRankValue() < other.getRankValue()) return -1;

        if (this.getSuitValue() > other.getSuitValue()) return 1;
        else if (this.getSuitValue() < other.getSuitValue()) return -1;
        return -1;
    }

    public boolean equals(Card other) {
        return this.getRankValue() == other.getRankValue() && this.getSuitValue() == other.getSuitValue();
    }

    private int getSuitValue() {
        switch (getSuit()) {
            case "D":
                return 1;
            case "C":
                return 2;
            case "H":
                return 3;
            case "S":
                return 4;
            default:
                return 0;
        }
    }

    private int getRankValue() {
        try {
            return Integer.parseInt(getRank());
        } catch (NumberFormatException e) {
            switch (getRank()) {
                case "J", "Q", "K":
                    return 11;
                case "A":
                    return 12;
                default:
                    return 0;
            }
        }
    }
}

