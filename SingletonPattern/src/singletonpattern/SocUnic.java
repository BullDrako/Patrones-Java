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
public class SocUnic {

    private static SocUnic instance;
    private String nom;

    private SocUnic(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static SocUnic getInstance(String nom1) {
        if (instance == null) {
            instance = new SocUnic(nom1);
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("nombre");
    }
}
//Clase userlist con array users:String[]
//constructor lista de nombres
//modificar
