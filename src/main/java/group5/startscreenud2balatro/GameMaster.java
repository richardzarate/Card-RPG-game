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

    private int currentFriendIndex;
    private int currentEnemyTarget;

    private String turnLog = "";

    private Unit enemyTarget;
    private int enemyTargetIndex;


    /*
    Creating static default friendly units and possible card elements

    The only purpose of these units are for demonstration. Since creating units would take past deadline
     */

//    public static Friend f1 = new Friend("Swordsman", 500, 700, 300, "attack");
//    public static Friend f2 = new Friend("Knight", 1000, 1000, 600, "defend");
//    public static Friend f3 = new Friend("Healer", 750, 200, 250, "heal");

    public static Friend f1 = new Friend("Samurai", 500, 700, 300, "attack",
            "/sprites/friends/Samurai/Idle.png",
            "/sprites/friends/Samurai/Attack_2.png",
            "/sprites/friends/Samurai/Shield.png");
    public static Friend f2 = new Friend("Fighter", 1000, 1000, 600, "defend",
            "/sprites/friends/Fighter/Idle.png",
            "/sprites/friends/Fighter/Attack_3.png",
            "/sprites/friends/Fighter/Shield.png");
    public static Friend f3 = new Friend("Shinobi", 750, 200, 250, "heal",
            "/sprites/friends/Shinobi/Idle.png",
            "/sprites/friends/Shinobi/Attack_1.png",
            "/sprites/friends/Shinobi/Shield.png");

    private static String[] allPossibleCardTypes = {"attack", "defend", "heal"};
    private static String[] possibleAttackActions = {"Punch", "Swing", "Stab", "Shoot", "Kick", "Uppercut", "Pummel", "Spin Attack"};
    private static String[] possibleDefendActions = {"Block", "Defensive Stance", "Raise Shield", "Deflect", "Parry"};
    private static String[] possibleHealActions = {"Potion", "Pray", "Heal Spell", "Food", "Rest"};
    private static int[] possibleCardValues = {25, 50, 75, 100, 150};

    private static String[] possibleOffensiveEnemyUnits = {"Witch", "Demon", "Thief", "Murderer", "Marauder", "Defector", "Crazed Mercenary", "Zealot"};
    private static String[] possibleDefensiveEnemyUnits = {"Dark Knight", "Goliath", "Giant", "Mounted Dark Knight", "Demon Shield", "Slave Peasant"};
    private static String[] possibleHealerEnemyUnits = {"Witch Doctor", "Corrupted Priest", "Greedy Doctor", "Cult Leader", "Tormented Alchemist"};

    private static int[] possibleUnitValues = {100, 200, 250, 300, 325};






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
    private int[] healthenemy = {30, 40, 15};
    private int[] defenseenemy = {15, 10, 5};
    private int[] attackenemy = {50, 35, 25};
    private String[] typeenemy = {"attack", "heal", "attack"};


    private GameMaster(String player, int totalFloor){
        this.player = player;
        this.totalFloor = totalFloor;
        currentFloor = 0;
        deck = new Stack<Card>();
        hand = new Vector<Card>();
        activeEnemyUnits = new Vector<Enemy>();
        activeFriendUnits = new Vector<Friend>();

        currentFriendIndex = 0;
        currentEnemyTarget = 0;
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

    public int getTotalFloor(){
        return totalFloor;
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

    public Friend getActiveFriendUnit(int index){
        return activeFriendUnits.get(index);
    }
    public Enemy getActiveEnemydUnit(int index){
        return activeEnemyUnits.get(index);
    }

    public Vector<Enemy> getActiveEnemyUnits() {
        return activeEnemyUnits;
    }

    public void setActiveEnemyUnits(Vector<Enemy> activeEnemyUnits) {
        this.activeEnemyUnits = activeEnemyUnits;
    }

    public Vector<Friend> getActiveFriendUnits() {
        return activeFriendUnits;
    }

    public void setActiveFriendUnits(Vector<Friend> activeFriendUnits) {
        this.activeFriendUnits = activeFriendUnits;
    }

    public void initializeFloor(){

        for(int i = 0; i <= 5; i++){
            hand.add(createRandomCard());
        }
        //adding default units as active units
        activeFriendUnits.clear();
        activeFriendUnits.add(f1);
        activeFriendUnits.add(f2);
        activeFriendUnits.add(f3);


        activeEnemyUnits.clear();
        //adding 3 enemies as active units
        for(int i = 0; i < 3; i++){
            activeEnemyUnits.add(createRandomEnemyUnit());
        }

        this.currentFloor = 1;


        /*
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

         */
    }

    public void processTurn(Card c, Unit playerTarget){



        Random random = new Random();
        int randNum = random.nextInt(3);
        turnLog += activeFriendUnits.get(currentFriendIndex).action(c, playerTarget) + "\n";
        turnLog += activeEnemyUnits.get(currentFriendIndex).action(activeFriendUnits.get(randNum));
        enemyTarget = activeEnemyUnits.get(currentFriendIndex).getCurrentTarget();
        if(enemyTarget instanceof Friend){
            enemyTargetIndex = activeFriendUnits.indexOf(enemyTarget);
        }
        else{
            enemyTargetIndex = activeEnemyUnits.indexOf(enemyTarget);
        }

        if(currentFriendIndex > 2){
            currentFriendIndex = 0;
        }
        else{
            currentFriendIndex++;
        }


    }

    public String getTurnLog(){
        return turnLog;
    }

    public void setTurnLog(String s){
        turnLog = s;
    }

    public Unit getEnemyTarget(){
        return enemyTarget;
    }

    public int getEnemyTargetIndex(){
        return enemyTargetIndex;
    }


    //TODO: Check if this function is needed
    public boolean runBattle(Card selectedCard, Unit target) {
        Random random = new Random();
        int randTarget = random.nextInt(3); //Enemies will pick a random Target

//        Unit targetedUnit = ac

//        f1.action(selectedCard, target);


        /*
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

         */
//        currentFloor++;

        return true;
//        totalFloor++;
    }


    public Card useCardInHand(int cardIndex) {
//        if (cardIndex < 0 || cardIndex >= hand.size()) {
//            return;
//        }
        Card selectedCard = hand.get(cardIndex);
        //runBattle(selectedCard, targetIndex);
        hand.remove(cardIndex);
        hand.add(createRandomCard()); //will automatically add a card after the player picks a card
        return selectedCard;
    }


    //Might not be needed after all
    public void updateUnits(){

    }

    public String checkWinner(){
        String victoryMessage = "";
        boolean allFriendUnitsDead = true;
        boolean allEnemyUnitsDead = true;
        for(Friend f : activeFriendUnits){
            allFriendUnitsDead = f.getCurrentHealth() <= 0;
            if(!allFriendUnitsDead){
                break;
            }
            else{
                victoryMessage = "Enemies has won. You Lose!\n";
                return victoryMessage;
            }
        }

        for(Enemy e : activeEnemyUnits){
            allEnemyUnitsDead = e.getCurrentHealth() <= 0;
            if(!allEnemyUnitsDead){
                break;
            }
            else{
                victoryMessage = "You won!";
                if(currentFloor >= totalFloor){
                    victoryMessage += " Congratulations you conquered the Tower!\n";
                }
                else{
                    victoryMessage += " Moving on to next floor!\n";
                    currentFloor++;
                    initializeFloor();
                }
                return victoryMessage;
            }
        }
        return victoryMessage;
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
        System.out.println("Shuffling the deck....");
        Collections.shuffle(deck);
        System.out.println("The deck has been shuffled");
    }

    public void pullCardFromDeck(){
        hand.add(createRandomCard());
    }

    //This function is meant to give the illusion of pulling a card from a deck by generating a random card with random values
    public Card createRandomCard(){
//        Card randCard;
        Random random = new Random();
        int randNum = random.nextInt(3);
        String cardType = "";
        String cardName = "";
        int cardValue = 0;

        //pick a type of card
        cardType = allPossibleCardTypes[randNum];


        //generate possible actions and values based on card type
        if(cardType.equals("attack")){
            randNum = random.nextInt(possibleAttackActions.length);
            cardName = possibleAttackActions[randNum];
            randNum = random.nextInt(possibleCardValues.length);
            cardValue = possibleCardValues[randNum];
        }

        else if(cardType.equals("defend")){
            randNum = random.nextInt(possibleDefendActions.length);
            cardName = possibleDefendActions[randNum];
            randNum = random.nextInt(possibleCardValues.length);
            cardValue = possibleCardValues[randNum];
        }

        else if(cardType.equals("heal")){
            randNum = random.nextInt(possibleHealActions.length);
            cardName = possibleHealActions[randNum];
            randNum = random.nextInt(possibleCardValues.length);
            cardValue = possibleCardValues[randNum];
        }

        return new Card(cardName, cardType, cardValue);
    }

    public Enemy createRandomEnemyUnit(){
//        Card randCard;
        Random random = new Random();
        int randNum = random.nextInt(3);
        String enemyType = "";
        String enemyName = "";
        int enemyHpValue = 0;
        int enemyAttackValue = 0;
        int enemyDefenseValue = 0;

        //pick a type of card
        enemyType = allPossibleCardTypes[randNum];


        //generate possible actions and values based on card type
        if(enemyType.equals("attack")){
            randNum = random.nextInt(possibleOffensiveEnemyUnits.length - 1);
            enemyName = possibleOffensiveEnemyUnits[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyHpValue = possibleUnitValues[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyAttackValue = possibleUnitValues[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyDefenseValue = possibleUnitValues[randNum];
        }

        else if(enemyType.equals("defend")){
            randNum = random.nextInt(possibleDefensiveEnemyUnits.length - 1);
            enemyName = possibleDefensiveEnemyUnits[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyHpValue = possibleUnitValues[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyAttackValue = possibleUnitValues[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyDefenseValue = possibleUnitValues[randNum];
        }

        else if(enemyType.equals("heal")){
            randNum = random.nextInt(possibleHealerEnemyUnits.length - 1);
            enemyName = possibleHealerEnemyUnits[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyHpValue = possibleUnitValues[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyAttackValue = possibleUnitValues[randNum];
            randNum = random.nextInt(possibleUnitValues.length - 1);
            enemyDefenseValue = possibleUnitValues[randNum];
        }

        return new Enemy(enemyName, enemyHpValue, enemyAttackValue, enemyDefenseValue, enemyType,
                "/sprites/Default Sprite/Idle.png",
                "/sprites/Default Sprite/Attack.png",
                "/sprites/Default Sprite/Hurt.png");
    }
}
