import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests Symbol class
 * 
 * @author Suzanne Balik
 * @author Ashwin Lingaraj
 */
public class SymbolTest {
    
    /** Mr. Wuf symbol */ 
    private Symbol wuf;
    
    /** Tiger symbol */
    private Symbol tiger;
    
    /**
     * Creates fields before each test case is executed
     */
    @BeforeEach
    public void setUp() {
        wuf = new Symbol("Mr. Wuf", 100);
        tiger = new Symbol("Tiger", 50);
    }
    
    
    /**
     * Test getName for Mr. Wuf
     */
    @Test
    public void testGetNameWuf() {
        assertEquals("Mr. Wuf", wuf.getName(), "Test getName for Mr. Wuf");
    }
    

    /** 
     * Test getName method for Tiger
     */
    @Test 
    public void testGetNameTiger() {
        assertEquals("Tiger", tiger.getName(), "Test getName for Tiger");
    }
    
    /**
     * Test getValue for Mr. Wuf
     */
    @Test
    public void testGetValueWuf() {
        assertEquals(100, wuf.getValue(), "Test getValue for Mr. Wuf");
    }
    
    
    /**
     * Test getValue method for Tiger
     */
    @Test
    public void testGetValueTiger(){
        assertEquals(50, tiger.getValue(), "Test getValue for Tiger");
    }
    
    /**
     * Test toString for Mr. Wuf
     */
    @Test
    public void testToStringWuf() {
        assertEquals("Mr. Wuf 100", wuf.toString(), "Test toString for Mr. Wuf" );
    }
    
    
    /**
     * Test toString method for tiger
     */
    @Test
    public void testToStringTiger(){
        assertEquals("Tiger 50", tiger.toString(), "Test toString for Tiger");
    }
    
    /**
     * Test equals for Mr. Wuf
     */
    @Test
    public void testEqualsWuf() {
        assertTrue(wuf.equals(wuf), "wuf equals with same instance");
        assertTrue(wuf.equals(new Symbol("Mr. Wuf", 100)), "wuf equals with different instances");
        assertFalse(wuf.equals(new Symbol("Mr. wuf", 100)), "wuf with different name");
        assertFalse(wuf.equals(new Symbol("Mr. Wuf", 101)), "wuf with different value");
        assertFalse(wuf.equals(new Symbol("Mr. wuf", 101)), "wuf with different name and value");
        assertFalse(wuf.equals(null), "wuf compared to null object");
        assertFalse(wuf.equals("Mr. Wuf"), "wuf compared to String");
    }

    /** 
     * Test equals for Tiger
     */
    @Test
    public void testEqualsTiger() {
        assertTrue(tiger.equals(tiger), "tiger equals with same instance");
        assertTrue(tiger.equals(new Symbol("Tiger", 50)), "tiger equals with different instances");
        assertFalse(tiger.equals(new Symbol("tiger", 50)), "tiger with different name");
        assertFalse(tiger.equals(new Symbol("Tiger", 101)), "tiger with different value");
        assertFalse(tiger.equals(new Symbol("tiger", 101)), "tiger with different name and value");
        assertFalse(wuf.equals(null), "tiger compared to null object");
        assertFalse(wuf.equals("Tiger"), "wuf compared to String");
    }
}
