/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Edgar
 */
public class Observado {

    String mensaje;

    private List<Observador> observers;

    public Observado() {
        mensaje = "Objeto Observado Iniciado";
        observers = new ArrayList<>();
    }

    public void cambiarMensaje(String m) {
        mensaje = m;
        //Marcamos el objeto observable como objeto que ha cambiado

        //Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers(mensaje);
        //notifyObservers(); Este metodo solo notifica que hubo cambios en el objeto
    }

    void addObserver(Observador observador) {
        observers.add(observador);
    }

    private void notifyObservers(String mensaje) {
        for (Observador o : observers) { //cada observador actualizate
            o.update(this, mensaje); //this (es el observado) soy yo y le paso mensaje
        }
    }
}
