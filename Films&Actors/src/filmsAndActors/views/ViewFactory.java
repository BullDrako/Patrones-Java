/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.views;


import filmsAndActors.controllers.ControllerInterface;
import filmsAndActors.model.Model;

/**
 *
 * @author Edgar
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
                    case "film": 
                        instance = (FilmView)  new FilmView(controller,model);
                    break;
        }
        
        return instance;
    }

 
    
    
}


