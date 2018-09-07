public class DeckTester {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
        System.out.println("Deck size should be 52");
        System.out.println("Deck Size: " + deck.getSize());
        for (int i = 0; i < 5; i++) {
            deck.deal();
        }
        System.out.println("Deck has dealt five cards, size should be 47");
        System.out.println(deck.getSize());
        System.out.println("Sorting the deck");
        deck.sort();
        System.out.println(deck);
        System.out.println("Removing all cards");
        int size = deck.getSize();
        for (int i = 0; i < size; i++) {
            deck.deal();
        }
        System.out.println("Deck should be empty");
        System.out.println(deck);
        System.out.println(deck.getSize());
        System.out.println("Adding cards to deck");
        Card card = new Card(Card.Rank.ACE, Card.Suite.CLUBS);
        deck.add(card);
        System.out.println(deck);
        System.out.println("Deck size (should be 1) " + deck.getSize());
        deck.add(card);
    }
}
