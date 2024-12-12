package group5.startscreenud2balatro;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameMasterTest {

    private final GameMaster gameMaster;

    public GameMasterTest(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
    }

     //ensures the singleton pattern is working properly
//    @Test
//    void testSingletonInstance() {
//        GameMaster instance1 = GameMaster.getInstance();
//        GameMaster instance2 = GameMaster.getInstance();
//        assertSame(instance1, instance2);
//    }

    // ensures that the current floor is equal to 1, and that active friend and enemy units are populated
    @Test
    void testInitializeFloor() {
        gameMaster.initializeFloor();
        assertEquals(1, gameMaster.getCurrentFloor());
        assertFalse(gameMaster.getActiveEnemyUnits().isEmpty(), "Enemy units populated");
        assertFalse(gameMaster.getActiveFriendUnits().isEmpty(), "Friendly units populated");
    }
//
//    @Test
//    void getCurrentFloor() {
//    }
//
//    @Test
//    void getTotalFloor() {
//    }
//
//    @Test
//    void getPlayer() {
//
//    }


//    // ensures checkWinner() is working properly when all enemies are gone and all freindlies are gone
//    @Test
//    void testCheckWinner() {
//        //game state where the player wins
//        gameMaster.getActiveEnemyUnits().clear(); // No active enemies
//        assertTrue(gameMaster.checkWinner());
//
//        //game state where the player loses
//        gameMaster.getActiveEnemyUnits().add(new Enemy("Enemy", 10, 5));
//        gameMaster.getActiveFriendUnits().clear();
//        assertFalse(gameMaster.checkWinner());
//    }

}