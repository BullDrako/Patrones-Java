/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.views;

import java.util.List;
import practicapuntuablepatrons.model.Actor;
import practicapuntuablepatrons.model.Film;

/**
 *
 * @author alumne
 */
public interface ViewInterface {

    /**
     * <strong>showMessage()</strong>
     * <p>
     * Show message.</p>
     *
     * @param message Message to show.
     */
    public String getUserOption();

    public void showActorTable(List<Actor> entityList);

    public void showFilmTable(List<Film> entityList);

    public Film inputFilm();

    public int inputInt(String input_year);

    public void doInteract();

    public String inputString(String input_phone);

    public void showActorForm(Actor a);

    public void showFilmForm(Film f);

    public Actor inputActor();

    public void showMessage(String message);

    public void display();

}
