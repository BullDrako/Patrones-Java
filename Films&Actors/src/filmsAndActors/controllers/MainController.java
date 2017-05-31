/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.controllers;

import filmsAndActors.model.Model;
import filmsAndActors.views.MainView;
import filmsAndActors.views.ViewFactory;
import filmsAndActors.views.ViewInterface;

/**
 *
 * @author Edgar
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

    private void filmMenu() {
       FilmController filmMenu;
       filmMenu = new FilmController(model);
       filmMenu.start();
    }

    @Override
    public void processRequest(String optionSelected) {
        
            switch (optionSelected) {
                case "1": //list all
                    filmMenu();
                    break;
                case "2": //actor a by name
                    actorMenu();
                    break;
                default: //unknown option.
                    break;
            } 

    }

   
    
}
