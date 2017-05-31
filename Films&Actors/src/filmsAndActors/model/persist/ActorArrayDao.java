/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.model.persist;

import filmsAndActors.model.Actor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class ActorArrayDao implements ActorDaoInterface {

    List<Actor> actors;
    
    public ActorArrayDao() {
        actors = new ArrayList<>();
    }
    
    @Override
    public List<Actor> findAll() {
        return actors;
    }

    @Override
    public Actor find(Actor actor) {
        Actor act = null;
        for(Actor a : actors) {
            if(a.equals(actor)){
                act = a;
                break;
            }
        }
        return act;
    }

    @Override
    public boolean add(Actor actor) {
         boolean result = false;
        if(actor != null) {
            if(find(actor) == null) {
                actors.add(actor);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean update(Actor actor) {
        boolean result = false;
        if(actor != null){
            Actor act = null;
            act = find(actor);
            //System.out.println(act);
            if(act!=null) {
                act.setYearBirth(actor.getYearBirth());
                result = true;
            }
        }
        return result;    }

    @Override
    public boolean delete(Actor actor) {
        boolean result = false;
        if(actors.remove(actor)) {
            result = true;
        }
        return result;
    }
    
}