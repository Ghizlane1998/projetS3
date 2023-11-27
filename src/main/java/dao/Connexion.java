
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {

	private static Connection connection = null;
	
	private static void seConnecter()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/revente";
			String user = "root";
			String passwd = "";
			
			connection = DriverManager.getConnection(url, user, passwd);
			
			System.out.println("Connexion etablie ...");
			
		} catch (Exception e) 
		{
			System.out.println("Probleme de connexion ..."+ e.getMessage());
		}
	}
	
	public static Connection getConnexion()
	{
		if(connection == null)
			seConnecter();
		
		return connection;
	}
}
