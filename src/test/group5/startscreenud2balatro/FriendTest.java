package group5.startscreenud2balatro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendTest {
    private Friend f1 = new Friend("Swordsman", 75, 100, 50, "attack");
    private Friend f2 = new Friend ("Knight", 100, 50, 100, "defend");
    private Friend f3 = new Friend ("Priest", 100, 25, 25, "heal");

    private Card c1 = new Card("Swing", "attack", 100);
    private Card c2 = new Card("Use Shield", "defend", 100);
    private Card c3 = new Card("Heal", "heal", 100);




    //Testing attack unit with attack card
    @Test
    public void testFriendAction1(){
        Enemy e1 = new Enemy("Common Thief", 500, 110, 50, "attack");
        f1.action(c1, e1);
        //Calculations for damage = target health - cardValue - (unit attack / target defense)
        // 500 - 100 - (100 / 50) = 398
        assertEquals(398, e1.getCurrentHealth(), .001);
    }

    //Testing attack unit with any card
    @Test
    public void testFriendAction2(){
        Enemy e1 = new Enemy("Common Thief", 500, 110, 50, "attack");
        f1.action(c2, f1);
        //Calculations for defense = target defense + card value)
        // 50 + 100 = 150
        assertEquals(150, f1.getDefense(), .001);
    }


    //Testing defend unit with defend card
    @Test
    public void testFriendAction3(){
        Enemy e1 = new Enemy("Common Thief", 500, 110, 50, "attack");
        f2.action(c2, f2);
        //Calculations for defense = target defense + card value)
        // 100 * 2 = 200
        assertEquals(300, f2.getDefense(), .001);
    }


    //Testing defend unit with any card
    @Test
    public void testFriendAction4(){
        Enemy e1 = new Enemy("Common Thief", 500, 110, 50, "attack");
        f2.action(c1, e1);
        //Calculations for enemy health after attack = target health - (card value / target defense)
        // 500 - (100 / target defense) = 98
        assertEquals(498, e1.getCurrentHealth(), .001);
    }



    //Testing heal unit with heal card

    @Test
    public void testFriendAction5(){
        Enemy e1 = new Enemy("Common Thief", 500, 110, 50, "attack");
        f3.action(c3, f1);
        //Calculations for health after healing = target health + (card value * 2)
        // (100 * 2) + target health = 275
        assertEquals(275, f1.getCurrentHealth(), .001);
    }



    //Testing heal unit with any card

    @Test
    public void testFriendAction6(){
        Enemy e1 = new Enemy("Common Thief", 500, 110, 50, "attack");
        f1.action(c3, f2);
        //Calculatons for regular healing = target health + card value)
        // 100 + 100 = 200
        assertEquals(200, f2.getCurrentHealth(), .001);
    }
}
