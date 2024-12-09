package group5.startscreenud2balatro;

public class Enemy extends Unit {
    public Enemy(String name, int health, int attack, int defense, String type){
        super(name, health, attack, defense, type);
    }

    //enemy unit action that depends on their health. Plus returns a string to state what they're doing
    public String action(Unit target){
        int damage = 0;
        //if enemy unit is at half health, the unit will either heal or take a defensive stance
        if(this.currentHealth <= (this.maxHealth / 2)){
            if(this.type == "healer"){
                target.currentHealth += (int) (this.maxHealth * .1); //heals for 10% of unit's health
                return this.name + " heals for " + (int)(this.maxHealth * .1);
            }
            else{
                this.defense = (int)(this.defense * 1.1); //defensive stance
                return this.name + " goes into defensive stance.";
            }

        }
        //if enemy's health is high enough, it will attack instead
        else{
            if(target.getCurrentHealth() <= 0){
                return this.getName() + " has attacked an already dead target.";
            }
            damage = target.currentHealth - (this.attack / target.defense);
            target.currentHealth -= damage;
            return this.name + " attacks " + target.name + " for " + damage + " damage.";
        }


    }
}