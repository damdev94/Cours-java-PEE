/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import java.util.Optional;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author damien
 */
@WebServlet(name = "workDetailsServlet", urlPatterns = {"/work-details"})
public class workDetailsServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String id = request.getParameter("id");
        
        Work work = Catalogue.listOfWorks.stream()
                .filter(w -> w.getId() == Long.parseLong(id))
                .findFirst().get();
        
        PrintWriter out = response.getWriter();
        
        out.print("<html><body><h1>Descriptif de l'oeuvre</h1>");
        
        out.print("Titre: " + work.getTitle() + "<br/>");
        out.print("Année de parution: " + work.getRelease() + " <br/>" );
        out.print("Genre: " + work.getGenre() + "<br/>" );
        out.print("Artiste: " + work.getArtist() + "<br/>" );
        out.print("Résumé: " + work.getSummary() + "<br/>" );
        
        
        out.print("</body></html>" );

        
    }
}

