package group5.startscreenud2balatro;
import java.util.*;

public class GameMaster {
    private static GameMaster instance;
    private int currentFloor;
    private int totalFloor;
    private String player;
    private Stack<Card> deck;
    private Vector<Card> hand;
    private Vector<Enemy> activeEnemyUnits;
    private Vector<Friend> activeFriendUnits;

    private String[] possibleCards = {"Heal", "Attack Bonus", "etc etc"};

    private GameMaster(String player, int totalFloor){
        this.player = player;
        this.totalFloor = totalFloor;
        currentFloor = 0;
        deck = new Stack<Card>();
        hand = new Vector<Card>();
        activeEnemyUnits = new Vector<Enemy>();
        activeFriendUnits = new Vector<Friend>();
    }

    public static GameMaster getInstance(String player, int totalFloor) {
        if (instance == null) {
            instance = new GameMaster(player, totalFloor);
        }
        return instance;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public String getPlayer() {
        return player;
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public Vector<Card> getHand() {
        return hand;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    public void setPlayer(String name) {
        this.player = name;
    }

    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }

    public void setHand(Vector<Card> hand) {
        this.hand = hand;
    }

    public void runFloor(){
        //add code to make every enemy in enemy list to fight friend in friend list and if player wins go to next floor
    }

    public void enemyMove(){
        //??

    }

    public void pickUpCard(){
        //get random number 0-51 and add it to deck
        Random random = new Random();
        int actiontyperand = random.nextInt(3);
        int actionvaluerand = random.nextInt(11);
        Card card = new Card("placeholder", possibleCards[actiontyperand], actionvaluerand);
        addCardtoDeck(card);
   }

    public void updateUnits(){
        //??
    }

    public void newGame(){
        player = "N/A";
        totalFloor = 0;
        currentFloor = 0;
        deck.clear();
        hand.clear();
        activeEnemyUnits.clear();
        activeFriendUnits.clear();
        System.out.println("ALl stats have been reset! New game started!");
    }

    public void addCardtoDeck(Card card){
        deck.add(card);
    }

    public void shuffleDeck(){
        System.out.println("Shuffing the deck....");
        Collections.shuffle(deck);
        System.out.println("The deck has been shuffled");
    }
}
