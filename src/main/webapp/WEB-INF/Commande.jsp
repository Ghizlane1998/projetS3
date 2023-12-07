<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.OutputStream"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="entities.Commande" %>
<%@ page import="entities.LigneCommande" %>

<!DOCTYPE html>
<html>
<head>
   <script>
        function setCurrentDate() {
            var currentDate = new Date();
            var day = currentDate.getDate();
            var month = currentDate.getMonth() + 1; // Les mois commencent à 0
            var year = currentDate.getFullYear();
            var formattedDate = year + '-' + (month < 10 ? '0' : '') + month + '-' + (day < 10 ? '0' : '') + day;

            document.getElementById('dateCommande').value = formattedDate;
        }
    </script>

    <meta charset="ISO-8859-1">
    <title>Gestion des commandes</title>
</head>
<body>

<h1 style="text-align: center;">Gestion des commandes</h1>
<hr /> <br />

<div style="width: 50%; position: relative; left: 25%" >
    <form method="get" action="commande/save">
        <fieldset>
            <legend>${commandeBean.label} d'une commande</legend>
            <table width="100%" cellpadding="5">
         
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id_commande" value="${commandeBean.commande.id_commande}"
                               style="width: 100%; background-color: silver;" readonly="readonly"/></td>
                </tr>
                
                <tr>
                    <td>Numéro de commande</td>
                    <td><input type="text" name="numeroCommande" value="${commandeBean.commande.numeroCommande}"
                     style="width: 100%;  "  required/></td>
                </tr>
               <tr>
                    <td>Date de commande</td>
                    <td>
                        <input type="text" id="dateCommande" name="dateCommande" readonly/>
                        <button type="button" onclick="setCurrentDate()">Utiliser la date actuelle</button>
                    </td>
                </tr>
                
               
       
                
                <tr>
                    <td>Nom de l'Article</td>
                    <td>
                        <select name="nomArticle" style="width: 100%;">
                            <c:forEach items="${commandeBean.nomArticles}" var="l">
                                <option value="${l}" style="color: blue;">${l}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td>Quantité</td>
                    <td><input type="text" name="qteCommande" style="width: 100%;" required/></td>
                </tr>

                <tr>
                    <td colspan="3" style="text-align: right;">
                        <input type="submit" value="Enregistrer" />
                    </td>
                </tr>

            </table>
        </fieldset>
    </form>
</div>
<br /><br />

<div style="width: 60%; position: relative; left: 20%" >
    <table width="100%" cellpadding="3" border="1" style="text-align: center;">
        <tr>
            <th>ID</th>
            <th>Numéro de commande</th>
            <th>Date de commande</th>
            <th>Acheteur</th>
            <th>Articles</th>
            <th>Quantité</th>
            <th>Modifier</th>
            <th>Supprimer</th>
        </tr>

        <c:forEach items="${commandeBean.commandes}" var="commande">
            <tr>
                <td>${commande.id_commande}</td>
                <td>${commande.numeroCommande}</td>
                <td>${commande.dateCommande}</td>
               <td>${commande.acheteur.nom } ${commande.acheteur.prenom}</td>
                <td>${ligneCommande.article.nomArticle}</td>
                <td>${ligneCommande.qteCommande}</td>
                <td><a href="${request.contextPath}/commande/modify?id_commande=${commande.id_commande}"><img src="img/b_edit.png" /></a></td>
                <td><a href="${request.contextPath}/commande/delete?id_commande=${commande.id_commande}"><img src="img/b_drop.png" /></a></td>
            </tr>
        </c:forEach>

        <tfoot>
        <tr>
            <td colspan="8">Nombre total des commandes : ${commandeBean.commandes.size()}</td>
        </tr>
        </tfoot>
    </table>
</div>

</body>
</html>
