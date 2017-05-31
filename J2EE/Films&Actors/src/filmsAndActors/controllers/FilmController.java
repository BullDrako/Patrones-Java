/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.controllers;

import filmsAndActors.model.Film;
import filmsAndActors.model.Model;
import filmsAndActors.views.ViewFactory;
import filmsAndActors.views.ViewInterface;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class FilmController implements ControllerInterface {
    
    private ViewInterface view;
    private Model model;

    public FilmController(Model model) {
        this.model = model;
        view = ViewFactory.loadViews("film",this, model);
       
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
                default: //unknown option.
                    break;
            }
    }
    
    private void inputData() {
        model.addFilm(new Film("Fast and Furious", "Rob Cohen", "A race film", 2001));
        model.addFilm(new Film("Avatar", "James Cameron", "a Science fictions film", 2009));
        model.addFilm(new Film("The expendables", "Sylvester Stallone", "An action film", 2010));
    }

    private void listAll() {
        List<Film> entityList =  (List<Film>) model.findAllFilms();
        if (entityList!=null){
            view.showFilmTable(entityList);  
        }else{
            view.showMessage("Error,films not found");
        }
    }

    private void searchByName() {
        String name = view.inputString("Input name:");
        Film f = model.findFilm(new Film(name));
        if(f != null)
            view.showFilmForm(f);
        else
            view.showMessage("Film not found");
    }

    private void create() {
        Film film = view.inputFilm();
        Boolean result = model.addFilm(film);
        if(result == true) {
            view.showMessage("Film successfully added");
        } else {
            view.showMessage("Film not valid");
        }
    }

    private void modify() {
        
        String title = view.inputString("Input title:");
        Film f = model.findFilm(new Film(title));
        if(f == null) {
            view.showMessage("Wrong Film not found");
        } else {
            view.showMessage("Film to modify" + f.toString()+"\n");
            String shure = view.inputString("YOU ARE sure to modify a Film? Y/N \n");
            if(shure.equalsIgnoreCase("y")) {
                String director = view.inputString("Input director:");
                String description = view.inputString("Input description:");
                int year = view.inputInt("Input year:");
                Film modifiedFilm =new Film(f.getTitle(),director,description,year);
                if(model.updateFilm(modifiedFilm)){
                    view.showMessage("Film successfully modified");
                } else
                    view.showMessage("Film not modified");
            }else if(shure.equalsIgnoreCase("n")) {
                view.showMessage("Film not modified");
            }
        }    
    }

    private void delete() {
        
        String name = view.inputString("Input name:");
        Film f = model.findFilm(new Film(name));
        if(f == null) {
            view.showMessage("Wrong Film not found");
        } else {
            view.showMessage("Film to delete" + f.toString() + "\n");
            String shure = view.inputString("You are sure to delete a Film? Y/N \n");
            if(shure.equalsIgnoreCase("y")) {
                if(model.deleteFilm(f))
                    view.showMessage("Film successfully deleted");
                else
                    view.showMessage("Wrong Film not deleted");
            }else if(shure.equalsIgnoreCase("n")) {
                view.showMessage("Film not deleted");
            }
        }
    }

   

 
}
