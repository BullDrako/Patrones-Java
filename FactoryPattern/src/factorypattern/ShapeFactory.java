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
public class ShapeFactory {
    //use getShape method to get object of type shape 

    public Shape getShape(String shapeType) {
        Shape instance = null;
        if (shapeType == null) {
            instance = null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            instance = new Circle();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            instance = new Rectangle();

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            instance = new Square();
        }
        return instance;
    }
    
}

    

