package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author damien
 */
@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/login"})
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        
        if ("michel".equals(userName)) {
            if ("123456".equals(password)) {
                out.print("<html><body><a href=\"home\">Home</a></body></html>");
            } else {
                out.print("<html><body>Login / Mot de passe erroné. <a href=\"login.html\">Réessayer</a></body></html>");
            }
        } else if ("caroline".equals(userName)) {
            if ("abcdef".equals(password)) {
                out.print("<html><body><a href=\"home\">Home</a></body></html>");
            } else {
                out.print("<html><body>Login / Mot de passe erroné. <a href=\"login.html\">Réessayer</a></body></html>");
            }
        } else {
            out.print("<html><body>Utilisateur non reconnu. <a href=\"login.html\">Réessayer</a></body></html>");
        }
    }           
}
