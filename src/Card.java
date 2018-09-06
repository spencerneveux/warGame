public class Card {

    public enum Suite {
        SPADES(1), CLUBS(2), DIAMONDS(3),  HEARTS(4);

        private int value;

        Suite(int value) {
            this.value = value;
        }

        public Integer getSuiteValue() {
            return value;
        }
    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private int value;

        Rank(int value) {
            this.value = value;
        }

        public Integer getRankValue() {
            return value;
        }
    }

    private Rank rank;
    private Suite suite;


    public Card() {}

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Suite getSuite() {
        return suite;
    }

    public Rank getRank() {
        return rank;
    }

    public Integer getRankValue() {
        return rank.getRankValue();
    }

    public Integer getSuiteValue() {
        return suite.getSuiteValue();
    }

    public String toString() {
        return (rank + " of " + suite + " value: " + rank.getRankValue());
    }


    public static void main(String[] args) {
        Card c1 = new Card(Rank.ACE, Suite.SPADES);
        System.out.println(c1);
        Card c2 = new Card(Rank.EIGHT, Suite.CLUBS);
        System.out.println(c2);
        System.out.println(c2.getRank());
        System.out.println(c1.getSuite());
        System.out.println(c2.getRankValue());
        System.out.println(c1.getSuiteValue());
    }
}
