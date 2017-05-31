/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons;

import practicapuntuablepatrons.controllers.ControllerFactory;
import practicapuntuablepatrons.controllers.ControllerInterface;
import practicapuntuablepatrons.controllers.MainController;
import practicapuntuablepatrons.model.Model;

/**
 *
 * @author alumne
 */
public class PracticaPuntuablePatrons {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Model model = new Model();
        ControllerInterface mainController = (MainController) ControllerFactory.loadController("main",model);
        mainController.start();
    }
    
    
}
