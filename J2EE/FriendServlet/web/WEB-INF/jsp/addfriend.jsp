<%-- 
    Document   : addfriend
    Created on : 03/02/2017, 12:50:35
    Author     : alumne
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mvcpractica.model.Friend"%>
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
            List<Friend> datas = (List<Friend>) request.getAttribute("friends");
            //Friend f = (Friend)request.getAttribute("friends");
            //String phone = (String) request.getAttribute("phone");
           // String name = (String) request.getAttribute("name");;
          //  int age = Integer.parseInt(request.getParameter("age"));
            
            
            //out.println(data.toString());
            out.println("<ul>");
             //out.println(String.format("<li>%s</li>", phone.toString()));
               // out.println(String.format("<li>%s</li>", f.toString()));
               
               for (Friend fr: datas) {
                   
                out.println(String.format("<li>%s</li>", fr.toString()));
                 //out.println(String.format("<li>%s</li>", phone.toString()));
               // out.println(String.format("<li>%s</li>", name.toString()));
                //out.println(String.format("<li>%s</li>", age));
            }
               
               
                  
            out.println("</ul>");
            
//out.println(String.format("<li>%s</li> friend added"));
        %>
    </body>
</html>