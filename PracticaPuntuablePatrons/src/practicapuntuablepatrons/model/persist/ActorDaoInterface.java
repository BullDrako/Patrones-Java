/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.model.persist;

import java.util.List;
import practicapuntuablepatrons.model.Actor;

/**
 *
 * @author alumne
 */
public interface ActorDaoInterface {

    /**
     * adds a new actor to persistende media preventing phone duplicates
     *
     * @param actor to add
     * @return true if succesfull, false otherwise
     */
    public boolean addActor(Actor actor);

    /**
     * update aan actor to persistende media
     *
     * @param actor to modify
     * @return true if succesfull, false otherwise
     */
    public boolean updateActor(Actor actor);

    /**
     * deletes an actor to persistende media
     *
     * @param actor to delete
     * @return true if succesfull, false otherwise
     */
    public boolean deleteActor(Actor actor);

    /**
     * recieve all actors from persistence media
     *
     * @return all actors object or if is empty shows a message
     */
    public List<Actor> findAllActor();

    /**
     * searches an actor
     *
     * @param actor to search
     * @return actor with given data or null
     */
    public Actor find(Actor actor);

    /**
     * searches an actor with the given phone
     *
     * @param name to search
     * @return actor with given data or null
     */
    public Actor findByNameActor(String name);

    /**
     * searches an actor with the given 
     * @param yearBirth
     * @return 
     */
    public Actor findByYearBirth(int yearBirth);

}
