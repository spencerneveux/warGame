import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a Deck class that extends the Card class
 *
 */
public class Deck extends Card {
    private List<Card> deckArray;
    private int size;

    /**
     * General purpose constructor
     * generates a deck with 52 cards in sequential order
     */
    public Deck() {
        deckArray = new ArrayList<>();

        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                deckArray.add(new Card(rank, suite));
            }
        }

        this.size = deckArray.size();

    }

    /**
     * Overloaded constructor which generates an empty deck
     * Instantiates deckArray to given size param n
     * @param n the size of the intended deck
     */
    public Deck(int n) {
        deckArray = new ArrayList<>(n);
        size = n;
    }

    /**
     * Method to shuffle the deck of cards
     */
    public void shuffle() {
        Collections.shuffle(deckArray);
    }


    /**
     * Method that returns one card Object from the deck
     * reassigns the size to current size of arraylist
     * @return Card object
     */
    public Card deal() {
        Card card = deckArray.remove(0);
        size = deckArray.size();
        return card;
    }

    /**
     * Method to sort the deck into sequential order based on rank value
     */
    public void sort() {
        Collections.sort(deckArray, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c1.getRankValue().compareTo(c2.getRankValue());
            }
        });
    }

    @Override
    /**
     * Overriding standard toString method
     */
    public String toString() {
        String result = " | ";
        for (Card card : deckArray) {
            result += " " + card + " | ";
        }
        return result;
    }

    /**
     * Getter for deck size
     * @return size of deck
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds individual card object to deck
     * @param card Card object
     */
    public void add(Card card) {
        deckArray.add(card);
        size = deckArray.size();
    }

    /**
     * Adds an array of cards to deck
     * @param list An arrayList of card objects
     */
    public void addPile(ArrayList<Card> list) {
        deckArray.addAll(list);
        size = deckArray.size();
    }
}
