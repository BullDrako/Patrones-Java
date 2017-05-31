/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.view;

import flimindustrymangement.controllers.ControllerInterface;
import flimindustrymangement.model.Model;

/**
 *
 * @author alumne
 */
public class ViewFactory {
    
    /**
     *
     * @param type
     * @param controller
     */
     public static ViewInterface loadViews(String type,ControllerInterface controller,Model model ) {
         ViewInterface instance = null;
         
               switch (type) {
                    case "main": 
                        instance =(MainView) new MainView(controller,model);
					 
                    break;
                    case "actor": 
                        instance = (ActorView)  new ActorView(controller,model);
				
                    break;
                    case "flim": 
                        instance = (FlimView)  new FlimView(controller,model);
                    break;
        }
        
        return instance;
    }

 
    
    
}
