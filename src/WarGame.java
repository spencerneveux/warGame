import java.util.ArrayList;

/**
 * Class for the Card Game WAR
 */
public class WarGame {
    private static Deck deck;
    private static ArrayList<Card> pile;
    private static Deck player1;
    private static Deck player2;

    /**
     * War Game constructor
     */
    public WarGame() {
        deck = new Deck();
        pile = new ArrayList<>();
        player1 = new Deck(26);
        player2 = new Deck(26);
    }


    public static void main(String[] args) {
        new WarGame();
        System.out.println(deck.getSize());
        game();

    }

    /**
     * Display Main menu to users
     */
    public static void displayScreen() {
        System.out.println("Welcome to WAR!!!");
        System.out.println("1. Start Game");
        System.out.println("2. Quit");
        System.out.println();
    }

    /**
     * Deals a shuffled deck to each player
     * resulting in 26 cards per player
     */
    public static void dealHands() {
        // Shuffle deck
        deck.shuffle();

        // Deal 26 cards to each player
        while(deck.getSize() != 0) {
            player1.add(deck.deal());
            player2.add(deck.deal());
        }
    }



    public static void play() {
        // Each player plays one card
        Card p1Card = player1.deal();
        System.out.println("Player one's card is " + p1Card);
        pile.add(p1Card);

        Card p2Card = player2.deal();
        System.out.println("Player two's card is " + p2Card);
        pile.add(p2Card);


        // If player 1 wins, give him the pile
        if (p1Card.getRankValue() > p2Card.getRankValue()) {
            System.out.println("Player 1 wins the round");
            player1.addPile(pile);
            pile.clear();
        }

        // Player 2 wins, give him/her the pile
        else if (p2Card.getRankValue() > p1Card.getRankValue()) {
            System.out.println("Player 2 wins the round");
            player2.addPile(pile);
            pile.clear();
        }

        //WARRRR
        else {
            war();
        }
    }

    public static void war() {
        System.out.println("WARRRRRR!!!!!");

        boolean flag = true;
        while (flag) {

            // Deal two cards face down to the pile
            for (int i = 0; i < 2; i++) {
                System.out.println("War card for player 1 is xx");
                System.out.println("War card for player 2 is xx");
                pile.add(player1.deal());
                pile.add(player2.deal());
            }

            // Deal last card from both players & determine who wins war
            Card p1WarCard = player1.deal();
            System.out.println("Player 1 war card " + p1WarCard);
            pile.add(p1WarCard);

            Card p2WarCard = player2.deal();
            System.out.println("Player 2 war card " + p2WarCard);
            pile.add(p2WarCard);

            // if P1 wins
            if (p1WarCard.getRankValue() > p2WarCard.getRankValue()) {
                System.out.println("Player 1 won");
                player1.addPile(pile);
                pile.clear();
                flag = false;
            } else if (p2WarCard.getRankValue() > p1WarCard.getRankValue()) {
                System.out.println("Player 2 won");
                player2.addPile(pile);
                pile.clear();
                flag = false;
            } else {
                System.out.println("War again");
            }
        }
    }


    public static boolean winner() {
        if (player1.getSize() == 52){
            System.out.println("Player 1 is the WINNER!!!");
            System.out.println("Player one hand\n" + player1.getSize());
            System.out.println("Player two hand\n" + player2.getSize());
            System.out.println("Game Over");
            return true;
        }
        else if (player2.getSize() == 52) {
            System.out.println("Player 2 is the WINNER!!!");
            System.out.println("Player one hand\n" + player1.getSize());
            System.out.println("Player two hand\n" + player2.getSize());
            System.out.println("Game Over");
            return true;
        }else {
            return false;
        }
    }

    public static void game() {
        dealHands();
        boolean gameOver = false;
        while(!gameOver) {
            play();
            gameOver = winner();
        }
    }


}
