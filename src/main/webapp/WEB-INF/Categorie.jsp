<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des Categorie</title>
</head>
<body>

<h1 style="text-align: center;">Gestion des Categories</h1>
<hr /> <br />

<div style="width: 50%; position: relative; left: 25%" >
	<form method="post" action="categorie/save">
		<fieldset>
			<legend>${categorieBean.label} d'une Categorie</legend>
			<table width="100%" cellpadding="5">
				<tr>
					<td> ID </td>
					<td> <input type="text" name="id_categorie" value="${categorieBean.categorie.id_categorie}"
								style="width: 100%; background-color: silver;"
								readonly="readonly" /> </td>
				</tr>
				
				<tr>
					<td> NomCategorie </td>
					<td> <input type="text" name="nomCategorie" value="${categorieBean.categorie.nomCategorie}"
								style="width: 100%;" required/> </td>
				</tr>
			
			
				<tr>
					<td colspan="2" style="text-align: right;"> 
					<input type="submit" value="save" /> </td>
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
			<th>nomCategorie</th>
			<th>Modifier</th>
			<th>Supprimer</th>
			
		</tr>
		
		<c:forEach items="${categorieBean.categories}" var="f">
			<tr>
				<td>${f.id_categorie}</td>
				<td>${f.nomCategorie}</td>
				<td><a href="categorie/modify?id_categorie=${f.id_categorie}"> <img src="img/b_edit.png" /> </a> </td>
				<td><a href="categorie/delete?id_categorie=${f.id_categorie}"> <img src="img/b_drop.png" /> </a> </td>
			</tr>
		</c:forEach>
		
		<tfoot>
			<tr>
				<td colspan="5"> Nombre total des categories est : ${categorieBean.categories.size()} </td>
			</tr>
		</tfoot>
	</table>
</div>

</body>
</html>