/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.webservices;

import com.google.gson.Gson;
import java.util.Locale;
import javax.servlet.ServletContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import filmsAndActors.model.Actor;
import filmsAndActors.model.persist.ActorArrayDao;
import filmsAndActors.model.persist.ActorDaoInterface;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
//import proven.msg.Message;
//import proven.msg.PropertiesLanguage;

/**
 *
 * @author alumne
 */
@Path("actor-service")
public class ActorService {

    ActorDaoInterface actorDao;

    /**
     * Mantenim la persistència de les dades al Contexte
     *
     * @param context
     */
    public ActorService(@Context ServletContext context) {
        if (context.getAttribute("actorDAO") != null) {
            actorDao = (ActorArrayDao) context.getAttribute("actorDAO");
        } else {
            actorDao = new ActorArrayDao();
            context.setAttribute("actorDAO", actorDao);
        }
    }

    /**
     * Find all Actors (By GET)
     * @return all actors with Json format
     */
    @GET
    @Path("/find_all_actors")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String findAllActors() {
        return new Gson().toJson(actorDao.findAll());
    }

    /**
     * Find Actor with the given name (By GET)
     * @param name
     * @return  a message if it is null. Else return the actor
     */
    @Path("/find/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)//peticio de formulari http
    public String findActorByName(
            @PathParam("name") String name) {

        Actor a = actorDao.find(new Actor(name));
        if (a == null) /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"notfound")));*/ {
            //return "actor do not exist";
            return new Gson().toJson("Actor do not exist");
        } else {
            return new Gson().toJson(a);
        }
    }

    /**
     * Add actor with the given name and year of birth (By GET)
     * @param name
     * @param yearBirth
     * @return a message if it is not created. Else return the actor created
     */
    @GET
    @Path("/insert_actor_query")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insertActorQ(
            @QueryParam("name") String name,
            @QueryParam("yearBirth") int yearBirth) {

        Actor a = new Actor(name, yearBirth);

        Boolean actorCreated = actorDao.add(a);

        if (actorCreated == true) {
            return new Gson().toJson(a);
        } else {
            /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error add actor";
            return new Gson().toJson("Error add actor");
        }
    }

    /**
     * Add actor with the given name and year of birth (By POST)
     * @param name
     * @param yearBirth
     * @return a message if it is not created. Else return the actor created
     */
    @POST
    @Path("/insert_actor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insertActorF(
            @FormParam("name") String name,
            @FormParam("yearBirth") int yearBirth) {

        Actor a = new Actor(name, yearBirth);

        Boolean actorCreated = actorDao.add(a);

        if (actorCreated == true) {
            return new Gson().toJson(a);
        } else {
            /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error add actor";
            return new Gson().toJson("Error add actor");
        }
    }

    /**
     * Modify an actor (By GET)
     * @param name
     * @param yearBirth
     * @return a message if it is not updated. Else return the actor updated
     */
    @GET
    @Path("/update_actor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateFilm(
            @QueryParam("name") String name,
            @QueryParam("yearBirth") int yearBirth) {

        Actor a = new Actor(name, yearBirth);

        Boolean actorUpdated = actorDao.update(a);

        if (actorUpdated == true) {
            return new Gson().toJson(a);
        } else {
            /*return new Gson().toJson(new Message(0 
                         ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error Update actor";
            return new Gson().toJson("Error Update actor");
        }

    }

    /**
     * Modify an actor (By POST)
     * @param name
     * @param yearBirth
     * @return a message if it is not updated. Else return the actor updated
     */
    @POST
    @Path("/update_actor_post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateFilmPost(
            @FormParam("name") String name,
            @FormParam("yearBirth") int yearBirth) {

        Actor a = new Actor(name, yearBirth);

        Boolean actorUpdated = actorDao.update(a);

        if (actorUpdated == true) {
            return new Gson().toJson(a);
        } else {
            /*return new Gson().toJson(new Message(0 
                         ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error Update actor";
            return new Gson().toJson("Error Update actor");
        }
    }

    /**
     * Delete the actor with he given name (By GET)
     * @param name
     * @param yearBirth
     * @return a message saying "Error Delete actor" if it is not deleted. Else return a message saying "actor Deleted"
     */
    @GET
    @Path("/remove_actor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String removeFilm(
            @QueryParam("name") String name,
            @QueryParam("yearBirth") int yearBirth) {

        Actor a = new Actor(name);

        Boolean actorDeleted = actorDao.delete(a);

        if (actorDeleted == true) {
            //return new Gson().toJson(a);
            //return "actor Deleted";
            return new Gson().toJson("Actor Deleted");
        } else {
            /*return new Gson().toJson(new Message(0 
                         ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error Delete actor";
            return new Gson().toJson("Error Delete actor");
        }
    }

    /**
     * Delete the actor with he given name (By POST)
     * @param name
     * @param yearBirth
     * @return a message saying "Error Delete actor" if it is not deleted. Else return a message saying "actor Deleted"
     */
    @POST
    @Path("/remove_actor_post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String removeActorPost(
            @FormParam("name") String name,
            @FormParam("yearBirth") int yearBirth) {

        Actor a = new Actor(name);

        Boolean actorDeleted = actorDao.delete(a);

        if (actorDeleted == true) {
             return new Gson().toJson("Actor Deleted");
            //return "Actor deleted";
            //return new Gson().toJson(a);
        } else {
            /*return new Gson().toJson(new Message(0 
                         ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error Delete actor";
            return new Gson().toJson("Error Delete actor");
        }
    }
}
