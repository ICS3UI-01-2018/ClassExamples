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
public class UbbiDubbiTranslator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Get a word to translate into UbbiDubbi
        String word = input.nextLine();
        
        // get the length of a String
        int wordLength = word.length();
        
        // make a spot for translated word
        String translate = "";
        
        // walk through each character
        for(int i = 0; i < wordLength; i++){
            // store the letter at position i
            char letter = word.charAt(i);
            // is it a vowel?
            if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
                // add ub to the translated word
                translate = translate + "ub";
            }
            // add the letter to the translated word
            translate = translate + letter;
        }
        
        // output the translated word
        System.out.println(word + " in UbbiDubbi is " + translate);
       
        
        
    }
    
}
