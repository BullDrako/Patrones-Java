/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import filmsAndActors.model.Actor;
import filmsAndActors.model.persist.ActorArrayDao;
import filmsAndActors.model.persist.ActorDaoInterface;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Edgar
 */
public class ActorServlet extends HttpServlet {

    private ActorDaoInterface actorDao;

    public void init() throws ServletException {
        this.actorDao = new ActorArrayDao();

        Actor actor1 = new Actor("nameActor1", 1999);
        Actor actor2 = new Actor("nameActor2", 1555);
        Actor actor3 = new Actor("nameActor3", 1444);

        actorDao.add(actor1);
        actorDao.add(actor2);
        actorDao.add(actor3);
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
                case "list_all_actors": //list all actors
                    listAllActors(request, response);
                    //http://localhost:8080/ActorFilmServelt/ActorServlet?action=list_all_actors
                    break;
                case "list_all_actors_json": //list all actors json
                    listAllActorsJson(request, response);
                    //http://localhost:8080/ActorFilmServelt/ActorServlet?action=list_all_actors_json
                    break;
                case "list_actor_by_name": //list actor by name
                    listActorByName(request, response);
                    break;
                case "list_actor_by_name_json": //list actor by name json
                    listActorByNameJson(request, response);
                    break;
                case "add_new_actor": //add
                    addNewActor(request, response);
                    break;
                case "modify_actor": //modify
                    updateActor(request, response);
                    break;
                case "delete_actor": //delete
                    deleteActor(request, response);
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
    public void listAllActors(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Actor> entityList = (List<Actor>) actorDao.findAll();
        request.setAttribute("actors", entityList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actor/listallactors.jsp");
        rd.forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void listAllActorsJson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Actor> entityList = (List<Actor>) actorDao.findAll();
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
    public void addNewActor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //resultado = (condicion)?valor1:valor2;
        //if (condicion == true) --> resultado = valor1
        //if (condicion == false) --> resultado = valor2
        String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
        int yearBirth = (request.getParameter("yearBirth") != null) ? Integer.parseInt(request.getParameter("yearBirth")) : -1;

        Actor actor = new Actor(name, yearBirth);

        List<Actor> entityList = (List<Actor>) actorDao.findAll();
        request.setAttribute("actorslist", entityList);

        Boolean actorCreated = actorDao.add(actor);

        if (actorCreated != false) {
            request.setAttribute("actor", actor);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actor/actoradd.jsp");
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
    public void deleteActor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
        int yearBirth = (request.getParameter("yearBirth") != null) ? Integer.parseInt(request.getParameter("yearBirth")) : -1;

        Actor actor = new Actor(name, yearBirth);

        List<Actor> entityList = (List<Actor>) actorDao.findAll();
        request.setAttribute("actorslist", entityList);

        Boolean actorDeleted = actorDao.delete(actor);

        if (actorDeleted != false) {
            request.setAttribute("actors", actor);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actor/actordelete.jsp");
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
    public void updateActor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
        int yearBirth = (request.getParameter("yearBirth") != null) ? Integer.parseInt(request.getParameter("yearBirth")) : -1;

        Actor actor = new Actor(name, yearBirth);

        List<Actor> entityList = (List<Actor>) actorDao.findAll();
        request.setAttribute("actorslist", entityList);

        Boolean actorUpdated = actorDao.update(actor);

        if (actorUpdated != false) {
            request.setAttribute("actor", actor);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actor/actorupdate.jsp");
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
    private void listActorByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
        String name = request.getParameter("name");
        List<Actor> entityList = (List<Actor>) actorDao.FindByName(name);
        request.setAttribute("actors", entityList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actor/listallactors.jsp");
        rd.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void listActorByNameJson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //List<Actor> entityList =  (List<Actor>) actorDao.findAll();
        //try (PrintWriter out = response.getWriter()) {
        //out.print(new Gson().toJson(entityList));
        // } 

        String name = request.getParameter("name");
        List<Actor> entityList = (List<Actor>) actorDao.FindByName(name);
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
                errorMsg = "Error Add Actor";
                break;
            case 3:
                errorMsg = "Error update. Actor does not exist";
                break;
            default: // need parameter action
                errorMsg = "Parameter action needed";
        }
        response.sendError(response.SC_BAD_REQUEST, errorMsg);
    }
}
