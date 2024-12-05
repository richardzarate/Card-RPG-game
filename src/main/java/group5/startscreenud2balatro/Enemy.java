package group5.startscreenud2balatro;

public class Enemy extends Unit {
    public Enemy(String name, int health, int attack, int defense, String type){
        super(name, health, attack, defense, type);
    }

    //enemy unit action that depends on their health. Plus returns a string to state what they're doing
    public String action(Unit target){
        //if enemy unit is at half health, the unit will either heal or take a defensive stance
        if(this.health <= (this.health / 2)){
            if(this.type == "healer"){
                this.health = (int) (this.health * 1.1); //heals for 10% of it's health
                return this.name + " heals for " + (int)(this.health * .1);
            }
            else{
                this.defense = (int)(this.defense * 1.1); //defensive stance
                return this.name + " goes into defensive stance.";
            }

        }
        //if enemy's health is high enough, it will attack instead
        else{
            target.health = target.health - (this.attack / target.defense);
            return this.name + " attacks " + target.name + " for " + this.attack + " damage.";
        }


    }
}
