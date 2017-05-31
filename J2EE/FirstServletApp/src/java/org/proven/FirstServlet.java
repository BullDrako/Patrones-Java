/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proven;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumne
 */
public class FirstServlet extends HttpServlet {

  
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
        PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
          
            out.println("<p>" + "by get today is " + new Date() + "</p>");
            out.println("<p>" + "Servlet path = " + this.getServletContext().getContextPath() + "</p>");
            out.println("<p>" + "Server info = " + this.getServletContext().getServerInfo() + "</p>");
            out.println("<p>" + "Servlet name = " + request.getServerName() + "</p>");
            out.println("<p>" + "Servlet method = " + request.getMethod() + "</p>");
            out.println("<p>" + "Servlet protocol = " + request.getProtocol() + "</p>");
            //out.println("<p>" + "Servlet path info = " + request.getPathInfo() + "</p>");
            out.println("</body>");
            out.println("</html>");
        
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
          PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("by post today is " + new Date());
            out.println("</body>");
            out.println("</html>");
       
    }

   
}
