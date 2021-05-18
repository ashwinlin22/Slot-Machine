import java.util.*;


/**
 * class represents slot machine with 3 reels 
 * @author Ashwin Lingaraj
 */
public class SlotMachine {
    
    /** number of tokens inserted to bet */
    public static final int BET_AMOUNT = 5;
    
    /** number of tokens player starts with */
    public static final int INITIAL_TOKENS = 50;
    
    /** token bonus for all symbols being the same */
    public static final int SAME_MULTIPLIER = 5;
    
    /** array stores reels for slot machine */
    private Reel[] reels;
    
    /** number of tokens the player has */
    private int numberOfTokens;
    
    /** represents the status of the game */
    private String status;
    
    /** random object used to draw random random numbers */
    private Random rand;
    
    /** 
     * constructor that creates slot machine object 
     * @param seed for random number 
     */
    public SlotMachine(int seed){
        
        numberOfTokens = INITIAL_TOKENS;
        reels = new Reel[3];
        reels[0] = new Reel(1);
        reels[2] = new Reel(1);
        reels[1] = new Reel(-1);
        status = "Pull Lever To Begin";
        
        if (seed < 0){
            rand = new Random();
        }
        
        else if (seed >= 0){
            rand = new Random(seed);
        }
        
    } 
    
    /**
     * inserts 5 tokens to play and checks if you have enough tokens remaining to play
     * @throws IllegalStateException if the number of tokens left is less than the bet amount 
     */
    public void makeBet(){
        if (numberOfTokens >= BET_AMOUNT){
            numberOfTokens = numberOfTokens - BET_AMOUNT;
        }
        else if (numberOfTokens < BET_AMOUNT){
            throw new IllegalStateException("Not enough tokens for bet");
        }
    }
    
    /**
     * gets the number of tokens you have left
     * @return numberOfTokens
     */
    public int getNumberOfTokens(){
        return numberOfTokens;
    }
    
    /**
     * returns the status of the slot machine
     * @return status
     */
    public String getStatus(){
        return status;
    }
    
    /**
     * returns the current index of the symbol in the reel specified by the index
     * @param index of reel
     * @return index of symbol of the reel specified
     */
    public int getCurrentIndexOfReel(int index){
        return reels[index].getCurrentIndex();
    }
    
    /** 
     * turns one of the three reels randomly
     */
    public void turnReel(){
        int randomIndex = rand.nextInt(3);
        reels[randomIndex].turn();
    }
    
    /**
     * checks if symbols on reels are equal
     * updates number of tokens and status after spin
     */
    public void determineOutcome(){
        if (reels[0].getCurrentSymbol().equals(reels[1].getCurrentSymbol()) && 
            reels[1].getCurrentSymbol().equals(reels[2].getCurrentSymbol())){
            int numTokensWon = (reels[0].getCurrentSymbol().getValue()) * SAME_MULTIPLIER;
            numberOfTokens = numberOfTokens + numTokensWon;
            status = "3 " + reels[0].getCurrentSymbol().getName() + "! " 
                     + numTokensWon + " Tokens!";
        }
        else if (reels[0].getCurrentSymbol().equals(reels[1].getCurrentSymbol())) {
            int numTokensWon = (reels[0].getCurrentSymbol().getValue()) * 2;
            numberOfTokens = numberOfTokens + numTokensWon;
            status = "2 " +  reels[0].getCurrentSymbol().getName() + "! " + numTokensWon 
                     + " Tokens!";
        
        }
        else if (reels[1].getCurrentSymbol().equals(reels[2].getCurrentSymbol())){
            int numTokensWon = (reels[1].getCurrentSymbol().getValue()) * 2;
            numberOfTokens = numberOfTokens + numTokensWon;
            status = "2 " +  reels[1].getCurrentSymbol().getName() + "! " + numTokensWon 
                     + " Tokens!";
        }
        else if (reels[0].getCurrentSymbol().equals(reels[2].getCurrentSymbol())) {
            int numTokensWon = (reels[2].getCurrentSymbol().getValue()) * 2;
            numberOfTokens = numberOfTokens + numTokensWon;
            status = "2 " +  reels[2].getCurrentSymbol().getName() + "! " + numTokensWon 
                     + " Tokens!";
        }
        else {
            status = "You Lose";
        }
    }
    

}