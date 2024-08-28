package controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "workDetailsServlet", urlPatterns = {"/work-details"})
public class workDetailsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Définir le type de contenu
        response.setContentType("text/html");

        // Récupérer l'ID de l'œuvre dans la requête
        String id = request.getParameter("id");

        // Récupérer l'œuvre dans le catalogue à partir de l'ID
        Work work = Catalogue.listOfWorks.stream()
                .filter(w -> w.getId() == Long.parseLong(id))
                .findFirst()
                .orElse(null);  // Gérer le cas où l'œuvre n'existe pas

        // Vérifier si l'œuvre existe, sinon afficher un message d'erreur
        if (work != null) {
            // Stocker l'œuvre dans la requête
            request.setAttribute("work", work);

            // Transférer la requête à la JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/work-details.jsp");
            dispatcher.forward(request, response);
        } else {
            // En cas d'erreur, afficher un message (ou rediriger vers une page d'erreur)
            response.getWriter().print("L'œuvre demandée n'a pas été trouvée.");
        }
    }
}
