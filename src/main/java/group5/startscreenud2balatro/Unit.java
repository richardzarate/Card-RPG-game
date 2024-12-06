package group5.startscreenud2balatro;

public abstract class Unit {
    //instance variables
    protected String name;

    protected int maxHealth;
    protected int currentHealth;
    protected int attack;
    protected int defense;
    protected String type;

    //constructor
    public Unit(String name, int health, int attack, int defense, String type){
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.type = type;
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
}
