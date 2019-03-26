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
public class OtherStringMEthods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String word = input.nextLine();
        word = word.replace("e","3");
        boolean endsWithTH = word.endsWith("th");
        if(endsWithTH){
            
        }
        System.out.println(word);
    }
    
}
