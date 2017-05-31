/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.model;

import java.util.List;
import practicapuntuablepatrons.model.persist.ActorArrayDao;
import practicapuntuablepatrons.model.persist.ActorDaoInterface;
import practicapuntuablepatrons.model.persist.FilmArrayDao;
import practicapuntuablepatrons.model.persist.FilmDaoInterface;

/**
 *
 * @author alumne
 */
public class Model {
    FilmDaoInterface filmDao;
    ActorDaoInterface actorDao;
    
    public Model(){
        filmDao = new FilmArrayDao();
        actorDao = new ActorArrayDao();
    }
    
    public boolean insertFilm(Film film){
        return filmDao.addFilm(film);
    }
    
    public boolean updateFilm(Film film){
        return filmDao.updateFilm(film);
    }
    
    public boolean deleteFilm(Film film){
        return filmDao.deleteFilm(film);
    }
    
    public Film findFilm(Film film){
        return filmDao.find(film);
    }
    
    public List<Film> findAllFilm(){
        return filmDao.findAllFilm();
    }
    
    
    public boolean insertActor(Actor actor){
        return actorDao.addActor(actor);
    }
    
    public boolean updateActor(Actor actor){
        return actorDao.updateActor(actor);
    }
    
    public boolean deleteActor(Actor actor){
        return actorDao.deleteActor(actor);
    }
    
    public Actor findActor(Actor actor){
        return actorDao.find(actor);
    }
    
    public List<Actor> findAllActor(){
        return actorDao.findAllActor();
    }
}
