/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.controllers;

import practicapuntuablepatrons.model.Model;

/**
 *
 * @author Edgar
 */
public class ControllerFactory {

    public static ControllerInterface loadController(String type, Model model) {

        ControllerInterface instance = null;

        switch (type) {
            case "main":
                instance = (MainController) new MainController(model);
                break;
            case "actor":
                instance = (ActorController) new ActorController(model);
                break;
            case "film":
                instance = (FilmController) new FilmController(model);
                break;
        }
        return instance;
    }

}
