package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.AdminDao;
import dao.Connexion;
import entities.Admin;


public class AdminDaoImpl implements AdminDao{
	private Connection connection ;

	   public AdminDaoImpl(Connection connection) {
		   this.connection = connection;
	}

	//private AdminDao admindao = new AdminDaoImpl();
	@Override
	public boolean create(Admin admin) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
		 	return false;
			
			try {
				PreparedStatement ps = this.connection.prepareStatement
						("insert into admin (email,password,role) values (?, ?, ?);");
				
				ps.setString(1, admin.getEmail());
				ps.setString(2, admin.getPassword());
				ps.setString(3, admin.getRole());
				//execution de la requete SQL
				ps.executeUpdate();
				ps.close();
				System.out.println("Admin bien Ajoutee !! ...");
				
				return true;
				
			} catch (SQLException e) {
				System.out.println("Probleme lors de l'ajout de Admin"+e.getMessage());
			}
			
			return false;
		}

	@Override
	public boolean update(Admin admin) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("update admin set email = ?, password = ? ,role=?  where id_admin = ?");
			ps.setString(1, admin.getEmail());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getRole());
			// execution de la requete SQL
			ps.executeUpdate();
			ps.close();
			
			System.out.println("Admin bien Modifiee !!...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification de Admin "+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Admin admin) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("delete from admin where id_admin = ?");
			
			ps.setInt(1, admin.getIdAdmin());

			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("admin bien supprim�e !! ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la supression de admin "+e.getMessage());
		}
		return false;
	}

	@Override
	public Admin getById(int id) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from admin where id_admin = ? ");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				Admin admin = new Admin();
				admin.setIdAdmin(rs.getInt("id_admin"));
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setRole(rs.getString("role"));
				rs.close();
				ps.close();
				
				return admin;
			}
			
		} catch (SQLException e) {
			System.out.println("Probleme dans admin getById "+e.getMessage());
		}
		
		return null;
	}
   public Admin getByEmail(String email) {
	   connection = Connexion.getConnexion();
	   if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from admin where email = ? ");
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				Admin admin = new Admin();
				admin.setIdAdmin(rs.getInt("id_admin"));
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setRole(rs.getString("role"));
				rs.close();
				ps.close();
				
				return admin;
			}
			
		} catch (SQLException e) {
			System.out.println("Probleme dans admin getByEmail "+e.getMessage());
		}
		return null;
	}
   // Pas utile pour l'admin
	@Override
	public List<Admin> getAll() {
	
		return null;
	}
	 // Pas utile pour l'admin
	@Override
	public List<String> getAllFields() {
		// TODO Auto-generated method stub
		return null;
	}

}
