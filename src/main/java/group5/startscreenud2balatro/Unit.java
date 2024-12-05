package group5.startscreenud2balatro;

public abstract class Unit {
    //instance variables
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected String type;

    //constructor
    public Unit(String name, int health, int attack, int defense, String type){
        this.name = name;
        this.health = health;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
}
