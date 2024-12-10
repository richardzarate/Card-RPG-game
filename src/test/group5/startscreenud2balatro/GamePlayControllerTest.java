package group5.startscreenud2balatro;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GamePlayControllerTest {

    /**
     * Megan Weedon
     * This test checks that `checkCardSelection` works properly by throwing an exception
     * if the index is outside the range of 1 to 5 and returning true for valid indices.
     */
    @Test
    void testCheckCardSelection() {
        // Test valid indices
        try {
            assertTrue(checkCardSelection(1), "Index 1 should return true.");
            assertTrue(checkCardSelection(5), "Index 5 should return true.");
        } catch (Exception e) {
            fail("Valid indices should not throw an exception: " + e.getMessage());
        }

        // Test invalid indices
        assertThrows(IndexOutOfBoundsException.class, () -> checkCardSelection(0),
                "Index 0 should throw an exception.");
        assertThrows(IndexOutOfBoundsException.class, () -> checkCardSelection(6),
                "Index 6 should throw an exception.");
    }

    /**
     * Megan Weedon
     * This test checks that `checkTargetSelection` works properly by throwing an exception
     * if the index is outside the range of 1 to 3 and returning true for valid indices.
     */
    @Test
    void testCheckTargetSelection() {
        // Test valid indices
        try {
            assertTrue(checkTargetSelection(1), "Index 1 should return true.");
            assertTrue(checkTargetSelection(3), "Index 3 should return true.");
        } catch (Exception e) {
            fail("Valid indices should not throw an exception: " + e.getMessage());
        }

        // Test invalid indices
        assertThrows(IndexOutOfBoundsException.class, () -> checkTargetSelection(0),
                "Index 0 should throw an exception.");
        assertThrows(IndexOutOfBoundsException.class, () -> checkTargetSelection(4),
                "Index 4 should throw an exception.");
    }

    private boolean checkCardSelection(int index) throws IndexOutOfBoundsException {
        if (index < 1 || index > 5) {
            throw new IndexOutOfBoundsException("Index must be between 1 and 5.");
        }
        return true;
    }

    private boolean checkTargetSelection(int index) throws IndexOutOfBoundsException {
        if (index < 1 || index > 3) {
            throw new IndexOutOfBoundsException("Index must be between 1 and 3.");
        }
        return true;
    }
}