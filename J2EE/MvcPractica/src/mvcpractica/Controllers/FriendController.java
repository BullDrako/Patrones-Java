/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpractica.Controllers;

import java.util.List;
import mvcpractica.model.Friend;
import mvcpractica.model.FriendModel;
import mvcpractica.views.FriendsView;
import mvcpractica.model.persist.FriendArrayDao;
import mvcpractica.model.persist.FriendDao;

/**
 * <strong>FriendController.java</strong>
 * Class FriendController. Friend controller.
 *
 * @author Proven
 */
public class FriendController {

    private final FriendsView view;
    private final FriendModel model;

    public FriendController(FriendModel model) {
        this.model = model;//instanciar modelo
        view = new FriendsView("Friend manager");//crea la vista
    }

    /**
     * <strong>doAction()</strong>
     * executes actions to manage friends.
     */
    public void doAction() {
        boolean exit = false;
        int optionSelected;
        do {
            view.display();
            optionSelected = view.getUserOption();//recupera ipcio de l'usuari
            switch (optionSelected) {
                case 0: //exit menu
                    exit = true;
                    break;
                case 1: //list all
                    listAll();
                    break;
                case 2: //list friend by phone
                    searchByPhone();
                    break;
                case 3: //add
                    create();
                    break;
                case 4: //modify
                    modify();
                    break;
                case 5: //delete
                    delete();
                    break;
                default: //unknown option.
                    break;
            }
        } while (!exit);
    }

   
    /*private void listAll() { antiguo
        view.showMessage("Listing all friends\n");
        List<Friend> entityList = (List<Friend>) model.findAll();
        view.showMessage(String.format("%d friends found.\n", entityList.size()));
        entityList.stream().forEach((e) -> {
            view.showMessage(e.toString());
        });
    }*/
    /**
     * <strong>listAll()</strong>
     * lists all friends from model data
     */
    private void listAll() {
        List<Friend> entityList = (List<Friend>) model.findAll();
        view.showFriendTable(entityList);

    }

    /**
     * <strong>searchByPhone()</strong>
     * searches a friend whose pohne is entered by the user and displays its
     * format
     */
    private void searchByPhone() {
        String phone = view.inputString("input phone:");
        if (phone != null) {
            Friend friend = model.find(new Friend(phone));
            if (friend != null) {
                view.showFriendForm(friend);
            } else {
                view.showMessage("Not found!\n");
            }
        } else {
            view.showMessage("Error enter phone.\n");
        }
    }

    /**
     * <strong>Modify</strong>
     * 
     * Asks the user to input a friend's phone and searches for it in the 
     * data store. If a friend with the given phone is found, it ask if you want modify it.
     * If the answer is yes, it shows the form, updates the friend and reports the result
     * 
     */
    private void modify() {
        String phone = view.inputString("input phone user to modify \n");
        if (phone != null) {
            Friend friend = model.find(new Friend(phone));
            if (friend != null) {
                String confirm = view.inputString("Do you want modify it (yes) \n");
                if (confirm.equals("yes")) {
                    friend = view.inputFriend(phone);//antes no estaba phone
                    model.update(friend);
                    view.showMessage("1 friend updated");
                } else {
                    view.showMessage("Unmodified friend");
                    //view.showMessage("friend not found");
                }
            } else {
                System.out.println("Friend not found");
            }

        } else {
            view.showMessage("Error modifying friend.\n");
        }
    }

    /**
     * <string>Delete</strong>
     * Asks the user to input a friend's phone and searches for it in the
     * data store if a friend with the given phone is found, it shows it to the
     * user and ask for confirmation. If the user confirm, it removes the
     * friend, and reports the result to the user If no friend is found
     */
    private void delete() {
        String phone = view.inputString("input phone user to delete \n");
        if (phone != null) {
            Friend friend = model.find(new Friend(phone));
            if (friend != null) {
                String confirm = view.inputString("Do you want delete it (yes) \n");
                view.showFriendForm(friend);
                if (confirm.equals("yes")) {
                    model.delete(friend);
                    view.showMessage("1 friend deleted");
                } else {
                    view.showMessage("friend not deleted");
                }
            } else{
                System.out.println("Friend not found");
            }
        } else {
            view.showMessage("Error delete friend.\n");
        }

        /*
         String friendd = view.inputString("input phone user to delete");
        if (friendd != null){
            Friend friend = model.find(new Friend(friendd));
            if (friend != null) {
                String confirm = view.inputString("Do you want delete it");
                view.showFriendForm(friend);
                if(confirm == "yes"){
                    model.delete(friend);
                    view.showMessage("1 friend deleted");
                } else{
                    view.showMessage("friend not found");
                }
            }
        } else{
            view.showMessage("Error delete friend.\n");
        }
         */
    }

    /**
     * <strong>Create</strong>
     * Asks the user to input a data of user to create it. and
     * searches for it in the data store. If not exists -> create user. If exist
     * -> user already exists
     */
    private void create() {
        view.showMessage("input user to create \n");
        Friend friendCreate = view.inputFriend();
        if (friendCreate != null) {
            Friend friend = model.find(friendCreate);
            if (friendCreate != friend) {
                model.insert(friendCreate);
                view.showMessage("1 user created \n");
                
            } else {
                view.showMessage("friend already exists \n");
            }
        } else {
            view.showMessage("Error create friend.\n");
        }
    }

}
