<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    h1 {
        color: #333;
    }
    form {
        width: 300px;
        margin: 0 auto;
    }
    label {
        display: block;
        margin-top: 10px;
    }
    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
    }
    select {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
    }
    input[type="submit"] {
        display: block;
        width: 100%;
        padding: 8px;
        margin-top: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    h2 {
        color: red;
        text-align: center;
    }
</style>
</head>
<body>
    <h1>Sign Up</h1>
    <form action="signup" method="post">
        <label for="role">Role:</label><br>
        <select id="role" name="role">
            <option value="admin">Admin</option>
            <option value="acheteur">Acheteur</option>
            <option value="vendeur">Vendeur</option>
        </select><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br>
        <label for="nom">Nom:</label><br>
        <input type="text" id="nom" name="nom" required><br>
        <label for="prenom">Prènom:</label><br>
        <input type="text" id="prenom" name="prenom" required><br>
        <label for="tel">Numero de téléphone:</label><br>
        <input type="text" id="tel" name="tel" required><br>
        <label for="adresse">Adresse:</label><br>
        <input type="text" id="adresse" name="adresse" required><br>
        <input type="submit" value="Sign Up">
    </form>
    <h2>${errorMessage}</h2>
</body>
</html>