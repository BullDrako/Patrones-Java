/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Edgar
 */
public class Observador {
    public void update(Observado o, Object arg) {
        System.out.println("Nueva Actualizacion: " + o + " -> " + arg);
    }
}
