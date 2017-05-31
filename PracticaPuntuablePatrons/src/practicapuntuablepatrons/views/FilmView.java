/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.views;

import java.util.List;
import java.util.Scanner;
import practicapuntuablepatrons.controllers.ControllerInterface;
import practicapuntuablepatrons.model.Film;
import practicapuntuablepatrons.model.Model;

/**
 *
 * @author alumne
 */
public class FilmView extends Menu implements ViewInterface {

    private ControllerInterface controller;
    private Model model;
    private Menu menu;

    private final String[] options = {"Back", "List all films", "Find film by title", "Add a new film", "Modify a film", "Delete a film"};

    public FilmView(ControllerInterface controller, Model model) {
        super("Flim Menu");
        this.controller = controller;
        this.model = model;
        for (String opt : options) {
            this.add(new Option(opt));
        }
    }

    @Override
    public void doInteract() {
        boolean exit = false;
        String optSelected;
        do {
            display();
            optSelected = getUserOption();
            switch (optSelected) {
                case "0"://back
                    exit = true;
                    break;
                default:
                    controller.processRequest(optSelected);
                    break;
            }
        } while (!exit);
    }
}
