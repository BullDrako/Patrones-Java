/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpractica.views;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvcpractica.model.Friend;
import mvcpractica.views.ViewInterface;

/**
 * <strong>FriendsView.java</strong>
 * Class FriendsView Friends view.
 *
 * @author Proven
 */
public class FriendsView extends Menu implements ViewInterface {

    private final String[] options;

    public FriendsView(String title) {
        super(title);
        this.options = new String[]{"Exit", "List all friends", "Find friend by phone", "Add a new friend", "Modify a friend", "Delete a friend"};
        for (String opt : options) {
            this.add(new Option(opt));
        }
    }

    /**
     * <strong>inputFriend()</strong>
     * Inputs a friend from user.
     *
     * @return friend inputted or null in case of error.
     */
    public Friend inputFriend() {
        Friend friend;
        try {
            Scanner scan = new Scanner(System.in);
            String phone = this.inputString("Input phone: ");
            String name = this.inputString("Input name: ");
            int age = this.inputInt("Input age: ");
            if (age < 0){
                System.out.println("Age mustn't be a negative number");
                age = this.inputInt("Input age: ");
            }
            friend = new Friend(phone, name, age);
        } catch (InputMismatchException e) {
            Logger.getLogger(this.getClass().getCanonicalName()).log(Level.WARNING, e.toString());

            //Re-enter data
            System.out.println("Age must be a number");
            String phone = this.inputString("Input phone: ");
            String name = this.inputString("Input name: ");
            int age = this.inputInt("Input age: ");

            friend = new Friend(phone, name, age);
            //friend = null;
        
        } 
        return friend;
    }
    
    /**
     * <strong>inputFriend(String s)</strong>
     * Inputs a friend from user used for modify.
     *
     * @return friend inputted or null in case of error.
     */
    
     public Friend inputFriend(String s) {
        Friend friend;
        try {
            Scanner scan = new Scanner(System.in);
            String phone = s;
            String name = this.inputString("Input name: ");
            int age = this.inputInt("Input age: ");
            if (age < 0){
                System.out.println("Age mustn't be a negative number");
                age = this.inputInt("Input age: ");
            }
            friend = new Friend(phone, name, age);
        } catch (InputMismatchException e) {
            Logger.getLogger(this.getClass().getCanonicalName()).log(Level.WARNING, e.toString());

            //Re-enter data
            System.out.println("Age must be a number");
            String phone = this.inputString("Input phone: ");
            String name = this.inputString("Input name: ");
            int age = this.inputInt("Input age: ");

            friend = new Friend(phone, name, age);
            //friend = null;
        
        } 
        return friend;
    }
    

    /**
     * Shows a form with data of friend
     *
     * @param friend to show
     */
    public void showFriendForm(Friend friend) {
        System.out.println(friend.toString());
    }

    /**
     * Shows a table with the list
     *
     * @param list to show
     */
    public void showFriendTable(List<Friend> list) {
        System.out.println("Listing a list of friends\n");

        for (Friend f : list) {
            System.out.println(f.toString());
        }

        System.out.println(String.format("%d friends found.\n", list.size()));
    }

}
