package sixthclass;

import java.util.Scanner;

/**
 * Created by boruto on 6/13/17.
 */
public class HangManMain {
    public static void main(String[] args) {
        NewHangMan newHangMan = new NewHangMan(); //object
        Scanner scanner = new Scanner(System.in);

        int life = newHangMan.getLife();
        String input;
        char inputChar;
        newHangMan.displayWord();
        while (life>0){

            System.out.println("You have "+life+" chances left");
            System.out.println("Enter your guess! ");
            input = scanner.next();
            inputChar = input.charAt(0);
            newHangMan.setInputChar(inputChar);
            newHangMan.check();
            newHangMan.displayWord();
            if(newHangMan.gameStatus()){
                System.out.println("\nYou Win! Thank you for playing");
                break;
            }
            life = newHangMan.getLife();

        }
        if(life==0) {
            System.out.println("You have " + life + " chance left");
            System.out.println("You Lose! Game Over");
        }
    }
}
