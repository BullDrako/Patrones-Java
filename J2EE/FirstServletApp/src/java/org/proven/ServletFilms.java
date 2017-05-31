/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proven;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
/**
 *
 * @author alumne
 */
public class ServletFilms extends HttpServlet {

    

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
       //response.setContentType("text/xml");
       PrintWriter out = response.getWriter();
       
       String query = request.getParameter("query");
       String type = request.getParameter("type");
      
      List<String> Actors = new ArrayList<String>();
      Actors.add("actor1");
      Actors.add("actor2");
      Actors.add("actor3");
      
      List<String> Titles = new ArrayList<String>();
      Titles.add("title1");
      Titles.add("title2");
      Titles.add("title3");
      
        if (query != null || type != null) {
            
            //actors xml
            if(query.equals("actors") && type.equals("xml")){ 
                
                response.setContentType("text/xml");
                out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                out.println("<films>"); 
                //out.println("<actor>" + Actors + "</actor>");
                for(int i=0; i<Actors.size(); i++){
                    out.println("<actor>" + Actors.get(i) + "</actor>");
                }
                out.println("<type>" + type + "</type>");
                out.println("</films>");
            } 
            //actors json
            else if(query.equals("actors") && type.equals("json")){ 
                response.setContentType("text/json");
                for(int i=0; i<Actors.size(); i++){
                    out.println("[{ \"nombre Actor\":  \"" + Actors.get(i) + "\" }, "
                        + "{\"type\":" + " \"" + type + "\" }]"  );
                }
                /*out.println("[{ \"nombre Actor\":  \"" + query + "\" }, "
                        + "{\"type\":" + " \"" + type + "\" }]"  );*/
            }
            //title xml
            else if(query.equals("title") && type.equals("xml")){ 
                response.setContentType("text/xml");
                out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                out.println("<films>"); 
                for(int i=0; i<Actors.size(); i++){
                    out.println("<title>" + Titles.get(i) + "</title>");
                }
                //out.println("<title>" + query + "</title>");
                out.println("<type>" + type + "</type>");
                out.println("</films>");

            //title json
            } else if(query.equals("title") && type.equals("json")){ 
                response.setContentType("text/json");
                for(int i=0; i<Titles.size(); i++){
                    out.println("[{ \"Title\":  \"" + Titles.get(i) + "\" }, "
                        + "{\"type\":" + " \"" + type + "\" }]"  );
                }
                /*out.println("[{ \"Title\":  \"" + query + "\" }, "
                        + "{\"type\":" + " \"" + type + "\" }]"  );*/
            }          
        } else {
            out.println("No Parameters, Please enter some");
        }
        
        
        
        //http://localhost:8080/servlets/ServletFilms?query=actors&type=xml
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
         doGet(request, response);
    }

   
}
