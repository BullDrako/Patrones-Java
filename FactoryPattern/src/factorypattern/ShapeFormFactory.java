/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorypattern;

import java.util.Scanner;

/**
 *
 * @author Edgar
 */
public class ShapeFormFactory {
    
    public Shape shapeFrom(Shape shape) {

        Shape instance = null;
        Class c = shape.getClass();
        String className = c.getSimpleName();

        switch (className) {
            case "Square":
                instance = SquareForm((Square) shape);
                break;
            case "Circle":  
                instance = CircleForm((Circle) shape);
                break;
            case "Rectangle":
               instance = RectangleForm((Rectangle) shape);
                break;

        }
        return instance;
    }

    private Circle CircleForm(Circle shape) {
        
        System.out.println(shape.toString());
        
        Scanner sc = new Scanner(System.in);
 
        Circle c;
       
        int radius;

        System.out.println("Introduce radio");
        radius = Integer.parseInt(sc.nextLine());

        c = new Circle(radius);

    
        return c;
    }

    private Square SquareForm(Square shape) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println(shape.toString());
        
        Square s;
        int width;

        System.out.println("Introduce ancho Cuadrado");
        width = Integer.parseInt(sc.nextLine());

        s = new Square(width);
        
        

        return s;
    }

    private Rectangle RectangleForm(Rectangle shape) {

        System.out.println(shape.toString());
        
        Scanner sc = new Scanner(System.in);
        
        Rectangle r;

        int width;
        int height;

        System.out.println("Introduce ancho Rectangulo");

        width = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce alto Rectangulo");

        height = Integer.parseInt(sc.nextLine());

        r = new Rectangle(width, height);
        
        

        return r;

    }
}

    

