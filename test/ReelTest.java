import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Reel class
 * 
 * @author Suzanne Balik
 * @author Ashwin Lingaraj
 */
public class ReelTest {
    /** reel object declaration created for testing */
    private Reel reel;

    /** runs before each test is executed */
    @BeforeEach
    public void setUp() {
        reel = new Reel(-1);
    }
    
    /** 
     * tests that symbols and constants match 
     */
    @Test
    public void testConstants() {
        // The following tests that constants are defined as specified
        assertEquals(5, Reel.NUMBER_OF_SYMBOLS, "NUMBER_OF_SYMBOLS");

        assertEquals("State Symbols", Reel.SYMBOL_NAMES[0], "SYMBOL_NAMES[0]");
        assertEquals("Hearts", Reel.SYMBOL_NAMES[1], "SYMBOL_NAMES[1]");
        assertEquals("Bars", Reel.SYMBOL_NAMES[2], "SYMBOL_NAMES[2]");
        assertEquals("Cherries", Reel.SYMBOL_NAMES[3], "SYMBOL_NAMES[3]");
        assertEquals("Sevens", Reel.SYMBOL_NAMES[4], "SYMBOL_NAMES[4]");

        assertEquals(10, Reel.SYMBOL_VALUES[0], "SYMBOL_VALUES[0]");
        assertEquals(25, Reel.SYMBOL_VALUES[1], "SYMBOL_VALUES[1]");
        assertEquals(50, Reel.SYMBOL_VALUES[2], "SYMBOL_VALUES[2]");
        assertEquals(75, Reel.SYMBOL_VALUES[3], "SYMBOL_VALUES[3]");
        assertEquals(100, Reel.SYMBOL_VALUES[4], "SYMBOL_VALUES[4]");
    }

    /**
     * tests that constructors preconditions work properly
     */
    @Test
    public void testConstructorPreConditions() {
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Reel(0),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(), 
                     "Illegal direction - exception message");  

        exception = assertThrows(IllegalArgumentException.class, () -> new Reel(2),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(), 
                     "Illegal direction - exception message");  

        exception = assertThrows(IllegalArgumentException.class, () -> new Reel(-2),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(), 
                     "Illegal direction - exception message");  

        exception = assertThrows(IllegalArgumentException.class, () -> new Reel(1000),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(), 
                     "Illegal direction - exception message");  

        exception = assertThrows(IllegalArgumentException.class, () -> new Reel(-1000),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(), 
                     "Illegal direction - exception message");                       
        
    }
    
    /**
     * test getCurrentIndex method to see if it returns the correct current index
     */
    @Test
    public void testGetCurrentIndex() {
        assertEquals(0, reel.getCurrentIndex(), "Current index after constructed");
    }
    
    /**
     * test getCurrentSymbol to see if it returns correct current symbol of the reel
     */
    @Test
    public void testGetCurrentSymbol() {
        assertEquals(new Symbol("State Symbols", 10), reel.getCurrentSymbol(), 
                     "Current symbol after constructed");
    }
    
    /**
     * tests toString method output
     */
    @Test
    public void testToString() {
        assertEquals("Current index: 0\n" + "Current symbol: State Symbols\n" +
                     "Symbol 0: State Symbols 10\n" + "Symbol 1: Hearts 25\n" +
                     "Symbol 2: Bars 50\n" + "Symbol 3: Cherries 75\n" +
                     "Symbol 4: Sevens 100\n",
                     reel.toString(), "toString  after constructed");
    }
    
    /**
     * tests turn methods and each of the three methods after each turn
     * tests that output changes correctly and methods work after each turn
     */
    @Test
    public void testTurn() {
        reel.turn();
        assertEquals(4, reel.getCurrentIndex(), "Current Index after 1 turn");
        assertEquals(new Symbol("Sevens", 100), reel.getCurrentSymbol(),
                     "Current Symbol after 1 turn");
        assertEquals("Current index: 4\n" + "Current symbol: Sevens\n" +
                     "Symbol 0: State Symbols 10\n" + "Symbol 1: Hearts 25\n" +
                     "Symbol 2: Bars 50\n" + "Symbol 3: Cherries 75\n" +
                     "Symbol 4: Sevens 100\n", reel.toString(), "toString after 1 turn");
                     
        reel.turn();
        assertEquals(3,reel.getCurrentIndex(), "Current Index after 2 turns");
        assertEquals(new Symbol("Cherries", 75), reel.getCurrentSymbol(),
                     "Current Symbol after two turns");
        assertEquals("Current index: 3\n" + "Current symbol: Cherries\n" +
                     "Symbol 0: State Symbols 10\n" + "Symbol 1: Hearts 25\n" +
                     "Symbol 2: Bars 50\n" + "Symbol 3: Cherries 75\n" +
                     "Symbol 4: Sevens 100\n", reel.toString(), "toString after 2 turns" );
    }

}
