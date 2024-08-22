package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet d'accueil pour OnlineStore
 * @author damien
 */
@WebServlet(name = "homeServlet", urlPatterns = {"/home"})
public class homeServlet extends HttpServlet {

    // Méthode pour gérer les requêtes GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Définir le type de contenu
        response.setContentType("text/html;charset=UTF-8");
        
        // Écrire du contenu HTML dans la réponse
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body><h1>Bienvenue sur OnlineStore, votre boutique multimédia en ligne</h1>");
            
            out.print("<a href=\"catalogue\">Accès au catalogue<a/>");
            
            out.print("</body></html>");
        }
    }

    // Méthode pour gérer les requêtes POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // Retourner des informations sur la servlet
    @Override
    public String getServletInfo() {
        return "Servlet qui affiche la page d'accueil d'OnlineStore";
    }
}
