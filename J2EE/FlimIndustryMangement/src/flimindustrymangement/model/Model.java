/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.model;

import flimindustrymangement.model.persist.ActorArrayDao;
import flimindustrymangement.model.persist.ActorDaoInterface;
import flimindustrymangement.model.persist.FlimArrayDao;
import flimindustrymangement.model.persist.FlimDaoInterface;
import java.util.List;

/**
 *
 * @author jashan
 */
public class Model {
    
     ActorDaoInterface actorDao;
     FlimDaoInterface flimDao;
    
    public Model(){
        actorDao = new ActorArrayDao();
        flimDao = new FlimArrayDao();
    }
    
    public Flim findFlim(Flim flim){
        return flimDao.find(flim);
    }
    
    public Actor findActor(Actor actor){
        return actorDao.find(actor);
    }
     
    public boolean addFlim(Flim flim){
        return flimDao.add(flim);
    }
    
    public boolean addActor(Actor actor){
        return actorDao.add(actor);
    }
       
    public boolean updateFlim(Flim flim){
        
        return flimDao.update(flim);
    }
    
    public boolean updateActor(Actor actor){
        
        return actorDao.update(actor);
    }
        
    public List<Flim> findAllFlims(){
       return flimDao.findAll();
    }
    
    public List<Actor> findAllActors(){
       return actorDao.findAll();
    }
          
    public boolean deleteFlim(Flim flim) {
       return flimDao.delete(flim);
    }
    
    public boolean deleteActor(Actor actor) {
       return actorDao.delete(actor);
    }
    
   
    
}
