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
public class Square implements Shape {
    
    int width;

    public Square() {
        
    }
    
    public Square(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Square{" + "width=" + width + '}';
    }
    
    

    @Override
    public void draw() {
        System.out.println("Square.draw() method.");
    }
}

