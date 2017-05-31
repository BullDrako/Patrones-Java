/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.controllers;


import java.util.List;

import filmsAndActors.model.Actor;
import filmsAndActors.model.Model;
import filmsAndActors.views.ViewFactory;
import filmsAndActors.views.ViewInterface;

/**
 *
 * @author Edgar
 */
public class ActorController implements ControllerInterface {
    
    private ViewInterface view;
    private Model model;

    public ActorController(Model model) {
        this.model = model;
         view = ViewFactory.loadViews("actor",this, model);
    }
    
    @Override
    public void start() {
       inputData(); 
       view.doInteract();
    }
    
    @Override
    public void processRequest(String optionSelected) {
           switch (optionSelected) {
                 /*case "0": //Back menu
                    exit = true;
                    break;*/
                case "1": //list all
                    listAll();
                    break;
                case "2": //actor a by name
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
        model.addActor(new Actor("Vin Diesel", 1967));
        model.addActor(new Actor("Matt Damon", 1970));
        model.addActor(new Actor("Jason Statham", 1967));
    }

    private void listAll() {
         List<Actor> entityList =  (List<Actor>) model.findAllActors();
         if (entityList!=null){
              view.showActorTable(entityList);
         }else{
            view.showMessage("Error,Actors not found");
        }
        
    }

    private void searchByName() {
        String name = view.inputString("Input name");
        Actor a = model.findActor(new Actor(name));
        if(a != null)
            view.showActorForm(a);
        else
            view.showMessage("Actor not found");    
    }

    private void create() {
        Actor actor = view.inputActor();
        Boolean result = model.addActor(actor);
        if(result == true) {
            view.showMessage("Actor successfully added");
        } else {
            view.showMessage("Actor not valid");
        }
    }

    private void modify() {
        
        String name = view.inputString("Input name:");
        Actor a = model.findActor(new Actor(name));
        if(a == null) {
            view.showMessage("Wrong Actor not found");
        } else {
            view.showMessage("Actor to modify" + a.toString()+"\n");
            String shure = view.inputString("YOU ARE sure to modify a Actor? Y/N \n");
            if(shure.equalsIgnoreCase("y")) {
                int year = view.inputInt("Input year:");
                Actor modifiedActor =new Actor(a.getName(),year);
                if(model.updateActor(modifiedActor)){
                    view.showMessage("Actor successfully modified");
                } else
                    view.showMessage("Actor not modified");
            }else if(shure.equalsIgnoreCase("n")) {
                view.showMessage("Actor not modified");
            }
        }
    }

    private void delete() {
        
        String name = view.inputString("Input name:");
        Actor a = model.findActor(new Actor(name));
        if(a == null) {
            view.showMessage("Wrong name not found");
        } else {
            view.showMessage("Actor to delete" + a.toString() + "\n");
            String shure = view.inputString("You are sure to delete a actor? Y/N \n");
            if(shure.equalsIgnoreCase("y")) {
                if(model.deleteActor(a))
                    view.showMessage("Actor successfully deleted");
                else
                    view.showMessage("Wrong Actor not deleted");
            }else if(shure.equalsIgnoreCase("n")) {
                view.showMessage("Actor not deleted");
            }
        }
    }
}
