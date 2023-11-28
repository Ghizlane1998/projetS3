<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Login - Revente</title>
	<link rel="stylesheet" href="style.css">
    <!--Google Fonts and Icons-->
    <link
      href="https://fonts.googleapis.com/icon?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Round|Material+Icons+Sharp|Material+Icons+Two+Tone"
      rel="stylesheet"/>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@200;300;400;500;600;700;800&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"  rel="stylesheet"/>
</head>
<body>
 <div class="center">
 <form action="login" method="post">
	<div class="title">Revente</div>
	<div class="title">Hello,Login</div>
	<label for="role">Role:</label><br>
        <select id="role" name="role">
            <option>Role</option>
            <option value="admin">Admin</option>
            <option value="acheteur">Acheteur</option>
            <option value="vendeur">Vendeur</option>
        </select><br>
	       <span class="inputs">
           <span class="inputf">
     <input type="email" class="input" name="email" placeholder="Email" />
            <span class="label">Email</span>
     </span>
            <span class="inputf">
     <input type="password" class="input" name="password" placeholder="Password" />
            <span class="label">Password</span>
     </span>
        </span>
		  <button type="submit" class="btn">
          <span>Login</span>
          <div class="dots">
            <div class="dot" style="--delay: 0s"></div>
            <div class="dot" style="--delay: 0.25s"></div>
            <div class="dot" style="--delay: 0.5s"></div>
          </div>
        </button>
        <div class="text">
          New user? Create an account <a href="SignUp.jsp">Register</a>
        </div>
      </form>
    </div>
	 <h2>${errorMessage}</h2>
</body>
</html>