<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.OutputStream"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Gestion des articles</title>
</head>
<body>

<h1 style="text-align: center;">Gestion des articles</h1>
<hr /> <br />

<div style="width: 50%; position: relative; left: 25%" >
    <form method="get" action="article/save" enctype="multipart/form-data">
        <fieldset>
            <legend>${articleBean.label} d'un article</legend>
            <table width="100%" cellpadding="5">
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id_article" value="${articleBean.article.id_article}"
                               style="width: 100%; background-color: silver;" readonly="readonly"/></td>
                </tr>

                <tr>
                    <td>Nom de l'article</td>
                    <td><input type="text" name="nomArticle" value="${articleBean.article.nomArticle}" style="width: 100%;" required/></td>
                </tr>
                <tr>
                    <td>Désignation</td>
                    <td><input type="text" name="designation" value="${articleBean.article.designation}" style="width: 100%;" required/></td>
                </tr>
                <tr>
                    <td>Prix</td>
                    <td><input type="text" name="prix" value="${articleBean.article.prix}" style="width: 100%;" required/></td>
                </tr>
              

                <tr>
                    <td>Catégorie</td>
                    <td>
                        <select name="nomCategorie" style="width: 100%;">
                            <c:forEach items="${articleBean.nomCategories}" var="l">
                                <option value="${l}" style="color: blue;">${l}</option>
                            </c:forEach>
                        </select>
                    </td>
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
            <th>Nom de l'article</th>
            <th>Désignation</th>
            <th>Prix</th>
            <th>Nom de la catégorie</th>
            <th>Modifier</th>
            <th>Supprimer</th>
        </tr>

        <c:forEach items="${articleBean.articles}" var="f">
            <tr>
                <td>${f.id_article}</td>
                <td>${f.nomArticle}</td>
                <td>${f.designation}</td>
                <td>${f.prix}</td>
                <td>${f.categorie.nomCategorie}</td>
                <td><a href="${request.contextPath}/article/modify?id_article=${f.id_article}"><img src="${request.contextPath}/img/b_edit.png" /></a></td>
                <td><a href="${request.contextPath}/article/delete?id_article=${f.id_article}"><img src="${request.contextPath}/img/b_drop.png" /></a></td>
            </tr>
        </c:forEach>

        <tfoot>
        <tr>
            <td colspan="8">Nombre total des articles : ${articleBean.articles.size()}</td>
        </tr>
        </tfoot>
    </table>
</div>

</body>
</html>
