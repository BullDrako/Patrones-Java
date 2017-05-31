/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors;


import filmsAndActors.controllers.ControllerFactory;
import filmsAndActors.controllers.ControllerInterface;
import filmsAndActors.controllers.MainController;
import filmsAndActors.model.Model;
/**
 *
 * @author Edgar
 */
public class FilmsActors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model model = new Model();
        ControllerInterface mainController = (MainController) ControllerFactory.loadController("main",model);
        mainController.start();
    }
    
}
