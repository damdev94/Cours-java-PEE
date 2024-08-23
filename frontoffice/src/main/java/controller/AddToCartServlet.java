/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.directmedia.onlinestore.core.ShoppingCart;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author damien
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCart"})
public class AddToCartServlet extends HttpServlet {
    
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        PrintWriter out=response.getWriter();
        
        String id = request.getParameter("identifiant");
        HttpSession session = request.getSession();
        
        
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);  // Sauvegarde le panier dans la session
        }
        
        Optional<Work> work = Catalogue.listOfWorks.stream()
                .filter(w -> w.getId() == Long.parseLong(id))
                .findAny();
        if(work.isPresent()){
            cart.getItems().add(work.get());
        }
         
         out.print("<html><body>L'oeuvre a bien été ajouter au caddie(" + cart.getItems().size() + ")</html></body>");
         out.print("<html><body><a href=\"catalogue\">retour au catalogue</a></html></body>");
        
    }

}
