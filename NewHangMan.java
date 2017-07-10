package sixthclass;

import java.util.*;

/**
 * Created by boruto on 6/23/17.
 */
public class NewHangMan
{
    private int life=3; //variable used for number of chances
    private String word="education"; //word used for guessing
    private char inputChar; //used to store character guessed by the user
    private Set<Character> guessedChar = new HashSet<>(); //used for storing all the guessed characters; no duplicate characters
    public Map<Integer, Character> rightGuess = new HashMap<Integer, Character>(); //used for storing correct guess (i.e character) along with their index value in string word

    ///////////////////////////////////////////////////////////
    /////method for setting character guessed by the user//////
    ///////////////////////////////////////////////////////////
    public void setInputChar(char c) {
        inputChar = c;
    }

    ////////////////////////////////////////////////
    /////method for returning number of chances/////
    ////////////////////////////////////////////////
    public int getLife(){
        return life;
    }

    ////////////////////////////////////////////////////
    /////method for adding guessed character in set/////
    ////////////////////////////////////////////////////
    private void setGuessedChar(char c){
        guessedChar.add(c);
    }

    ///////////////////////////////////////////////////////////////////////////
    /////method for checking whether guessed character is already in a set/////
    ///////////////////////////////////////////////////////////////////////////
    private boolean checkGuessedChar(char c){
        if(guessedChar.contains(c)){
            return true;
        }
        else{
            return false;
        }
    }

    /////////////////////////////////////////////////
    /////method for displaying the word sequence/////
    /////////////////////////////////////////////////
    public void displayWord(){
        System.out.println();
        for(int i=0;i<word.length();i++){
            if(rightGuess.get(i)==null){
                System.out.print("_");

            }
            else{
                System.out.print(rightGuess.get(i));
            }
            System.out.print(" ");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////
    /////This method checks whether the hidden word contains the input character./////
    /////If it contains, then the input_character along with its index value is //////
    /////stored in the rightGuess(i.e Map<key,value>).And it also store all the///////
    /////input_characters(right and wrong characters) in guessedChar(i.e. Set).///////
    /////////If the user guess is wrong then the life (i.e no. of chance is///////////
    ////////////////////////////////decremented by 1//////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////
    public void check(){
        String tempChar = String.valueOf(inputChar);

        if(!checkGuessedChar(inputChar)) {
            setGuessedChar(inputChar);
            if (word.contains(tempChar)) {
                for (int i = 0; i < word.length(); i++) {
                    if (inputChar == word.charAt(i)) {
                        //index.add(i);
                        rightGuess.put(i, word.charAt(i));
                    }
                }
            } else {
                life--;
                System.out.println("\nSorry! '"+inputChar+"' is a wrong guess");
            }
        }
        else{
            System.out.println("You have already guessed '"+inputChar+"'");
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    /////This method check whether the user has successfully guessed all the/////
    //////////////////missing characters in a hidden word////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    public boolean gameStatus() {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (rightGuess.get(i) != null) {
                counter++;
            }
        }
        if (counter == word.length()) {
            return true;
        }
        else{
            return false;
        }
    }

}//end of class
