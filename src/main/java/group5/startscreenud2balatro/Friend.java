package group5.startscreenud2balatro;

public class Friend extends Unit{
    //constructor
    public Friend(String name, int health, int attack, int defense, String type){
        super(name, health, attack, defense, type);
    }

    //action function for Friend class depends on the unit and card stats plus if the card type matches the unit type
    public String action(Card card, Unit target){

        int actionValue = 0;
        //check if the card type and unit type matches first
        if(card.getActionType().equals(this.type)){
            if (card.getActionType().equalsIgnoreCase("heal")) {
                int healAmount = Math.min(card.getActionValue(), target.getMaxHealth() - target.getCurrentHealth());
                target.setCurrentHealth(target.getCurrentHealth() + healAmount);


                return this.getName() + " has healed " + target.getName() + " for " + actionValue + " health points.\n";
            }
            else  if (card.getActionType().equalsIgnoreCase("attack")) {
                int rawDamage = card.getActionValue();
                int mitigatedDamage = Math.max(0, rawDamage - target.getDefense());
                target.setCurrentHealth(target.getCurrentHealth() - mitigatedDamage);

                if (mitigatedDamage == 0) {
                    return this.name + " attacked " + target.getName() + ", but the attack was blocked by defense!\n";
                } else {
                    return this.getName() + " has attacked " + target.getName() + " for " + actionValue + " damage.\n";
                }

            }
            else if(card.getActionType().equalsIgnoreCase("defend")){
                actionValue = (2 * card.getActionValue()); //double the defense plus the card value if both card and unit type are defensive
                this.defense += actionValue;
                return this.getName() + " has raised defense by " + actionValue + " points.\n";
            }

        }
        //if they don't match do this instead
        else{
            if(card.getActionType().equals("heal")){
                actionValue = card.getActionValue();
                target.currentHealth += actionValue;
                return this.getName() + " has healed " + target.getName() + " for " + actionValue + " health points.\n";
            }
            else if(card.getActionType().equals("attack")){
                if(target.getCurrentHealth() <= 0){
                    return this.getName() + " has attacked an already dead target.\n";
                }
                actionValue = (card.getActionValue() / target.defense);
                target.currentHealth -= actionValue;
                return this.getName() + " has attacked " + target.getName() + " for " + actionValue + " damage.\n";

            }
            else if(card.getActionType().equals("defend")){
                actionValue = card.getActionValue();
                this.defense += actionValue;
                return this.getName() + " has raised defense by " + actionValue + " points.\n";
            }
        }
        return "Invalid move...";
    }
}