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
public class ArrayExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // how big is the list of items
        System.out.println("How many items are on the grocery list?");
        int numItems = input.nextInt();
        // clear the input buffer
        input.nextLine();
        
        // create the array to store item names
        String[] groceryNames = new String[numItems];
        
        // use a for loop to go through each item
        for(int i = 0; i < numItems; i++){
            // get the name for each item
            System.out.println("Please enter a name of an item:");
            groceryNames[i] = input.nextLine();
        }
        
        // some blank lines
        System.out.println("");
        System.out.println("");
        
        System.out.println("Your shopping list is:");
        for (int i = 0; i < groceryNames.length; i++) {

            System.out.println("- " + groceryNames);
            
        }
        
        
        
    }
    
}
