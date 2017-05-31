<%-- 
    Document   : filmupdate
    Created on : 17/02/2017, 12:51:40
    Author     : alumne
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="filmsAndActors.model.Film"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Film updated</title>
        <style type="text/css">
            table td {
                border: solid thin blue;
            }
        </style>
    </head>
    <body>
        <body>
        <h1>Film updated</h1>
        <%
            List<Film> data = ( List<Film>) request.getAttribute("filmslist");
            Film film = (Film) request.getAttribute("film");
            //out.println(data.toString());
            out.println(" <table border='1'> ");
            out.println("<tr>");
            out.println(" <th>Title</th> ");
            out.println(" <th>Director</th> ");
            out.println(" <th>Description</th> ");
            out.println(" <th>Year</th> ");
           
             out.println("</tr>");
              out.println("<tr>");
            for (Film f: data) {
                out.println("<tr>");
               out.println(String.format("<td>%s</td>", f.getTitle()));
                out.println(String.format("<td>%s</td>", f.getDirector()));
                out.println(String.format("<td>%s</td>", f.getDescription()));
                out.println(String.format("<td>%s</td>", f.getYear()));
                out.println("</tr>");
            }
            out.println("</tr>");
            out.println(" </table> ");
        %>
    </body>
</html>