<%-- 
    Document   : catalogue
    Created on : 27 août 2024, 18:33:21
    Author     : damien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashSet"%>
<%@page import="com.directmedia.onlinestore.core.entity.Catalogue"%>
<%@page import="com.directmedia.onlinestore.core.entity.Work"%>
<%@page import="com.directmedia.onlinestore.core.entity.Artist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
    </head>
    <body>   
        
        <h1>oeuvres au catalogue</h1>
    <c:forEach items="${listedesoeuvres}" var="work">
        
        ${work.getTitle()}  ${work.getRelease()} <BR/>
        
    </c:forEach>   
    </body>
</html>
