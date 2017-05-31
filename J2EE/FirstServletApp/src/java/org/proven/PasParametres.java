/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proven;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumne
 */
public class PasParametres extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");

        out.println("<html>");
        out.println("<body>");
        out.println("<head>");

        out.println("<title>Request Parameters</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");

        out.println("<h3>Request Parameters</h3>");

        out.println("<p>");
        if (firstName != null || lastName != null) {
            out.println("First Name ");
            out.println(" = " + firstName + "<br>");
            out.println("Last Name  ");
            out.println(" = " + lastName);
        } else {
            out.println("No Parameters, Please enter some");
        }
        out.println("</p>");
        out.print("<form action=\"");
        out.print("PasParametres\" ");
        out.println("method='post'>");
        out.println("First Name");
        out.println("<input type=text size=20 name='firstname'/>");
        out.println("<br>");
        out.println("Last Name");
        out.println("<input type=text size=20 name='lastname'/>");
        out.println("<br>");
        out.println("<input type='submit'/>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

}
