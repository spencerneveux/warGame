public class Card {

    public enum Suite {
        HEARTS, DIAMONDS, SPADES, CLUBS;
    }

    private int rank;
    private Suite suite;

    public Card() {
        this(-1, null);
    }

    public Card(int rank, Suite suite) {
        setRank(rank);
        setSuite(suite);
    }

    public void setRank(int rank) {
        if (rank < 1 || rank > 13)
            throw new IllegalArgumentException("Card rank out of bounds");
        else
            this.rank = rank;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public int getRank() {
        return rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public String getRankString() {
        if (rank < 10)
            return Integer.toString(rank);
        else
            switch(rank) {
                case 9: return "Ten";
                case 10: return "Jack";
                case 11: return "Queen";
                case 12: return "King";
                case 13: return "Ace";
                default: return "xx";
            }
    }

    public String toString() {
        return (getRankString() + " of " + getSuite());
    }


    public static void main(String[] args) {
        Card c1 = new Card(11, Suite.DIAMONDS);
        Card c2 = new Card(5, Suite.CLUBS);
        Card c3 = new Card(13, Suite.HEARTS);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }
}
