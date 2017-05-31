/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement;

import flimindustrymangement.controllers.ControllerFactory;
import flimindustrymangement.controllers.ControllerInterface;
import flimindustrymangement.controllers.MainController;
import flimindustrymangement.model.Model;

/**
 *
 * @author alumne
 */
public class FlimIndustryMangement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Model model = new Model();
        ControllerInterface mainController = (MainController) ControllerFactory.loadController("main",model);
        mainController.start();
    }
    
}
