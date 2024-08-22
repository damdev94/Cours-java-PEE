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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author damien
 */
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Work nouvelleOeuvre= new Work(request.getParameter("title"));
        nouvelleOeuvre.setGenre(request.getParameter("genre"));
        nouvelleOeuvre.setRelease(Integer.parseInt(request.getParameter("release")));
        nouvelleOeuvre.setSummary(request.getParameter("summary"));
        nouvelleOeuvre.setArtist(new Artist(request.getParameter("artist")));
        
        Catalogue.listOfWorks.add(nouvelleOeuvre);
        
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<html><body>Le film a été ajouté <a href=\"home\">Retourner à la page d'acceuil</a></body></html>");
    }

    
}
