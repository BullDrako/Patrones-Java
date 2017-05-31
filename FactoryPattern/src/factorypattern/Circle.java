/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorypattern;

/**
 *
 * @author Edgar
 */
public class Circle implements Shape {
    
    int radius;
    
     public Circle(){
        
    }
    
    public Circle(int radius){
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }
    
    
    

    @Override
    public void draw() {
        System.out.println("Circle.draw() method.");
    }
}



