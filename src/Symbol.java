/**
 *  class represents a single symbol used in the slot machine reel
 * @author Ashwin Lingaraj
 */
public class Symbol {
    
    /** name of symbol */
    private String name;
    
    /** value of symbol */
    private int value;
    
    /**
     * constructor initializing Symbol object to name and value in parameters
     * @param name of symbol
     * @param value of symbol
     */
    public Symbol (String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * returns the name of the symbol
     * @return name of symbol
     */
    public String getName(){
        return name;
    }
    
    /**
     * returns the value of the symbol
     * @return value of symbol
     */
    public int getValue(){
        return value;
    }
    
    /** 
     * checks if two objects are equal
     * @param o object 
     * @return true if objects are equals and false if objects are not equal
     */
    public boolean equals(Object o){
        if (o instanceof Symbol){
            Symbol other = (Symbol)o;
            if (name.equals(other.name) && value == other.value){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /** 
     * returns a string representation of the symbol
     * @return name and value
     */
    public String toString(){
        return name + " " + value;
    }
}