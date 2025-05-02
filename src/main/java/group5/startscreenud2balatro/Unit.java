package group5.startscreenud2balatro;

import javafx.scene.image.Image;

public abstract class Unit {
    //instance variables
    protected String name;

    protected int maxHealth;
    protected int currentHealth;
    protected int attack;
    protected int defense;
    protected String type;
    protected Image idleSprite;
    protected Image attackSprite;
    protected Image shieldSprite;

    //constructor
    public Unit(String name, int health, int attack, int defense, String type){
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.type = type;
    }

    public Unit(String name, int health, int attack, int defense, String type, String idleSpritePath, String attackSpritePath, String shieldSpritePath){
        this(name, health, attack, defense, type);
        System.out.println("creating image...");
        idleSprite = new Image(getClass().getResource(idleSpritePath).toExternalForm());
        System.out.println("image 1 created...");
        attackSprite = new Image(getClass().getResource(attackSpritePath).toExternalForm());
        System.out.println("image 2 created...");
        shieldSprite = new Image(getClass().getResource(shieldSpritePath).toExternalForm());
        System.out.println("image 3 created...");
        System.out.println("Friend with Sprite created using Super!");

    }
    /*
    getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Image getIdleSprite() {
        System.out.println("Image Width: " + this.idleSprite.getWidth());
        return idleSprite;
    }

    public void setIdleSprite(Image idleSprite) {
        this.idleSprite = idleSprite;
    }

    public Image getAttackSprite() {
        return attackSprite;
    }

    public void setAttackSprite(Image attackSprite) {
        this.attackSprite = attackSprite;
    }

    public Image getShieldSprite() {
        return shieldSprite;
    }

    public void setShieldSprite(Image shieldSprite) {
        this.shieldSprite = shieldSprite;
    }
}
