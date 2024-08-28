<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails de l'œuvre</title>
    </head>
    <body>
        <h1>Détails de l'œuvre</h1>
        
        <!-- Afficher les détails de l'œuvre -->
        <p><strong>Titre :</strong> ${work.title}</p>
        <p><strong>Année de parution :</strong> ${work.release}</p>
        <p><strong>Genre :</strong> ${work.genre}</p>
        <p><strong>Artiste :</strong> ${work.artist}</p>
        <p><strong>Résumé :</strong> ${work.summary}</p>

        <!-- Formulaire pour ajouter l'œuvre au panier -->
        <form action="AddToCart" method="POST">
            <input type="hidden" name="identifiant" value="${param.id}" />
            <input type="submit" value="Ajouter au panier" />
        </form>
    </body>
</html>
