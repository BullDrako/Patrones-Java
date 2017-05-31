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
public class MainView extends Menu implements ViewInterface {
    
    
     private final ControllerInterface controller;
     private final Model model;
     private final String [] options = {"Exit", "Flims", "Actors"};
     
    
    public MainView(ControllerInterface controller, Model model ) {
        super("Main Menu");
        this.controller = controller;
        this.model = model;
        for (String opt: options) {
            this.add(new Option(opt));
        }
    }

    @Override
    public void doInteract() {
        boolean exit = false;
        String optionSelected;
        do {
            display();
            optionSelected = getUserOption();
            switch (optionSelected) {
                case "0"://back
                    exit = true;
                    break;
                default: //unknown option.
                    controller.processRequest(optionSelected);
                    break;
            } 
        } while (!exit); 
        
    }

  
 
}