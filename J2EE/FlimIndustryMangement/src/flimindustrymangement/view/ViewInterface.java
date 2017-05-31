/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.view;

import flimindustrymangement.model.Actor;
import flimindustrymangement.model.Flim;
import java.util.List;

/**
 *
 * @author alumne
 */
public interface ViewInterface {

      /**
     * <strong>showMessage()</strong>
     * <p>Show message.</p>
     * @param message Message to show.
     */
    public void showMessage(String message);

    public void display();

    public String getUserOption();

    public void showActorTable(List<Actor> entityList);
    
    public void showFlimTable(List<Flim> entityList);

    public String inputString(String input_phone);

    public void showActorForm(Actor a);

    public void showFlimForm(Flim f);

    public Actor inputActor();

    public Flim inputFlim();

    public int inputInt(String input_year);

    public void doInteract();

}
