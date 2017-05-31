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
import filmsAndActors.model.Film;
import filmsAndActors.model.persist.FilmArrayDao;
import filmsAndActors.model.persist.FilmDaoInterface;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
//import proven.msg.Message;
//import proven.msg.PropertiesLanguage;

/**
 *
 * @author alumne
 */
@Path("film-service")
public class FilmService {

    FilmDaoInterface filmDao;

    /**
     * Mantenim la persistència de les dades al Contexte
     *
     * @param context
     */
    public FilmService(@Context ServletContext context) {
        if (context.getAttribute("filmDAO") != null) {
            filmDao = (FilmArrayDao) context.getAttribute("filmDAO");
        } else {
            filmDao = new FilmArrayDao();
            context.setAttribute("filmDAO", filmDao);
        }
    }

    /**
     * Find all Actors (By GET)
     * @return all films with Json format
     */
    @GET
    @Path("/find_all_films")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String findAllFilms() {
        return new Gson().toJson(filmDao.findAll());
    }

    /**
     * Find Film with the given title (By GET)
     * @param title
     * @return
     */
    @GET
    @Path("/find/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String findFilmByTitle(
            @PathParam("title") String title) {

        Film f = filmDao.find(new Film(title));
        if (f == null) /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"notfound")));*/ {
            //return "film do not exist";
            return new Gson().toJson("Film do not exist");
        } else {
            return new Gson().toJson(f);
        }
    }

    /**
     * Add film with the given title, director, description and year (By GET)
     * @param title
     * @param director
     * @param description
     * @param year
     * @return a message if it is not created. Else return the film created
     */
    @GET
    @Path("/insert_film_query")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insertFilmQ(
            @QueryParam("title") String title,
            @QueryParam("director") String director,
            @QueryParam("description") String description,
            @QueryParam("year") int year) {

        Film f = new Film(title, director, description, year);

        Boolean filmCreated = filmDao.add(f);

        if (filmCreated == true) {
            return new Gson().toJson(f);
        } else {
            /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error add film";
            return new Gson().toJson("Error Add film");
        }
    }

    /**
     * Add film with the given title, director, description and year (By POST)
     * @param title
     * @param director
     * @param description
     * @param year
     * @return a message if it is not created. Else return the film created
     */
    @POST
    @Path("/insert_film")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String insertFilmF(
            @FormParam("title") String title,
            @FormParam("director") String director,
            @FormParam("description") String description,
            @FormParam("year") int year) {

        Film f = new Film(title, director, description, year);

        Boolean filmCreated = filmDao.add(f);

        if (filmCreated == true) {
            return new Gson().toJson(f);
        } else {
            /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error add film";
             return new Gson().toJson("Error Add film");
        }
    }

    /**
     * Modify an actor (By POST)
     * @param title
     * @param director
     * @param description
     * @param year
     * @return a message if it is not updated. Else return the film updated
     */
    @POST
    @Path("/update_film_post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateFilmPost(
            @FormParam("title") String title,
            @FormParam("director") String director,
            @FormParam("description") String description,
            @FormParam("year") int year) {

        Film f = new Film(title, director, description, year);

        Boolean filmUpdated = filmDao.update(f);

        if (filmUpdated == true) {
            return new Gson().toJson(f);
        } else {
            /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error Update film";
            return new Gson().toJson("Error Update film");
        }
    }

    /**
     * Modify an actor (By GET)
     * @param title
     * @param director
     * @param description
     * @param year
     * @return
     */
    @GET
    @Path("/update_film_query")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateFilmQ(
            @QueryParam("title") String title,
            @QueryParam("director") String director,
            @QueryParam("description") String description,
            @QueryParam("year") int year) {

        Film f = new Film(title, director, description, year);

        Boolean filmUpdated = filmDao.update(f);

        if (filmUpdated == true) {
            return new Gson().toJson(f);
        } else {
            /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error Update film";
            return new Gson().toJson("Error Update film");
        }
    }

    /**
     * Delete the film with he given name (By GET)
     * @param title
     * @return a message saying "Error Delete Film" if it is not deleted. Else return a message saying "Film Deleted"
     */
    @GET
    @Path("/remove_film")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String removeFilmQ(
            @QueryParam("title") String title) {

        Film f = new Film(title);

        Boolean filmDeleted = filmDao.delete(f);

        if (filmDeleted == true) {
            return "Film Deleted";
            //return new Gson().toJson(f);
        } else {
            /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error Delete film";
            return new Gson().toJson("Error Delete film");
        }
    }

    /**
     * Delete the film with he given name (By POST)
     * @param title
     * @return a message saying "Error Delete Film" if it is not deleted. Else return a message saying "Film Deleted"
     */
    @POST
    @Path("/remove_film_post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String removeFilmPost(
            @FormParam("title") String title) {

        Film f = new Film(title);

        Boolean filmDeleted = filmDao.delete(f);

        if (filmDeleted == true) {
            return "Film Deleted";
            //return new Gson().toJson(f);
        } else {
            /*return new Gson().toJson(new Message(0 
                        ,PropertiesLanguage.returnValue(Locale.ENGLISH,"fail")));*/
            //return "Error Delete film";
            return new Gson().toJson("Error Delete film");
        }
    }
}
