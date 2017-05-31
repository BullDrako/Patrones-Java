/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.controllers;

import java.util.List;
import practicapuntuablepatrons.model.Film;
import practicapuntuablepatrons.model.Model;
import practicapuntuablepatrons.views.FilmView;
import practicapuntuablepatrons.views.ViewFactory;
import practicapuntuablepatrons.views.ViewInterface;

/**
 *
 * @author alumne
 */
public class FilmController implements ControllerInterface {

    private Model model;
    private ViewInterface view;

    public FilmController(Model model) {
        this.model = model;
        view = ViewFactory.loadViews("film", this, model);

    }

    @Override
    public void start() {
        inputData();
        view.doInteract();
    }

    @Override
    public void processRequest(String optionSelected) {
        switch (optionSelected) {
            case "1": //list all
                listAll();
                break;
            case "2": //Film a by name
                searchByName();
                break;
            case "3": //add
                create();
                break;
            case "4": //modify
                modify();
                break;
            case "5": //delete
                delete();
                break;
            default:
                break;
        }
    }

    /**
     * Insert data in film list
     */
    private void inputData() {
        model.insertFilm(new Film("Fast and Furious", "Rob Cohen", "A race film", 2001));
        model.insertFilm(new Film("Avatar", "James Cameron", "a Science fictions film", 2009));
        model.insertFilm(new Film("The expendables", "Sylvester Stallone", "An action film", 2010));
    }

    /**
     * list all films. If there are any film, shows a list. Else there aren't any film
     */
    private void listAll() {
        List<Film> entityList = (List<Film>) model.findAllFilm();
        if (entityList != null) {
            view.showFilmTable(entityList);
        } else {
            view.showMessage("Error, films not found");
        }
    }

    /**
     * Searches a film by name. If the film doesn't exit show a message
     */
    private void searchByName() {
        String name = view.inputString("Input name: ");
        Film f = model.findFilm(new Film(name));
        if (f != null) {
            view.showFilmForm(f);
        } else {
            view.showMessage("Film not found");
        }
    }

    /**
     * Create a film. First it calls the view of film and it asks the name of film, title... if the data is correct,
     * it adds a film, else the film isn't added
     */
    private void create() {
        Film film = view.inputFilm();
        Boolean result = model.insertFilm(film);
        if (result == true) {
            view.showMessage("Film successfully added");
        } else {
            view.showMessage("Film not valid");
        }
    }

    /**
     * Modify a film. First input a title of film to modify. Then it searches it. If it don't find it, the film doesn't exist,
     * if it exists it asks if you are shure to modify it. If you input "y" it modifyys the film's data.
     */
    private void modify() {

        String title = view.inputString("Input title: ");
        Film f = model.findFilm(new Film(title));
        if (f == null) {
            view.showMessage("Wrong Film not found");
        } else {
            view.showMessage("Film to modify" + f.toString() + "\n");
            String modify = view.inputString("Are you sure to modify a Film? Y/N \n");
            if (modify.equalsIgnoreCase("y")) {
                String director = view.inputString("Input director: ");
                String description = view.inputString("Input description: ");
                int year = view.inputInt("Input year: ");
                Film modifiedFilm = new Film(f.getTitle(), director, description, year);
                if (model.updateFilm(modifiedFilm)) {
                    view.showMessage("Film successfully modified");
                } else {
                    view.showMessage("Film not modified");
                }
            } else if (modify.equalsIgnoreCase("n")) {
                view.showMessage("Film not modified");
            }
        }
    }

    /**
     * Delete film. Input the title of the film to delete. Then it searches it. If it don't find it, the film doesn't exixst,
     * if it exists it asks if you are shure to delete it. If you input "y" it deletes the film's data.
     */
    private void delete() {

        String name = view.inputString("Input name:");

        Film f = model.findFilm(new Film(name));
        if (f == null) {
            view.showMessage("Wrong Film not found");
        } else {
            view.showMessage("Film to delete" + f.toString() + "\n");
            String delete = view.inputString("Are you sure to delete a Film? Y/N \n");
            if (delete.equalsIgnoreCase("y")) {
                if (model.deleteFilm(f)) {
                    view.showMessage("Film successfully deleted");
                } else {
                    view.showMessage("Wrong Film not deleted");
                }
            } else if (delete.equalsIgnoreCase("n")) {
                view.showMessage("Film not deleted");
            }
        }
    }
}
