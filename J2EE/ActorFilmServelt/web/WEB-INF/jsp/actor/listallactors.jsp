<%-- 
    Document   : listallactors
    Created on : 16-feb-2017, 17:31:56
    Author     : Edgar
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="filmsAndActors.model.Actor"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actor list</title>
        <style type="text/css">
            table td {
                border: solid thin blue;
            }
        </style>
    </head>
    <body>
        <h1>List of actors</h1>
        <%
            List<Actor> data = (List<Actor>) request.getAttribute("actors");
            
            //out.println(data.toString());
           /* out.println("<tr>");
            for (Actor a: data) {
                out.println(String.format("<p><td>%s</td></p>", a.toString()));
            }
            out.println("</tr>");*/
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
            out.println(" </table> ");
        %>
       
    </body>
</html>