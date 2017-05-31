/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;

/**
 *
 * @author Edgar
 */
public class UserList {

    private static UserList instance;

    private String[] users /*= {"a", "b", "c"}*/;
    private int numUsers;
    private int maxUsers;

    /* private UserList(String[] users) {
        this.users = users;
    }*/
    //profe
    private UserList() {
        maxUsers = 10;
        numUsers = 0;
        users = new String[maxUsers];
        users[0] = "aaa";
        users[1] = "bbb";
        numUsers = 2;

    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    /* public static UserList getInstance(String[] users) {
        if (instance == null) {
            instance = new UserList(users);
        }
        return instance;
    }*/
    //profe
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    //metode afegir
    public void addUser(String user) {
        if (this.numUsers < this.maxUsers) {
            this.users[numUsers] = user;
            numUsers++;
        }
    }

    /*@Override
    public String toString() {
        return "UserList{" + "users=" + this.users + '}';

    }*/
    //profe
    public String toString() {
        String out = "";

        for (int i = 0; i < this.numUsers; i++) {
            out += users[i] + " - ";
        }
        return out;

    }

}
