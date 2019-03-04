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
public class LoopsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // get a number from the user
        System.out.println("Please enter a number between 1 and 10");
        int number = input.nextInt();
        
        // check if number is invalid
        while(number < 1 || number > 10){
            // grab a new number
            System.out.println("Please try again");
            number = input.nextInt();
        }
        
        // count up to 10
        int count = 0;
        // loop as long as count less than 10
        while(count < 10){
            System.out.println(count);
            // increases count by 1
            count = count + 1;
        }
        
        // blank lines
        System.out.println("");
        System.out.println("");
        
        // stopping a loop from the inside
        // infinite loop
        while(true){
            // get a number
            System.out.println("Enter a number between 1 and 10");
            number = input.nextInt();
            // check if number is valid
            if(number >= 1 && number <= 10){
                // stop the loop
                break;
            }
        }
        
        // blank lines
        System.out.println("");
        System.out.println("");
        
        // do-while used to countdown
        count = 10;
        do{
            // outputs the number
            System.out.println(count);
            // counts down 1
            count = count - 1;
        }while(count > 0);
        
        // blank lines
        System.out.println("");
        System.out.println("");
        
        // the for loop!
        for(int num = 0; num < 10; num++
                ){
            System.out.println(num);
        }
        
    }
    
}
