/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.model.persist;

import java.util.ArrayList;
import java.util.List;
import practicapuntuablepatrons.model.Actor;

/**
 *
 * @author alumne
 */
public class ActorArrayDao implements ActorDaoInterface {

    List<Actor> actors;

    public ActorArrayDao() {
        actors = new ArrayList<>();
    }

    @Override
    public boolean addActor(Actor actor) {
        boolean result = false;
        if (actor != null) {
            if (find(actor) == null) {
                actors.add(actor);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean updateActor(Actor actor) {
        boolean result = false;
        if (actor != null) {
            Actor ac = null;
            ac = findByNameActor(actor.getName());
            if (ac != null) {
                ac.setYearBirth(actor.getYearBirth());
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean deleteActor(Actor actor) {
        boolean result = false;
        if (actors.remove(actor)) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Actor> findAllActor() {
        if (actors.isEmpty()) {
            System.out.println("The list is empty");
        }
        return actors;
    }

    @Override
    public Actor find(Actor actor) {
        Actor ac = null;
        for (Actor a : actors) {
            if (a.equals(actor)) {
                ac = a;
                break;
            }
        }
        return ac;
    }

    @Override
    public Actor findByNameActor(String name) {
        List<Actor> actors = new ArrayList<>();
        for (Actor a : this.actors) {
            if (a.getName().equals(name)) {
                actors.add(a);
            }
        }
        if (actors.isEmpty()) {
            System.out.println("The Actor not exists");
        }
        return (Actor) actors;
    }

    @Override
    public Actor findByYearBirth(int yearBirth) {
        Actor ac = null;
        for (Actor a : actors) {
            if (a.getYearBirth() == yearBirth) {
                ac = a;
                break;
            }
        }
        return ac;
    }
}
