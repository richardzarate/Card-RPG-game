package group5.startscreenud2balatro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void testConstructor() {
        Card card = new Card("Punch", "attack", 50);
        assertEquals("Punch", card.getCardName());
        assertEquals("attack", card.getActionType());
        assertEquals(50, card.getActionValue());
    }

    @Test
    void getCardName() {
        Card card = new Card("Deflect", "defend", 75);
        String cardName = card.getCardName();
        assertEquals("Deflect", cardName);
    }

    @Test
    void setCardName() {
        Card card = new Card("Stab", "attack", 100);
        card.setCardName("Spin Attack");
        assertEquals("Spin Attack", card.getCardName());
    }

    @Test
    void getActionType() {
        Card card = new Card("Potion", "heal", 25);
        String actionType = card.getActionType();
        assertEquals("heal", actionType);
    }

    @Test
    void setActionType() {
        Card card = new Card("Swing", "attack", 150);
        card.setActionType("defend");
        assertEquals("defend", card.getActionType());
    }

    @Test
    void getActionValue() {
        Card card = new Card("Raise Shield", "defend", 100);
        int actionValue = card.getActionValue();
        assertEquals(100, actionValue);
    }

    @Test
    void setActionValue() {
        Card card = new Card("Pray", "heal", 50);
        card.setActionValue(75);
        assertEquals(75, card.getActionValue());
    }

    @Test
    void testCardMutability() {
        Card card = new Card("Punch", "attack", 50);
        card.setCardName("Kick");
        card.setActionType("defend");
        card.setActionValue(150);
        assertEquals("Kick", card.getCardName());
        assertEquals("defend", card.getActionType());
        assertEquals(150, card.getActionValue());
    }
}