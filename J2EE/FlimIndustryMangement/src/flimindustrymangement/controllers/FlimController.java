/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.controllers;

import flimindustrymangement.model.Flim;
import flimindustrymangement.model.Model;
import flimindustrymangement.view.ViewFactory;
import flimindustrymangement.view.ViewInterface;
import java.util.List;

/**
 *
 * @author Jashan
 */
public class FlimController implements ControllerInterface {
    
    private ViewInterface view;
    private Model model;

    public FlimController(Model model) {
        this.model = model;
        view = ViewFactory.loadViews("flim",this, model);
       
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
                case "2": //Flim a by name
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
        model.addFlim(new Flim("Om","berta","Pelicula de sciencia ficcion",2007));
        model.addFlim(new Flim("DDLJ","Aditya","Pelicula de Drama, comedia",1995));
        model.addFlim(new Flim("K3G","Karan","Pelicula de Drama Familiar",2001));
    }

    private void listAll() {
        List<Flim> entityList =  (List<Flim>) model.findAllFlims();
        if (entityList!=null){
            view.showFlimTable(entityList);  
        }else{
            view.showMessage("Error,flims not found");
        }
    }

    private void searchByName() {
        String name = view.inputString("Input name:");
        Flim f = model.findFlim(new Flim(name));
        if(f != null)
            view.showFlimForm(f);
        else
            view.showMessage("Flim not found");
    }

    private void create() {
        Flim flim = view.inputFlim();
        Boolean result = model.addFlim(flim);
        if(result == true) {
            view.showMessage("Flim successfully added");
        } else {
            view.showMessage("Flim not valid");
        }
    }

    private void modify() {
        
        String title = view.inputString("Input title:");
        Flim f = model.findFlim(new Flim(title));
        if(f == null) {
            view.showMessage("Wrong Flim not found");
        } else {
            view.showMessage("Flim to modify" + f.toString()+"\n");
            String shure = view.inputString("YOU ARE sure to modify a Flim? Y/N \n");
            if(shure.equalsIgnoreCase("y")) {
                String director = view.inputString("Input director:");
                String description = view.inputString("Input description:");
                int year = view.inputInt("Input year:");
                Flim modifiedFlim =new Flim(f.getTitle(),director,description,year);
                if(model.updateFlim(modifiedFlim)){
                    view.showMessage("Flim successfully modified");
                } else
                    view.showMessage("Flim not modified");
            }else if(shure.equalsIgnoreCase("n")) {
                view.showMessage("Flim not modified");
            }
        }    
    }

    private void delete() {
        
        String name = view.inputString("Input name:");
        Flim f = model.findFlim(new Flim(name));
        if(f == null) {
            view.showMessage("Wrong Flim not found");
        } else {
            view.showMessage("Flim to delete" + f.toString() + "\n");
            String shure = view.inputString("You are sure to delete a Flim? Y/N \n");
            if(shure.equalsIgnoreCase("y")) {
                if(model.deleteFlim(f))
                    view.showMessage("Flim successfully deleted");
                else
                    view.showMessage("Wrong Flim not deleted");
            }else if(shure.equalsIgnoreCase("n")) {
                view.showMessage("Flim not deleted");
            }
        }
    }

   

 
}
