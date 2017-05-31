/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.model.persist;

import flimindustrymangement.model.Flim;
import java.util.List;

/**
 *
 * @author alumne
 */
public interface FlimDaoInterface {
    
     /**
    * retrieves all flims from persistence media
    * @return all flims objects or ..
    */
    
   public List<Flim> findAll();
   
   
   /**
    * searches Flim
    * @param f to search
    * @return flim with given data or ...
    */
   public Flim find(Flim f);
   
   
   /**
     * adds a new Flim to persistence media.
     * preventing title duplicates.
     * @param flim to add
     * @return true if succesful, false otherwise
     */
   public boolean add(Flim flim);
   
   /**
    * adds a new Flim to persistence media.
    * @param flim to modify
    * @return true if succesful, false otherwise
    */
   
   public boolean update(Flim flim);
   
   /**
    * deletes a new Flim to persistence media.
    * @param flim to delete
    * @return true if succesful, false otherwise
    */
   public boolean delete(Flim flim);
    
}
