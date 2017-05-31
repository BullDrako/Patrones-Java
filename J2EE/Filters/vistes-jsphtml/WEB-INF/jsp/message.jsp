<%-- 
    Document   : listallfriends
    Created on : 11-sep-2016, 13:03:46
    Author     : Jose
--%>

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
        <h1>Message</h1>
        <%
            String data = (String) request.getAttribute("message");
            out.println(data);
        %>
    </body>
</html>
