package proven.friends.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import java.util.List;
import javax.servlet.RequestDispatcher;
import proven.friends.model.Friend;
import proven.friends.model.persist.FriendArrayDao;
import proven.friends.model.persist.FriendDaoInterface;

/**
 * Servlet to resolve requests in Friends application
 * @author Jose
 */
public class FriendServlet extends HttpServlet {

    private FriendDaoInterface friendDao;    
    
    
    @Override
    public void init() throws ServletException {
        this.friendDao = new FriendArrayDao();
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
       doAction(request, response);

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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * <strong>doAction()</strong>
     * executes actions to manage categories.
     * @param request
     * @param response
     */
    public void doAction(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "list_all_friends": //list all friends
                    //listAllFriendsJson(request, response);
                    listAllFriendsHtml(request, response);
                    break;
                case "list_friend_by_phone": //list friend by phone
                    //TODO
                    break;
                case "add_new_friend": //add
                    //TODO
                    break; 
                case "modify_friend": //modify
                    //TODO
                    break;
                case "delete_friend": //delete
                    //TODO
                    break;
                default: //unknown option.
                    redirectError(request,response, 1);
                    break;
            }               
        } else { // parameter action needed
            redirectError(request,response, 2);
        }   
    }

    /**
     * serves a list of all friends
     * @param request
     * @param response
     */
    public void listAllFriendsJson(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        List<Friend> entityList =  (List<Friend>) friendDao.findAll();
        try (PrintWriter out = response.getWriter()) {
            out.print(new Gson().toJson(entityList));
        } 
    }

    /**
     * serves a list of all friends
     * @param request
     * @param response
     */
    public void listAllFriendsHtml(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        List<Friend> entityList =  (List<Friend>) friendDao.findAll();
        request.setAttribute("friends", entityList);
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/listallfriends.jsp");
	rd.forward(request, response);
    }
    
     /**
     * serves Bad Request errors with HTTP Status 400
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
                default: // need parameter action
                    errorMsg = "Parameter action needed";
        }            
        response.sendError(response.SC_BAD_REQUEST, errorMsg);
    }
}
