public class CardTester extends Card{
    public static void main(String[] args) {
        Card c1 = new Card(Rank.ACE, Suite.DIAMONDS);
        System.out.println("Creating Ace of Diamonds");
        System.out.println(c1);
        System.out.println("Getting value (should be 14)");
        System.out.println(c1.getRankValue());
        System.out.println("Getting suite value (should be 3)");
        System.out.println(c1.getSuiteValue());
        System.out.println("Getting suit");
        System.out.println(c1.getSuite());
        Card c2 = new Card();
        System.out.println("Empty card");
        System.out.println(c2);
    }
}
