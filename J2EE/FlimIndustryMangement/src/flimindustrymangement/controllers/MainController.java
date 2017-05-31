/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.controllers;

import flimindustrymangement.model.Model;
import flimindustrymangement.view.FlimView;
import flimindustrymangement.view.MainView;
import flimindustrymangement.view.ViewFactory;
import flimindustrymangement.view.ViewInterface;

/**
 *
 * @author jashan
 */
public class MainController implements ControllerInterface{
    
    private ViewInterface view;
    private  Model model;

    public MainController(Model model) {
        this.model = model;
        view = (MainView) ViewFactory.loadViews("main",this, model);
    }
    
    @Override
    public void start() {
        view.doInteract();
        
    }

    private void actorMenu() {
       ActorController actorMenu;
       actorMenu = new ActorController(model);
       actorMenu.start();
    }

    private void flimMenu() {
       FlimController flimMenu;
       flimMenu = new FlimController(model);
       flimMenu.start();
    }

    @Override
    public void processRequest(String optionSelected) {
        
            switch (optionSelected) {
                case "1": //list all
                    flimMenu();
                    break;
                case "2": //actor a by name
                    actorMenu();
                    break;
                default: //unknown option.
                    break;
            } 

    }

   
    
}
