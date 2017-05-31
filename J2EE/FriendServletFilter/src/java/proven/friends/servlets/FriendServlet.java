/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.friends.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvcpractica.model.Friend;
import mvcpractica.model.persist.FriendArrayDao;
import mvcpractica.model.persist.FriendDao;

/**
 *
 * @author alumne
 */
public class FriendServlet extends HttpServlet {

    private FriendDao friendDao;
    
    public void init()throws ServletException{
        this.friendDao = new FriendArrayDao();
        /* private void inputData() {
        model.insertFilm(new Film("Fast and Furious", "Rob Cohen", "A race film", 2001));
        model.insertFilm(new Film("Avatar", "James Cameron", "a Science fictions film", 2009));
        model.insertFilm(new Film("The expendables", "Sylvester Stallone", "An action film", 2010));
    }*/
        Friend friend1 = new Friend("111", "pepe", 21);
        Friend friend2 = new Friend("222", "pepe2", 22);
        Friend friend3 = new Friend("333", "pepe3", 23);
        
        friendDao.add(friend1);
        friendDao.add(friend2);
        friendDao.add(friend3);
        
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
        //response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          /*  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FriendServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FriendServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
          doAction(request, response);
    }
    
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
                    //http://localhost:8080/FriendServlet/FriendServlet?action=list_all_friends
                    break;
                 case "list_friend_by_phone": //list friend by phone
                    //TODO
                    listFriendByPhone(request, response);
                    break;    
                case "list_friend_by_name": //list friend by phone
                    //TODO
                    listFriendByPhone(request, response);
                    break;
                case "add_new_friend": //add
                    addNewFriend(request, response);
                    break; 
                case "modify_friend": //modify
                    updateFriend(request, response);
                    break;
                case "delete_friend": //delete
                    deleteFriend(request, response);
                    break;
                default: //unknown option.
                    redirectError(request,response, 1);
                    break;
            }               
        } else { // parameter action needed
            redirectError(request,response, 2);
        }   
    }
    
    public void listAllFriendsHtml(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        List<Friend> entityList =  (List<Friend>) friendDao.findAll();
        request.setAttribute("friends", entityList);
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/listallfriends.jsp");
	rd.forward(request, response);
    }
    
     public void listFriendByPhone(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        String phone = request.getParameter("phone");
        List<Friend> entityList = (List<Friend>) friendDao.findByPhone(phone);
        request.setAttribute("friendbyphone", entityList);
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/listfriendbyphone.jsp");
	rd.forward(request, response);
    }
    public void listFriendByName(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Friend> entityList = (List<Friend>) friendDao.FindByName(name);
        request.setAttribute("friendbyname", entityList);
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/listfriendbyname.jsp");
	rd.forward(request, response);
    }
    
    public void addNewFriend(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
                
        String phone = (request.getParameter("phone") != null) ? request.getParameter("phone") : "";
        String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
        int age = (request.getParameter("age") != null) ? Integer.parseInt(request.getParameter("age")) : -1;
        
        Friend friend  = new Friend(phone, name, age);
        
        Boolean friendCreated = friendDao.add(friend);
        
        if(friendCreated != false){
            request.setAttribute("friends", friend);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/addfriend.jsp");
            rd.forward(request, response);
        } /*else{
            error(request, response, "can't create friend.");
        }*/
    }
    
     public void deleteFriend(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String phone = (request.getParameter("phone") != null) ? request.getParameter("phone") : "";
        String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
        int age = (request.getParameter("age") != null) ? Integer.parseInt(request.getParameter("age")) : -1;
        
        Friend friend  = new Friend(phone, name, age);
        
        Boolean friendDeleted = friendDao.delete(friend);
        
        if(friendDeleted != false){
            request.setAttribute("friends", friend);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/listallfriends.jsp");
            rd.forward(request, response);
        } else{
            //error(request, response, "can't delete friend.");
            
        }
    }
     
    public void updateFriend(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String phone = (request.getParameter("phone") != null) ? request.getParameter("phone") : "";
        String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
        int age = (request.getParameter("age") != null) ? Integer.parseInt(request.getParameter("age")) : -1;
        
        Friend friend  = new Friend(phone, name, age);
        
        Boolean friendUpdated = friendDao.update(friend);
        
        if(friendUpdated != false){
            request.setAttribute("friends", friend);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/listallfriends.jsp");
            rd.forward(request, response);
        } /*else{
            error(request, response, "can't update friend.");
        }*/
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

   /* private void error(HttpServletRequest request, HttpServletResponse response, String it_cant_create_friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
