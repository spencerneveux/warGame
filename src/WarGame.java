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
        game();
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


    /**
     * Method to play individual rounds
     * calls war method if players meet war requirements
     */
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
        }

        // Player 2 wins, give him/her the pile
        else if (p2Card.getRankValue() > p1Card.getRankValue()) {
            System.out.println("Player 2 wins the round");
            player2.addPile(pile);
        }

        //WAR
        else {
            war();
        }

        // Empty the pile
        pile.clear();
    }

    /**
     * In the event of two matching cards, deal out three face down
     * deal fourth card up and determine who wins
     * if matching again repeat war
     */
    public static void war() {
        System.out.println("WARRRRRR!!!!!");

        boolean flag = true;
        while (flag) {

            // Check to see if both players can play war
            if (player1.getSize() >= 4 && player2.getSize() >= 4) {
                warDeal();
            }
            else if (player1.getSize() < 4) {
                System.out.println("Player 1 doesn't have enough cards");
                emptyHand(player1);
                break;
            }

            else if (player2.getSize() < 4) {
                System.out.println("Player two doesn't have enough cards");
                emptyHand(player2);
                break;
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


    /**
     * Method to deal out cards when war occurs
     */
    public static void warDeal() {
        for (int i = 0; i < 3; i++) {
            System.out.println("War card for player 1 is xx");
            System.out.println("War card for player 2 is xx");
            pile.add(player1.deal());
            pile.add(player2.deal());
        }
    }

    /**
     * If player has less than enough cards to play war
     * empty the rest to the pile
     * @param deck deck of cards representing either players hand
     */
    public static void emptyHand(Deck deck) {
        int size = deck.getSize();
        for (int i = 0; i < size; i++) {
            pile.add(deck.deal());
        }
    }

    /**
     * Determine if a player wins
     * a player loses if
     * @return boolean value whether or not there is a winner
     */
    public static boolean winner() {
        if (player1.getSize() == 0){
            System.out.println("Game Over");
            System.out.println("Player 2 is the WINNER!!!");
            return true;
        }
        else if (player2.getSize() == 0) {
            System.out.println("Game Over");
            System.out.println("Player 1 is the WINNER!!!");
            return true;
        }else {
            return false;
        }
    }


    /**
     * Method to start game and run logic
     */
    public static void game() {
        dealHands();
        boolean gameOver = false;
        while(!gameOver) {
            play();
            gameOver = winner();
        }
    }


}
