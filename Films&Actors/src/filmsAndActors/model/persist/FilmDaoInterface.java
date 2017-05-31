/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.model.persist;

import filmsAndActors.model.Film;
import java.util.List;

/**
 *
 * @author Edgar
 */
public interface FilmDaoInterface {
      /**
    * retrieves all films from persistence media
    * @return all films objects or ..
    */
    
   public List<Film> findAll();
   
   
   /**
    * searches Film
    * @param f to search
    * @return film with given data or ...
    */
   public Film find(Film f);
   
   
   /**
     * adds a new Film to persistence media.
     * preventing title duplicates.
     * @param film to add
     * @return true if succesful, false otherwise
     */
   public boolean add(Film film);
   
   /**
    * adds a new Film to persistence media.
    * @param film to modify
    * @return true if succesful, false otherwise
    */
   
   public boolean update(Film film);
   
   /**
    * deletes a new Film to persistence media.
    * @param film to delete
    * @return true if succesful, false otherwise
    */
   public boolean delete(Film film);
    
}
