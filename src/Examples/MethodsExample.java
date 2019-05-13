/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

/**
 *
 * @author lamon
 */
public class MethodsExample {

    // procedure type method 
    // (does an action)
    public static void sayHello(){
        System.out.println("Hello User");
    }
    
    public static void sayHello(String name){
        System.out.println("Hello " + name);
    }
    
    
    // function type method
    // (returns an answer back)
    public static double rectangleArea(double length, double width){
        // calculate the area
        double area = length*width;
        // give back the answer
        return area;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sayHello();
        sayHello();
        
        String firstName = "Person";
        sayHello(firstName);
        sayHello("Lamont");
        
        double answer = rectangleArea(2.5,10.75);
        System.out.println(answer);
    }
    
}
