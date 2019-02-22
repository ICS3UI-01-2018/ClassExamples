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
public class Conditions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a scanner for input
        Scanner input = new Scanner(System.in);
        // ask for an integer between 1 and 10
        System.out.println("Please enter a number between 1 and 10");
        int number = input.nextInt();
        
        // check if the number is between 1 and 10
        if(number < 1){
            System.out.println("Hey! Between 1 and 10!");
        }else if(number > 10){
            System.out.println("Hey! Between 1 and 10!");
        }else{
            System.out.println("Good job!");
        }
        
        // how to combine multiple checks
        if(number >= 1 && number <= 10){
            System.out.println("You can follow directions!");
        }else if(number < 1 || number > 10){
            System.out.println("You can't follow instructions!");
        }
        
        if(number == 7){
            System.out.println("A lucky number...");
        }
        
        // flush the input to switch to Strings from numbers
        input.nextLine();
        
        // comparing Strings
        System.out.println("Please enter a word");
        String word = input.nextLine();
        if(word.equals("hello")){
            System.out.println("Hi there!");
        }else if(word.equalsIgnoreCase("hello")){
            System.out.println("Greetings");
        }
    }
    
}
