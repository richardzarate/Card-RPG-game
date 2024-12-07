package group5.startscreenud2balatro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    private Friend f1 = new Friend("Swordsman", 75, 100, 50, "attack");
    private Friend f2 = new Friend ("Knight", 100, 50, 100, "defend");
    private Friend f3 = new Friend ("Priest", 100, 25, 25, "heal");

    private Enemy e1 = new Enemy("Common Thief", 500, 110, 50, "attack");
    private Enemy e2 = new Enemy("Witch", 1000, 75, 50, "healer");
    //testing enemy attack
    @Test
    public void testEnemyAction1(){
        e1.action(f1);
        //Calculation for enemy damage -> target health - (enemy attack / target defense)
        // 75 - (110 / 50) = 73
        assertEquals(73, f1.getCurrentHealth(), .001);
    }


    //testing enemy action when health is less than 50%
    @Test
    public void testEnemyAction2(){
        e1.setCurrentHealth(100);
        e1.action(f1);
        //Calculation for taking defense is defense * 1.1)
        // 50 * 1.1 = 55
        assertEquals(55, e1.getDefense(), .001);
    }

    //testing enemy healing
    @Test
    public void testEnemyAction3(){
        e2.setCurrentHealth(100);
        e2.action(e2);
        //Calculation for healing is currentHealth += maxHealth * .1
        // 100 + (1000 * .1) = 200
        assertEquals(200, e2.getCurrentHealth(), .001);
    }
}