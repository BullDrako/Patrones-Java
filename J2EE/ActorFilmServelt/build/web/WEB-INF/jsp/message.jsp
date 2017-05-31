<%-- 
    Document   : message.jsp
    Created on : 01/03/2017, 12:23:31
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Correct!</h1>
        <% String data = (String) request.getAttribute("mgs");
        if(data != null){
           out.print(data); 
        }
        %>
    </body>
</html>
