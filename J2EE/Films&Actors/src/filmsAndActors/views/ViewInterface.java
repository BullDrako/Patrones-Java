/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.views;

/**
 *
 * @author Edgar
 */
import filmsAndActors.model.Actor;
import filmsAndActors.model.Film;
import java.util.List;

/**
 *
 * @author Edgar
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
    
    public void showFilmTable(List<Film> entityList);

    public String inputString(String input_phone);

    public void showActorForm(Actor a);

    public void showFilmForm(Film f);

    public Actor inputActor();

    public Film inputFilm();

    public int inputInt(String input_year);

    public void doInteract();

}
