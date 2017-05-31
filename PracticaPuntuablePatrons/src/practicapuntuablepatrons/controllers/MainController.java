/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.controllers;

import practicapuntuablepatrons.model.Model;
import practicapuntuablepatrons.views.MainView;
import practicapuntuablepatrons.views.ViewFactory;
import practicapuntuablepatrons.views.ViewInterface;

/**
 *
 * @author alumne
 */
public class MainController implements ControllerInterface {

    private Model model;
    private ViewInterface view;

    public MainController(Model model) {
        this.model = model;
        view = (MainView) ViewFactory.loadViews("main", this, model);
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
            case "1": 
                filmMenu();
                break;
            case "2": 
                actorMenu();
                break;
            default:
                break;
        }
    }
}
