/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author damien
 */
@WebServlet(name = "catalogue", urlPatterns = {"/catalogue"})
public class catalogue extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Création des artistes
    Artist leonard_de_vinci = new Artist("Léonard de Vinci");
    Artist vincent_van_gogh = new Artist("Vincent Van Gogh");
    Artist edvard_munch = new Artist("Edvard Munch");

    // Création des œuvres
    Work mona_lisa = new Work("Mona Lisa");
    mona_lisa.setArtist(leonard_de_vinci);
    mona_lisa.setGenre("Portrait");
    mona_lisa.setSummary("La \"Mona Lisa\" est un portrait de Lisa Gherardini...");
    mona_lisa.setRelease(1503);

    Work la_nuit_etoilee = new Work("La nuit étoilée");
    la_nuit_etoilee.setArtist(vincent_van_gogh);
    la_nuit_etoilee.setGenre("Post-impressionnisme");
    la_nuit_etoilee.setSummary("\"La Nuit étoilée\" représente une vue nocturne...");
    la_nuit_etoilee.setRelease(1889);

    Work le_cri = new Work("Le Cri");
    le_cri.setArtist(edvard_munch);
    le_cri.setGenre("Expressionnisme");
    le_cri.setSummary("\"Le Cri\" est une représentation intense...");
    le_cri.setRelease(1893);

    // Ajout des œuvres au catalogue
    Catalogue.listOfWorks.add(mona_lisa);
    Catalogue.listOfWorks.add(la_nuit_etoilee);
    Catalogue.listOfWorks.add(le_cri);

    // Ajout de la liste des œuvres en tant qu'attribut de requête
    request.setAttribute("listedesoeuvres", Catalogue.listOfWorks);

    // Forward vers la page JSP
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/catalogue.jsp");
    dispatcher.forward(request, response);
    
    System.out.println("Nombre d'oeuvres dans le catalogue : " + Catalogue.listOfWorks.size());
    for (Work work : Catalogue.listOfWorks) {
    System.out.println("Oeuvre : " + work.getTitle());
}

}

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
