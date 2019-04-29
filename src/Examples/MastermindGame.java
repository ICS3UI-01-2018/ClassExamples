/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;

/**
 *
 * @author lamon
 */
public class MastermindGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner input = new Scanner(System.in);
        // get code from code maker
        System.out.println("Please enter a 4 character code using only B and W");
        String code = input.nextLine();
        // check for valid code
        while (code.length() != 4) {
            System.out.println("The code must be 4 in length, try again!");
            code = input.nextLine();
        }

        // put a bunch of blanks
        for(int i = 0; i < 80; i++){
            System.out.println();
        }
        
        while (true) {
            // player tries to guess the code
            System.out.println("Please enter your guess for the code");
            String guess = input.nextLine();
            // is the guess correct
            if (guess.equals(code)) {
                System.out.println("Congratulations!");
                break;
            } else {
                // break up code and guess into arrays
                char[] codeArray = code.toCharArray();
                char[] guessArray = guess.toCharArray();

                // count number of correct characters
                int correct = 0;
                for (int i = 0; i < code.length(); i++) {
                    // if the guess position is EXACTLY correct
                    if (codeArray[i] == guessArray[i]) {
                        // adding a correct guess
                        correct++;
                        // flag correct spots to not count a second time
                        codeArray[i] = 'X';
                        guessArray[i] = 'X';
                    }
                }

                // count the almost correct pegs
                int almost = 0;
                // for each of the guess code
                for (int i = 0; i < guess.length(); i++) {
                    // check if it is a code letter
                    if (guessArray[i] != 'X') {
                        // go through code to look for it
                        for (int j = 0; j < codeArray.length; j++) {
                            // if character is found
                            if (guessArray[i] == codeArray[j]) {
                                // increase the almost count
                                almost++;
                                // flag that it is found
                                codeArray[j] = 'X';
                                break;
                            }
                        }
                    }
                }

                // let the user know
                System.out.println("You have " + correct + " guess exact");
                System.out.println("You have " + almost + " colours correct");
                System.out.println("Guess again");
            }
        }
    }

}
