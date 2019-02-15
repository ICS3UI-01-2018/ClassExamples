/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;

/**
 * Example of Java Input and Output
 * @author lamon
 */
public class IOExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Output text to the screen on a new line
        System.out.println("Hello world");
        
        // prints text but waits at the end of the line
        System.out.print("Hello");
        System.out.print("World");
        // finish a line or print a blank line
        System.out.println();
        
        // create a string variable for name
        String name = "Mr. Lamont";
        // say hello to the person
        System.out.println("Hello " + name);
        
        // Create a scanner for input
        Scanner input = new Scanner(System.in);
        
        // change the name variable
        name = "Fred";
       
        System.out.println(name);
        
        
        // scans in the user's year of birth
        System.out.println("Please enter the year you were born");
        int birthYear = input.nextInt();
       
        // calculate how old they are
        int age = 2019 - birthYear;
        
        System.out.println("You could be " + age + " years old.");
        
        //  +  -  addition
        //  -  - subtraction
        //  *  - multiplication
        //  /  - division   5/2.0 = 2.5  but 5/2=2
        //  %  - remainder (modulus)  5%2 = 1
        // Math.pow(base, exponent) - powers
        // Math.sqrt(number) - square roots
    }

    
}
