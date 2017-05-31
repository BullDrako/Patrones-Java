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
public class ActorView extends Menu implements ViewInterface {
     
     private final ControllerInterface controller;
     private final Model model;
     private final String [] options = {"Back", "List all actors", "Find actor by name", "Add a new actor","Modify a actor", "Delete a actor"};
     
    
    public ActorView(ControllerInterface controller, Model model ) {
        super("Main view");
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