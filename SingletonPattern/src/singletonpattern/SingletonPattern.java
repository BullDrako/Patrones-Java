/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;

import singletonpattern.SocUnic;
import singletonpattern.UserList;
import java.util.Arrays;

/**
 *
 * @author Edgar
 */
public class SingletonPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("---------Soc Unic (Singleton)--------");
        SocUnic p = SocUnic.getInstance("a");
        System.out.println("Nom de p: " + p.getNom());
        //p.showMessage();

        SocUnic p2 = SocUnic.getInstance("b");
        System.out.println("Nom de p2: " + p2.getNom());
        //p2.showMessage();

        System.out.println("-------------------------");
        /*String[] usuarios = {"a", "b", "c"};
        UserList l1 = UserList.getInstance(usuarios);
        System.out.println(l1.getUsers());*/

        System.out.println("-------UserList (Singleton)---------");
        UserList u1 = UserList.getInstance();
        UserList u2 = UserList.getInstance();

        System.out.println(u1.toString());

        u1.addUser("Jeff");
        u2.addUser("Pol");
        System.out.println(u2.toString());
        System.out.println(u1.toString());

    }
}
