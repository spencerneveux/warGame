public class WarGame {
    public static void main(String[] args) {
        displayScreen();
        Deck deck = new Deck();
        Deck player1Deck = new Deck(26);
        Deck player2Deck = new Deck(26);
        deck.shuffle();

        for (int i = 0; i < deck.getSize(); i++) {
            player1Deck.add(deck.deal());
            player2Deck.add(deck.deal());
        }

        Card p1Card = player1Deck.deal();
        System.out.println(p1Card);
        Card p2Card = player2Deck.deal();
        System.out.println(p2Card);


        if (p1Card.getRankValue() > p2Card.getRankValue()) {
            System.out.println("Player 1 won");
            player1Deck.add(p2Card);
            System.out.println(player1Deck);
        }
        else if (p2Card.getRankValue() > p1Card.getRankValue()) {
            System.out.println("Player 2 won");
            player2Deck.add(p1Card);
            System.out.println(player2Deck);
        }
        else {
            System.out.println("WARRRRRR!!!!!");

        }

    }

    public static void displayScreen() {
        System.out.println("Welcome to WAR!!!");
        System.out.println("1. Start Game");
        System.out.println("2. Quit");
        System.out.println();
    }


    public static void start() {
        Deck deck = new Deck();
        Deck player1Deck = new Deck(26);
        Deck player2Deck = new Deck(26);

        for (int i = 0; i < deck.getSize(); i++) {
            player1Deck.add(deck.deal());
            player2Deck.add(deck.deal());
        }
    }


}
