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
public class PigLatinTranslator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // get a word to translate
        String word = input.nextLine();
        
        // crate a new translated word string
        String translate = "";
        
        // get the length of the word
        int wordLength = word.length();
        
        // go through each letter
        for(int i = 0; i < wordLength; i++){
            // get letter at position i
            char letter = word.charAt(i);
            
            String vowels = "aeiouAEIOU";
            // is the letter in the vowel string
            if(vowels.indexOf(letter) >= 0){
                // is the vowel at the start
                if(i == 0){
                    translate = word + "way";
                }else{
                    
                }
            }
            
        }
    }
    
}
