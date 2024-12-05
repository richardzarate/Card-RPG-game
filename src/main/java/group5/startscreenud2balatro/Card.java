package group5.startscreenud2balatro;

public class Card {

    //instance variables
    private String cardName;
    private String actionType;
    private int actionValue;

    //constructor
    public Card(String cardName, String actionType, int actionValue) {
        this.cardName = cardName;
        this.actionType = actionType;
        this.actionValue = actionValue;
    }

    /*
    getters and setters
     */
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getActionValue() {
        return actionValue;
    }

    public void setActionValue(int actionValue) {
        this.actionValue = actionValue;
    }
}
