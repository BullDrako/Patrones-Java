/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.model.persist;

import java.util.List;
import practicapuntuablepatrons.model.Film;

/**
 *
 * @author alumne
 *
 * els 4 a la interface general
 */
public interface FilmDaoInterface {

    /**
     * adds a new friend to persistende media preventing phone duplicates
     *
     * @param film to add
     * @return true if succesfull, false otherwise
     */
    public boolean addFilm(Film film);

    /**
     * update a friend to persistende media
     *
     * @param film to modify
     * @return true if succesfull, false otherwise
     */
    public boolean updateFilm(Film film);

    /**
     * deletes a friend to persistende media
     *
     * @param film to delete
     * @return true if succesfull, false otherwise
     */
    public boolean deleteFilm(Film film);

    /**
     * searches a film
     *
     * @param film to search
     * @return film with given data or null
     */
    public Film find(Film film);

    /**
     * recieve all film from persistence media
     *
     * @return all film object or if is empty shows a message
     */
    public List<Film> findAllFilm();

    /**
     * searches a film with the given title
     *
     * @param title
     * @return
     */
    public Film findByTitle(String title);

    /**
     * searches a film with the given director
     *
     * @param director
     * @return
     */
    public Film findByDirector(String director);

}
