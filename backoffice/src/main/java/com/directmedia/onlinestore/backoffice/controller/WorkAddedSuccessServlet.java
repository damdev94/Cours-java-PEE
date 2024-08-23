
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WorkAddedSuccessServlet", urlPatterns = {"/WorkAddedSuccessServlet"})
public class WorkAddedSuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<html><body>L'oeuvre a bien été ajoutée.");
        out.print("<a href=\"catalogue\">Retour au catalogue</a>");
        out.print("</body></html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Vous pouvez rediriger vers la méthode doGet ou gérer POST ici si nécessaire
        doGet(request, response);
    }
}