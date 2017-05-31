/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.servlets;

import com.google.gson.Gson;
import filmsAndActors.model.Film;
import filmsAndActors.model.persist.FilmArrayDao;
import filmsAndActors.model.persist.FilmDaoInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edgar
 */
public class FilmServlet extends HttpServlet {

    private FilmDaoInterface filmDao;

    public void init() throws ServletException {
        this.filmDao = new FilmArrayDao();

        Film film1 = new Film("titulo1", "director1", "descripcion1", 2001);
        Film film2 = new Film("titulo2", "director2", "descripcion2", 2002);
        Film film3 = new Film("titulo3", "director3", "descripcion3", 2003);

        filmDao.add(film1);
        filmDao.add(film2);
        filmDao.add(film3);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doAction(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "list_all_films": //list all films
                    listAllFilms(request, response);
                    //http://localhost:8080/ActorFilmServelt/FilmServlet?action=list_all_films
                    break;
                case "list_all_films_json":
                    listAllFilmsJson(request, response);
                    break;
                case "list_film_by_title": //list film by title
                    listFilmByTitle(request, response);
                    break;
                case "list_film_by_title_json":
                    listFilmByTitleJson(request, response);
                    break;
                case "add_new_film": //add
                    addNewFilm(request, response);
                    break;
                case "modify_film": //modify
                    updateFilm(request, response);
                    break;
                case "delete_film": //delete
                    deleteFilm(request, response);
                    break;

                default: //unknown option.
                    redirectError(request, response, 1);
                    break;
            }
        } else { // parameter action needed
            redirectError(request, response, 2);
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void listAllFilms(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Film> entityList = (List<Film>) filmDao.findAll();
        request.setAttribute("films", entityList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/film/listallfilms.jsp");
        rd.forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void listAllFilmsJson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Film> entityList = (List<Film>) filmDao.findAll();
        try (PrintWriter out = response.getWriter()) {
            out.print(new Gson().toJson(entityList));
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addNewFilm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //resultado = (condicion)?valor1:valor2;
        //if (condicion == true) --> resultado = valor1
        //if (condicion == false) --> resultado = valor2
        String title = (request.getParameter("title") != null) ? request.getParameter("title") : "";
        String director = (request.getParameter("director") != null) ? request.getParameter("director") : "";
        String description = (request.getParameter("description") != null) ? request.getParameter("description") : "";
        int year = (request.getParameter("year") != null) ? Integer.parseInt(request.getParameter("year")) : -1;

        Film film = new Film(title, director, description, year);

        List<Film> entityList = (List<Film>) filmDao.findAll();
        request.setAttribute("filmslist", entityList);

        Boolean filmCreated = filmDao.add(film);

        if (filmCreated != false) {
            request.setAttribute("film", film);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/film/filmadd.jsp");
            rd.forward(request, response);
        } else {
            redirectError(request, response, 2);
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteFilm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = (request.getParameter("title") != null) ? request.getParameter("title") : "";
        String director = (request.getParameter("director") != null) ? request.getParameter("director") : "";
        String description = (request.getParameter("description") != null) ? request.getParameter("description") : "";
        int year = (request.getParameter("year") != null) ? Integer.parseInt(request.getParameter("year")) : -1;

        Film film = new Film(title, director, description, year);

        List<Film> entityList = (List<Film>) filmDao.findAll();
        request.setAttribute("filmslist", entityList);

        Boolean filmDeleted = filmDao.delete(film);

        if (filmDeleted != false) {
            request.setAttribute("film", film);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/film/filmdelete.jsp");
            rd.forward(request, response);
        } else {
            redirectError(request, response, 3);
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateFilm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = (request.getParameter("title") != null) ? request.getParameter("title") : "";
        String director = (request.getParameter("director") != null) ? request.getParameter("director") : "";
        String description = (request.getParameter("description") != null) ? request.getParameter("description") : "";
        int year = (request.getParameter("year") != null) ? Integer.parseInt(request.getParameter("year")) : -1;

        Film film = new Film(title, director, description, year);

        List<Film> entityList = (List<Film>) filmDao.findAll();
        request.setAttribute("filmslist", entityList);

        Boolean filmUpdated = filmDao.update(film);

        if (filmUpdated != false) {
            request.setAttribute("film", film);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/film/filmupdate.jsp");
            rd.forward(request, response);
        } else {
            redirectError(request, response, 3);
        }
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void listFilmByTitle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        List<Film> entityList = (List<Film>) filmDao.FindByTitle(title);
        request.setAttribute("films", entityList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/film/listallfilms.jsp");
        rd.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void listFilmByTitleJson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        List<Film> entityList = (List<Film>) filmDao.FindByTitle(title);
        try (PrintWriter out = response.getWriter()) {
            out.print(new Gson().toJson(entityList));
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * serves Bad Request errors with HTTP Status 400
     *
     * @param request
     * @param response
     */
    public void redirectError(HttpServletRequest request, HttpServletResponse response, int error)
            throws ServletException, IOException {
        String errorMsg = "";
        switch (error) {
            case 1: // bad parameter action
                errorMsg = "Bad Parameter action";
                break;
            case 2:
                errorMsg = "Error Add Film";
                break;
            case 3:
                errorMsg = "Error update. Film does not exist";
                break;
            default: // need parameter action
                errorMsg = "Parameter action needed";
        }
        response.sendError(response.SC_BAD_REQUEST, errorMsg);
    }
}
