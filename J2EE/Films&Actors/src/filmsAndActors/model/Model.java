/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.model;

import filmsAndActors.model.persist.ActorArrayDao;
import filmsAndActors.model.persist.ActorDaoInterface;
import filmsAndActors.model.persist.FilmArrayDao;
import filmsAndActors.model.persist.FilmDaoInterface;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class Model {
     ActorDaoInterface actorDao;
     FilmDaoInterface filmDao;
    
    public Model(){
        actorDao = new ActorArrayDao();
        filmDao = new FilmArrayDao();
    }
    
    public Film findFilm(Film film){
        return filmDao.find(film);
    }
    
    public Actor findActor(Actor actor){
        return actorDao.find(actor);
    }
     
    public boolean addFilm(Film film){
        return filmDao.add(film);
    }
    
    public boolean addActor(Actor actor){
        return actorDao.add(actor);
    }
       
    public boolean updateFilm(Film film){
        
        return filmDao.update(film);
    }
    
    public boolean updateActor(Actor actor){
        
        return actorDao.update(actor);
    }
        
    public List<Film> findAllFilms(){
       return filmDao.findAll();
    }
    
    public List<Actor> findAllActors(){
       return actorDao.findAll();
    }
          
    public boolean deleteFilm(Film film) {
       return filmDao.delete(film);
    }
    
    public boolean deleteActor(Actor actor) {
       return actorDao.delete(actor);
    }
    
   
}
