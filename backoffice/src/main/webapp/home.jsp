<%-- 
    Document   : home
    Created on : 27 août 2024, 18:01:24
    Author     : damien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>onlinestore - Acceuil du back-office</title>
    </head>
    <body>
        <h1>OnlineStore – Gestion de la boutique</h1>
        
<%
    if (session != null) {
        String username = (String) session.getAttribute("userName");
        if (username != null) {
%>
            Bonjour <%= username %> ! <a href="Logout">Déconnexion</a>
<%
        }
%>
    <a href="add-work-form.html">Ajouter une oeuvre au catalogue</a> <br/>
    <a href="/catalogue">Accès au catalogue</a> <br/>
<%
    }
%>
    </body>
</html>
