import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests SlotMachine class
 * 
 * @author Suzanne Balik
 * @author Ashwin Lingaraj
 */
public class SlotMachineTest {

    /** declaring slot machine to use for testing */
    private SlotMachine sm;

    /** 
     * runs before each test and declares the slot machine
     */
    @BeforeEach
    public void setUp() {
        sm = new SlotMachine(0);
    }
    
    /**
     * tests that BET_AMOUNT constant is equal to 5
     */
    @Test
    public void testConstant() {
        // The following test tests that required constant is defined as specified
        assertEquals(5, SlotMachine.BET_AMOUNT, "BET_AMOUNT");
    }

    /**
     * tests that slot machine is created correctly
     */
    @Test
    public void testConstructor() {
        assertEquals(50, sm.getNumberOfTokens(), "tokens after initialization");
        assertEquals("Pull Lever To Begin", sm.getStatus(),"status after initialization");
        

    }

    /**
     * tests how many tokens are left after one bet 
     */
    @Test
    public void testMakeBetSingleBet() {
        sm.makeBet();
        assertEquals(45, sm.getNumberOfTokens(), "Initial bet");
    }
    
    /**
     * tests how many tokens are left after multiple bets
     */
    @Test
    public void testMakeBetMultipleBets(){
        for (int i = 1; i <= 5; i++) {
            sm.makeBet();
        }
        assertEquals(25, sm.getNumberOfTokens(), 
                     "number of tokens after 5 bets");
    }
    
    /**
     * Tests that exception is thrown for makeBet when no tokens are left
     */
    @Test
    public void testMakeBetException() {
        for (int i = 1; i <= 10; i++) {
            sm.makeBet();
        }

        Exception exception = assertThrows(IllegalStateException.class, () -> sm.makeBet(),
                                           "Not enough tokens for bet");
        assertEquals("Not enough tokens for bet", exception.getMessage(), 
                     "Not enough tokens for bet - exception message");
    }

    /** 
     * turns reel once and checks symbols in each reel
     */
    @Test
    public void testTurnReelOnce() {
        sm.turnReel(); // Turns reel at index 0
        assertEquals(1, sm.getCurrentIndexOfReel(0), "Reel 0");
        assertEquals(0, sm.getCurrentIndexOfReel(1), "Reel 1");
        assertEquals(0, sm.getCurrentIndexOfReel(2), "Reel 2");
    }


    /**
     * turns reel four times and checks symbols in each reel
     */
    @Test
    public void turnReelMultipleTimes() {
        sm.turnReel(); // turns reel 0
        sm.turnReel(); // turns reel 1
        sm.turnReel(); // turns reel 1 
        sm.turnReel(); // turns reel 2
        assertEquals(1, sm.getCurrentIndexOfReel(0), "Reel 0");
        assertEquals(3, sm.getCurrentIndexOfReel(1), "Reel 1");
        assertEquals(1, sm.getCurrentIndexOfReel(2), "Reel 2");
        
    }

    /**
     * tests status and number of tokens after creation and no turns
     */
    @Test
    public void testDetermineOutcomeOnce() {
        sm.determineOutcome();
        assertEquals(100, sm.getNumberOfTokens(), "Tokens");
        assertEquals("3 State Symbols! 50 Tokens!", sm.getStatus(), "Status");
    }

    /**
     * tests status and number of tokens after multiple turns 
     */
    @Test
    public void testDetermineOutcome2() {
        sm.turnReel(); // turns reel 0 downward
        sm.turnReel(); // turns reel 1 upward
        sm.turnReel(); // turns reel 1 upward
        sm.turnReel(); // turns reel 2 downward
        sm.determineOutcome();
        assertEquals(100, sm.getNumberOfTokens(), "Tokens");
        assertEquals("2 Hearts! 50 Tokens!", sm.getStatus(), "Status");
        
    }
}
