/**
 * Spencer Neveux
 * 9/10/18
 * This program creates a card class
 *
 */
public class Card {

    /**
     * Enumerating possible suite values
     */
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

    /**
     * Enumerating possible ranks
     */
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


    /**
     * Null Constructor
     */
    public Card() {
        this(null, null);
    }

    /**
     * Overloaded Constructor
     * @param rank takes in rank to assign to instance variable
     * @param suite takes in suit to assign to insatnce variable
     */
    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    /**
     * get method for suite
     * @return suite
     */
    public Suite getSuite() {
        return suite;
    }

    /**
     * get method for rank
     * @return rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * get value for corresponding rank value
     * @return rank's value
     */
    public Integer getRankValue() {
        return rank.getRankValue();
    }

    /**
     * get value for corresponding suite value
     * @return suite value
     */
    public Integer getSuiteValue() {
        return suite.getSuiteValue();
    }

    /**
     * overriding tostring method
     * @return string representation of card
     */
    @Override
    public String toString() {
        return (rank + " of " + suite);
    }


}
