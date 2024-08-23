/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.directmedia.onlinestore.backoffice.controller;

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
@WebServlet(name = "WorkAddedFailureServlet", urlPatterns = {"/WorkAddedFailureServlet"})
public class WorkAddedFailureServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        out.print("<html><body>Une erreur des survenue, l'oeuvre n'a pas été ajoutée");
        out.print("<a>Catalogue</a>");
        out.print("</body></html>");
    }

    
}
