package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String releaseParam = request.getParameter("release");
        String summary = request.getParameter("summary");
        String artist = request.getParameter("artist");

        Work nouvelleOeuvre = new Work(title);
        nouvelleOeuvre.setSummary(summary);
        nouvelleOeuvre.setArtist(new Artist(artist));
        nouvelleOeuvre.setGenre(genre);

        try {
            // Valider et convertir l'année de parution
            int release = Integer.parseInt(releaseParam);

            // Vérifier si l'année est valide (par exemple, positive)
            if (release <= 0) {
                request.setAttribute("errorMessage", "L'année de parution doit être un entier positif.");
                request.getRequestDispatcher("/WorkAddedFailureServlet").forward(request, response);
                return;
            }

            nouvelleOeuvre.setRelease(release);
            
            Optional<Work> optionalWork = Catalogue.listOfWorks.stream()
                .filter(work -> work.getTitle().equals(nouvelleOeuvre.getTitle()) && work.getRelease() == nouvelleOeuvre.getRelease())
                .findAny();
            
            if (optionalWork.isPresent()) {
                // Redirection ou affichage d'un message d'erreur si l'œuvre existe déjà
                request.setAttribute("errorMessage", "Une œuvre avec ce titre et cette année existe déjà.");
                request.getRequestDispatcher("/WorkAddedFailureServlet").forward(request, response);
                return;
            }

            // Ajouter l'œuvre au catalogue
            Catalogue.listOfWorks.add(nouvelleOeuvre);

            // Redirection vers le servlet de succès
            response.sendRedirect(request.getContextPath() + "/WorkAddedSuccessServlet");

        } catch (NumberFormatException e) {
            // Gérer les cas où releaseParam n'est pas un entier
            request.setAttribute("errorMessage", "L'année de parution n'est pas un entier valide.");
            request.getRequestDispatcher("/WorkAddedFailureServlet").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Optionnel : vous pouvez décider de gérer GET si nécessaire
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
