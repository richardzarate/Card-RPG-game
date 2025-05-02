package group5.startscreenud2balatro;

public class Friend extends Unit{
    //constructor
    public Friend(String name, int health, int attack, int defense, String type){
        super(name, health, attack, defense, type);
    }

    public Friend(String name, int health, int attack, int defense, String type, String idleSpritePath, String attackSpritePath, String shieldSpritePath){

        super(name, health, attack, defense, type, idleSpritePath, attackSpritePath, shieldSpritePath);
//        System.out.println("Friend with Sprite created!");
    }



    //action function for Friend class depends on the unit and card stats plus if the card type matches the unit type
    public String action(Card card, Unit target){

        int actionValue = 0;
        //check if the card type and unit type matches first
        if(card.getActionType().equals(this.type)){
            if(card.getActionType().equals("heal")){
                actionValue = 2 * card.getActionValue();
                target.currentHealth += actionValue;

                return this.getName() + " has healed " + target.getName() + " for " + actionValue + " health points.";
            }
            else if(card.getActionType().equals("attack")){
                if(target.getCurrentHealth() <= 0){
                    return this.getName() + " has attacked an already dead target.";
                }
                actionValue = card.getActionValue() + (this.attack / target.defense);
                target.currentHealth -= actionValue;

                return this.getName() + " has attacked " + target.getName() + " for " + actionValue + " damage.";
            }
            else if(card.getActionType().equals("defend")){
                actionValue = (2 * card.getActionValue()); //double the defense plus the card value if both card and unit type are defensive
                this.defense += actionValue;
                return this.getName() + " has raised defense by " + actionValue + " points.";
            }

        }
        //if they don't match do this instead
        else{
            if(card.getActionType().equals("heal")){
                actionValue = card.getActionValue();
                target.currentHealth += actionValue;
                return this.getName() + " has healed " + target.getName() + " for " + actionValue + " health points.";
            }
            else if(card.getActionType().equals("attack")){
                if(target.getCurrentHealth() <= 0){
                    return this.getName() + " has attacked an already dead target.";
                }
                actionValue = (card.getActionValue() / target.defense);
                target.currentHealth -= actionValue;
                return this.getName() + " has attacked " + target.getName() + " for " + actionValue + " damage.";

            }
            else if(card.getActionType().equals("defend")){
                actionValue = card.getActionValue();
                this.defense += actionValue;
                return this.getName() + " has raised defense by " + actionValue + " points.";
            }
        }
        return "Invalid move...";
    }
}