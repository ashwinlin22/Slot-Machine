/**
 * class represents a single reel used in the slot machine
 * @author Ashwin Lingaraj
 */
public class Reel {
    /** number of symbols in a reel */
    public static final int NUMBER_OF_SYMBOLS = 5;
    
    /** value when adding moving upward from symbol four, used to identify rollover */
    public static final int MAX_ROLLOEVER = 5;
    
    /** index of highest symbol */
    public static final int HIGHEST_SYMBOL = 4;
    
    /** array containing names of symbols in reel */
    public static final String[] SYMBOL_NAMES = {"State Symbols", "Hearts", "Bars", 
                                                 "Cherries", "Sevens"};
    
    /** array containing values of symbols in reel */
    public static final int[] SYMBOL_VALUES = {10, 25, 50, 75, 100};
    
    /** array of symbols for reel */
    private Symbol[] symbols;
    
    /** current index of the symbol in the reel */
    private int currentIndex;
    
    /** direction the reel will spin */
    // -1 is upward
    //+1 is downward
    private int direction;
    
    /**
     * constructor initializing reel object
     * creates reel with 5 objects and sets currentIndex to 0
     * @param direction the reel will turn
     */
    public Reel (int direction){
        symbols = new Symbol[NUMBER_OF_SYMBOLS];
        for (int i = 0; i < NUMBER_OF_SYMBOLS; i++){
            symbols[i] = new Symbol(SYMBOL_NAMES[i], SYMBOL_VALUES[i]);
        }
        currentIndex = 0;
        if (direction != 1 && direction != -1){
            throw new IllegalArgumentException("Illegal direction");
        }
        this.direction = direction;
    }
    
    
    /**
     * returns the current symbol on the reel 
     * @return symbol of reel 
     */
    public Symbol getCurrentSymbol() {
        return symbols[currentIndex];
    }
    
    /**
     * returns current index of the reel
     * @return currentIndex
     */
    public int getCurrentIndex() {
        return currentIndex;
    }
    
    /**
     * turns the reel by the direction specified when creating the reel 
     */
    public void turn(){
        if (currentIndex + direction == MAX_ROLLOEVER){
            currentIndex = 0;
        }
        else if (currentIndex + direction == -1){
            currentIndex = HIGHEST_SYMBOL;
        }
        else {
            currentIndex = currentIndex + direction;
        }
    }
    
    /**
     * returns the current index and symbol of reel as well as all the symbols in the reel
     * @return string representation of the reel 
     */
    public String toString(){
        return "Current index: " + currentIndex 
               + "\nCurrent symbol: " + SYMBOL_NAMES[currentIndex] 
               + "\nSymbol 0: " + symbols[0].toString()
               + "\nSymbol 1: " + symbols[1].toString()
               + "\nSymbol 2: " + symbols[2].toString()
               + "\nSymbol 3: " + symbols[3].toString()
               + "\nSymbol 4: " + symbols[HIGHEST_SYMBOL].toString()
               + "\n";
         
    }
  
}
