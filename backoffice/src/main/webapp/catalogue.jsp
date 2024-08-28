<%-- 
    Document   : catalogue
    Created on : 27 août 2024, 18:33:21
    Author     : damien
--%>

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
    <%
        Artist leonard_de_vinci = new Artist("Léonard de vinci");
        
        Artist vincent_van_gogh = new Artist("Vincent Van Gogh");
        
        Artist edvard_munch = new Artist("Edward Munch");
        
        Work mona_lisa = new Work("Mona Lisa");
        mona_lisa.setArtist(leonard_de_vinci);
        mona_lisa.setGenre("Portrait");
        mona_lisa.setSummary("La \"Mona Lisa\" est un portrait de Lisa Gherardini, l'épouse de Francesco del Giocondo. La peinture est renommée pour le sourire énigmatique de la femme, ainsi que pour la technique de sfumato utilisée pour créer des transitions de couleur subtiles et des détails doux. Le tableau est souvent admiré pour son réalisme et sa profondeur psychologique.");
        mona_lisa.setRelease(1503);
        
        Work la_nuit_etoilee = new Work("La nuit étoilée");
        la_nuit_etoilee.setArtist(vincent_van_gogh);
        la_nuit_etoilee.setGenre("post-impressionnisme");
        la_nuit_etoilee.setSummary("\"La Nuit étoilée\" représente une vue nocturne depuis la fenêtre de la chambre de l'artiste à l'asile de Saint-Rémy-de-Provence, avec un ciel étoilé tourbillonnant au-dessus d'un village tranquille. La peinture est caractérisée par ses coups de pinceau dynamiques et expressifs, créant un effet vibrant et émotionnel qui reflète l'état intérieur tourmenté de l'artiste.");
        la_nuit_etoilee.setRelease(1889);
        
        Work le_cri = new Work("Le Cri");
        le_cri.setArtist(edvard_munch);
        le_cri.setGenre("Expressionnisme");
        le_cri.setSummary("\"Le Cri\" est une représentation intense et dramatique d'une figure centrale en train de crier, sur un pont surplombant un paysage tumultueux sous un ciel apocalyptique. L'œuvre exprime une profonde anxiété et un sentiment de désespoir, capturant l'angoisse existentielle et l'aliénation. Le tableau est emblématique du mouvement expressionniste pour son exploration émotionnelle et psychologique.");
        le_cri.setRelease(1893);
        
        Catalogue.listOfWorks.add(mona_lisa);
        Catalogue.listOfWorks.add(la_nuit_etoilee);
        Catalogue.listOfWorks.add(le_cri);
     %>    
        
        <h1>oeuvres au catalogue</h1>
        
    <%
             HashSet<Work> list = Catalogue.listOfWorks;
             for (Work work : list) {
    %>
        
        <%=work.getTitle()%>  <%=work.getRelease()%> <BR/>
        
    <%
            }
    %>
    </body>
</html>
