/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.view;

import flimindustrymangement.controllers.ControllerInterface;
import flimindustrymangement.model.Actor;
import flimindustrymangement.model.Flim;
import flimindustrymangement.model.Model;
import java.util.List;

/**
 *
 * @author alumne
 */
public class FlimView extends Menu implements ViewInterface {
   
     private final ControllerInterface controller;
     private final Model model;
     private final String [] options = {"Back", "List all flims", "Find flim by title", "Add a new flim", "Modify a flim", "Delete a flim"};
     
    
    public FlimView(ControllerInterface controller, Model model ) {
        super("Flim Menu");
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
        } while (!exit);     }




}
