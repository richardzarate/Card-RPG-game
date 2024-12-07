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

    private String[] possibleCardTypes = {"attack", "defend", "heal", "attack", "attack", "heal", "defend", "attack"};
    private String[] othercardtype = {"Swing", "Use Shield", "Basic Heal", "Stab", "Super Attack", "Super Heal", "Super Defend", "Poison Spell"};
    private int[] actionvalues = {60, 50, 50, 55, 100, 100, 100, 60};
    private String[] possibleFriends = {"Swordsman", "Knight", "Wizard", "Shieldsman", "Priest"};
    //int health, int attack, int defense, String type
    private int[] healthfriends = {80, 100, 60, 90, 50};
    private int[] defensefriends = {70, 90, 30, 100, 30};
    private int[] attackfriends = {90, 100, 70, 40, 50};
    private String[] typefriends = {"attack", "attack", "heal", "defend", "heal"};


    private String[] possibleEnemies = {"Thief", "Witch", "Zombie"};
    //int health, int attack, int defense, String type
    private int[] healthenemy = {100, 60, 80};
    private int[] defenseenemy = {50, 40, 80};
    private int[] attackenemy = {90, 60, 70};
    private String[] typeenemy = {"attack", "heal", "attack"};


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

    public void initializeFloor(){
        //init player hand
        //init friend and enemy units
        Random rand = new Random();
        int randcardname = rand.nextInt(8);
        for(int i = 0; i < 5; i++){
            Card c = new Card(othercardtype[randcardname], possibleCardTypes[randcardname], actionvalues[randcardname]);
            hand.add(c);
        }
        int randfriend1 = rand.nextInt(5);
        //int randfriend2 = rand.nextInt(5);
        Friend f1 = new Friend(possibleFriends[randfriend1], healthfriends[randfriend1], attackfriends[randfriend1], defensefriends[randfriend1], typefriends[randfriend1]);
        //Friend f2 = new Friend(possibleFriends[randfriend2], healthfriends[randfriend2], attackfriends[randfriend2], defensefriends[randfriend2], typefriends[randfriend2]);
        activeFriendUnits.add(f1);
        //activeFriendUnits.add(f2);

        int randen1 = rand.nextInt(3);
        //int randen2 = rand.nextInt(3);
        Enemy e1 = new Enemy(possibleEnemies[randen1], healthenemy[randen1], attackenemy[randen1], defenseenemy[randen1], typeenemy[randen1]);
        //Enemy e2 = new Enemy(possibleEnemies[randen2], healthenemy[randen2], attackenemy[randen2], defenseenemy[randen2], typeenemy[randen2]);
        activeEnemyUnits.add(e1);
        //activeEnemyUnits.add(e2);
    }

    public void runBattle(Card selectedCard, int targetIndex) {
        if (targetIndex < 0 || targetIndex >= activeEnemyUnits.size()) {
            System.out.println("Invalid target index.");
            return;
        }

        Enemy targetEnemy = activeEnemyUnits.get(targetIndex);
        Friend playerUnit = activeFriendUnits.get(0);
        playerUnit.action(selectedCard, targetEnemy);
        if (targetEnemy.getCurrentHealth() <= 0) {
            System.out.println(targetEnemy.getName() + " has been defeated!");
            activeEnemyUnits.remove(targetIndex);
            return;
        }

        System.out.println(targetEnemy.action(playerUnit));
        if (playerUnit.getCurrentHealth() <= 0) {
            System.out.println(playerUnit.getName() + " has been defeated! Game over.");
        }
        currentFloor++;
        totalFloor++;
    }


    public void useCardInHand(int cardIndex, int targetIndex) {
        if (cardIndex < 0 || cardIndex >= hand.size()) {
            return;
        }
        Card selectedCard = hand.get(cardIndex);
        runBattle(selectedCard, targetIndex);
        hand.remove(cardIndex);
    }

    public void updateUnits(){

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
