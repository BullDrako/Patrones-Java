<%-- 
    Document   : listallfriends
    Created on : 11-sep-2016, 13:03:46
    Author     : Jose
--%>

<%@page import="java.util.List"%>
<%@page import="proven.friends.model.Friend"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friend list</title>
        <style type="text/css">
            table td {
                border: solid thin blue;
            }
        </style>
    </head>
    <body>
        <h1>List of friends</h1>
        <%
            List<Friend> data = ( List<Friend>) request.getAttribute("friends");
            //out.println(data.toString());
            out.println("<ul>");
            for (Friend f: data) {
                out.println(String.format("<li>%s</li>", f.toString()));
            }
            out.println("</ul>");
        %>
    </body>
</html>
