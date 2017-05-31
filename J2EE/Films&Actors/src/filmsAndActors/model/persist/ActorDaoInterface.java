/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.model.persist;

import filmsAndActors.model.Actor;
import java.util.List;

/**
 *
 * @author Edgar
 */
public interface ActorDaoInterface {
      /**
    * retrieves all Actors from persistence media
    * @return all actor objects or ..
    */
    
   public List<Actor> findAll();
   
   
   /**
    * searches actor
    * @param actor to search
    * @return actor with given data or ...
    */
   public Actor find(Actor actor);
   
   
   /**
     * adds a new Actor to persistence media.
     * @param Actor to add
     * @return true if succesful, false otherwise
     */
   public boolean add(Actor actor);
   
   /**
    * adds a new Actor to persistence media.
    * @param Actor to modify
    * @return true if succesful, false otherwise
    */
   
   public boolean update(Actor actor);
   
   /**
    * deletes a new Actor to persistence media.
    * @param Actor to delete
    * @return true if succesful, false otherwise
    */
   public boolean delete(Actor actor);
   
     /***
     * searches all friends with the given name
     * @param name to search
     * @return a list of friends or if is null shows a message
     */
    public List<Actor> FindByName(String name);
    
}
