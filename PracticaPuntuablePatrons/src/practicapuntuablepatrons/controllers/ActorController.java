/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.controllers;

import java.util.List;
import practicapuntuablepatrons.model.Actor;
import practicapuntuablepatrons.model.Model;
import practicapuntuablepatrons.views.ActorView;
import practicapuntuablepatrons.views.ViewFactory;
import practicapuntuablepatrons.views.ViewInterface;

/**
 *
 * @author alumne
 */
public class ActorController implements ControllerInterface {

    private Model model;
    private ViewInterface view;

    public ActorController(Model model) {
        this.model = model;
        view = ViewFactory.loadViews("actor", this, model);
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
            default:
                break;
        }

    }
    
    /**
     * Insert data in actor list
     */
    private void inputData() {
        model.insertActor(new Actor("Vin Diesel", 1967));
        model.insertActor(new Actor("Matt Damon", 1970));
        model.insertActor(new Actor("Jason Statham", 1967));
    }

    /**
     * list all actors. If there are any actor, shows a list. Else there aren't any actor
     */
    private void listAll() {
        List<Actor> entityList = (List<Actor>) model.findAllActor();
        if (entityList != null) {
            view.showActorTable(entityList);
        } else {
            view.showMessage("Error, Actors not found");
        }

    }
    
    /**
     * Searches an actor by name. If the name doesn't exit show a message
     */
    private void searchByName() {
        String name = view.inputString("Input name: ");
        Actor a = model.findActor(new Actor(name));
        if (a != null) {
            view.showActorForm(a);
        } else {
            view.showMessage("Actor not found");
        }
    }
    
     

    /**
     * Create an actor. First it calls the view of actor and it asks the name of actor, phone... if the data is correct,
     * it adds an actor, else the  actor isn't added
     */
    private void create() {
        Actor actor = view.inputActor();
        Boolean result = model.insertActor(actor);
        if (result == true) {
            view.showMessage("Actor successfully added");
        } else {
            view.showMessage("Actor not added");
        }
    }

    /**
     * Modify an actor. First input a name of actor to modify. Then it searches it. If it don't find it, the actor doesn't exist,
     * if it exists it asks if you are shure to modify it. If you input "y" it modifyys the acotr's data.
     */
    private void modify() {

        String name = view.inputString("Input name: ");
        Actor a = model.findActor(new Actor(name));
        if (a == null) {
            view.showMessage("Wrong Actor not found");
        } else {
            view.showMessage("Actor to modify" + a.toString() + "\n");
            String modify = view.inputString("Are you sure to modify an Actor? Y/N \n");
            if (modify.equalsIgnoreCase("y")) {
                int year = view.inputInt("Input year:");
                Actor modifiedActor = new Actor(a.getName(), year);
                if (model.updateActor(modifiedActor)) {
                    view.showMessage("Actor successfully modified");
                } else {
                    view.showMessage("Wrong Actor not modified");
                }
            } else if (modify.equalsIgnoreCase("n")) {
                view.showMessage("Actor not modified");
            }
        }
    }

    /**
     * Delete Actor. Input the name of the actor to delete. Then it searches it. If it don't find it, the actor doesn't exixst,
     * if it exists it asks if you are shure to delete it. If you input "y" it deletes the actor's data.
     */
    private void delete() {

        String name = view.inputString("Input name:");
        Actor a = model.findActor(new Actor(name));
        if (a == null) {
            view.showMessage("Wrong name not found");
        } else {
            view.showMessage("Actor to delete" + a.toString() + "\n");
            String delete = view.inputString("You are sure to delete a actor? Y/N \n");
            if (delete.equalsIgnoreCase("y")) {
                if (model.deleteActor(a)) {
                    view.showMessage("Actor successfully deleted");
                } else {
                    view.showMessage("Wrong Actor not deleted");
                }
            } else if (delete.equalsIgnoreCase("n")) {
                view.showMessage("Actor not deleted");
            }
        }
    }
}
