import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck extends Card {
    private List<Card> deckArray;
    private int size;

    public Deck() {
        deckArray = new ArrayList<Card>();

        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                deckArray.add(new Card(rank, suite));
            }
        }

        this.size = deckArray.size();

    }

    public void shuffle() {
        Collections.shuffle(deckArray);
    }


    public Card deal() {
        Card card = deckArray.remove(0);
        size--;
        return card;
    }

    public void sort() {
        Collections.sort(deckArray, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c1.getRankValue().compareTo(c2.getRankValue());
            }
        });
    }


    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Size of the deck: " + deck.size);
        System.out.println(deck.deckArray);
        Card c1 = deck.deal();
        System.out.println("Card one is " + c1);
        System.out.println("Card one value is " + c1.getRankValue());
        Card c2 = deck.deal();
        System.out.println("Card two is " + c2);
        System.out.println(deck.deckArray);
        System.out.println("Size of the deck: " + deck.size);
        deck.shuffle();
        System.out.println(deck.deckArray);
        System.out.println();

        Deck deck2 = new Deck();
        deck2.shuffle();
        System.out.println(deck2.deckArray);
        deck2.sort();
        System.out.println(deck2.deckArray);



    }

}
