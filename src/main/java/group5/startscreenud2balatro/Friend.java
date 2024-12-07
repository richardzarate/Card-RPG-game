package group5.startscreenud2balatro;

public class Friend extends Unit{
    //constructor
    public Friend(String name, int health, int attack, int defense, String type){
        super(name, health, attack, defense, type);
    }

    //action function for Friend class depends on the unit and card stats plus if the card type matches the unit type
    public void action(Card card, Unit target){

        //check if the card type and unit type matches first
        if(card.getActionType().equals(this.type)){
            if(card.getActionType().equals("heal")){
                target.currentHealth += 2 * card.getActionValue();
            }
            else if(card.getActionType().equals("attack")){
                target.currentHealth -= card.getActionValue() + (this.attack / target.defense);
            }
            else if(card.getActionType().equals("defend")){
                this.defense += (2 * card.getActionValue()); //double the defense plus the card value if both card and unit type are defensive
            }

        }
        //if they don't match do this instead
        else{
            if(card.getActionType().equals("heal")){
                target.currentHealth += card.getActionValue();
            }
            else if(card.getActionType().equals("attack")){
                target.currentHealth -= (card.getActionValue() / target.defense);
            }
            else if(card.getActionType().equals("defend")){
                this.defense += card.getActionValue();
            }
        }
    }
}
