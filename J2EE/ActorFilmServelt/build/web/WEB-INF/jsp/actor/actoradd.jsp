<%-- 
    Document   : actoradd
    Created on : 17/02/2017, 12:25:04
    Author     : alumne
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="filmsAndActors.model.Actor"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actor Added</title>
        <style type="text/css">
            table td {
                border: solid thin blue;
            }
        </style>
    </head>
    <body>
        <h1>Actor Added</h1>
        <%
            List<Actor> data = (List<Actor>) request.getAttribute("actorslist");
            Actor actor = (Actor) request.getAttribute("actor");
                     
            out.println(" <table border='1'> ");
            out.println("<tr>");
            out.println(" <th>Name</th> ");
            out.println(" <th>YearBirth</th> ");
           
             out.println("</tr>");
              out.println("<tr>");
            for (Actor a: data) {
                out.println("<tr>");
                out.println(String.format("<td>%s</td>", a.getName()));
                out.println(String.format("<td>%s</td>", a.getYearBirth()));
                 out.println("</tr>");
            } 
            out.println("</tr>");
            //out.println(String.format("<li>%s</li>", actor.toString()));
             out.println(" </table> ");
        %>
    </body>
</html>