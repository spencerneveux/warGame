import java.util.ArrayList;

public class WarGame {
    public static void main(String[] args) {
        displayScreen();
        Deck deck = new Deck();
        ArrayList<Card> pile = new ArrayList<>();
        Deck player1Deck = new Deck(26);
        Deck player2Deck = new Deck(26);
        deck.shuffle();

        // Creating Player hands
        for (int i = 0; i < deck.getSize(); i++) {
            player1Deck.add(deck.deal());
            player2Deck.add(deck.deal());
        }


        // Playing the game
        Card p1Card = player1Deck.deal();
        System.out.println(p1Card);
        pile.add(p1Card);

        Card p2Card = player2Deck.deal();
        System.out.println(p2Card);
        pile.add(p2Card);

        System.out.println(pile);

        // If player 1 wins, give him the pile
        if (p1Card.getRankValue() > p2Card.getRankValue()) {
            System.out.println("Player 1 won");
            player1Deck.addPile(pile);
            System.out.println(player1Deck);
        }

        // Player 2 wins, give him/her the pile
        else if (p2Card.getRankValue() > p1Card.getRankValue()) {
            System.out.println("Player 2 won");
            player2Deck.addPile(pile);
            System.out.println(player2Deck);
        }

        //WARRRR
        else {
            System.out.println("WARRRRRR!!!!!");
            for (int i = 0; i < 2; i++) {
                Card c1 = player1Deck.deal();
                System.out.println(c1);
                pile.add(c1);

                Card c2 = player2Deck.deal();
                System.out.println(c2);
                pile.add(c2);
            }

            System.out.println(pile);

            Card p1WarCard = player1Deck.deal();
            pile.add(p1WarCard);
            Card p2WarCard = player2Deck.deal();
            pile.add(p2WarCard);

            System.out.println(pile);

            // if P1 wins
            if (p1WarCard.getRankValue() > p2WarCard.getRankValue()) {
                System.out.println("Player 1 won");
                player1Deck.addPile(pile);
                System.out.println(player1Deck);
            } else if (p1WarCard.getRankValue() > p2WarCard.getRankValue()) {
                System.out.println("Player 2 won");
                player2Deck.addPile(pile);
                System.out.println(player2Deck);
            }else {
                System.out.println("war again");
            }


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
