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
public class FactoryPatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * ShapeFactory shapeFactory = new ShapeFactory(); //get an object of
         * Circle and call its draw method. Shape shape1 =
         * shapeFactory.getShape("CIRCLE"); //call draw method of Circle
         * shape1.draw(); //get an object of Rectangle and call its draw method.
         * Shape shape2 = shapeFactory.getShape("RECTANGLE"); //call draw method
         * of Rectangle shape2.draw(); //get an object of Square and call its
         * draw method. Shape shape3 = shapeFactory.getShape("SQUARE"); //call
         * draw method of circle
        shape3.draw();
         */

        /*Shape myShape = new Rectangle(2,3);
        myShape.draw();
        ShapeFormFactory factory = new ShapeFormFactory();
        Shape newShape = factory.shapeFrom(myShape);*/
        
        
        ShapeFormFactory factory = new ShapeFormFactory();

        
        Shape shape1 = new Square();
        Shape newShape1 = factory.shapeFrom(shape1);
        
        System.out.println(newShape1.toString());
        
        shape1.draw();
        
        
        Shape shape2 = new Rectangle();
        Shape newShape2 = factory.shapeFrom(shape2);
        System.out.println(newShape2.toString());

        shape2.draw();
        
        Shape shape3 = new Circle();
        Shape newShape3 = factory.shapeFrom(shape3);
        System.out.println(newShape3.toString());
        
        shape3.draw();
    }
}
