package sixthclass;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boruto on 6/13/17.
 */
public class HangManTest {
    private int life;
    private String word = "letter";
    private char guessedCharacter;
    private int[] correctIndex=null;
    //private Map<Integer,String> matchedCharacter = new HashMap<>();


    public int[] getCorrectIndex(){
        return correctIndex;
    }
    public void setLife(int life){
        this.life = life;
    }

    public int getLife(){
        return life;
    }

    public void decrementLife(){
        life = life--;
    }

    public void setGuessedCharacter(char guessedCharacter){
        this.guessedCharacter = guessedCharacter;
    }

    public char getGuessedCharacter(){
        return guessedCharacter;
    }


    public void displayBlank(){

            for (int i = 0; i < word.length(); i++){
                if(i==correctIndex[i]){
                    System.out.println(word.charAt(i));
                }
                else{
                    System.out.println("_");
                }
            }
    }

    /*public void setMatchedCharacter(){
        matchedCharacter.
    }
*/
    public void checkCharacter(){
        int j=0;

        for (int i=0;i<word.length();i++) {
            if (guessedCharacter == word.charAt(i)){
                correctIndex[j] = i;
                j++;
            }

        }
    }
}

