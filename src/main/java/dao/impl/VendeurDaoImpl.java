package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connexion;
import dao.VendeurDao;
import entities.Vendeur;

public class VendeurDaoImpl implements VendeurDao {
	private Connection connection ;

	   public VendeurDaoImpl(Connection connection) {
		   this.connection = connection;
	}
	public VendeurDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean create(Vendeur vendeur) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
		 	return false;
			
			try {
				PreparedStatement ps = this.connection.prepareStatement
						("insert into vendeur (email,password,role,nom,prenom,tel,adresse) values (?, ?, ?, ?, ?, ?, ?);");
				
				ps.setString(1, vendeur.getEmail());
				ps.setString(2, vendeur.getPassword());
				ps.setString(3, vendeur.getRole());
				ps.setString(4, vendeur.getNom());
				ps.setString(5, vendeur.getPrenom());
				ps.setString(6, vendeur.getTel());
				ps.setString(7, vendeur.getAdresse());
				//execution de la requete SQL
				ps.executeUpdate();
				ps.close();
				System.out.println("vendeur bien Ajoutee !! ...");
				
				return true;
				
			} catch (SQLException e) {
				System.out.println("Probleme lors de l'ajout de vendeur"+e.getMessage());
			}
			
		return false;
	}

	@Override
	public boolean update(Vendeur vendeur) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("update vendeur set email = ?, password = ? ,role=?,nom = ?, prenom = ? ,tel=?,adresse=?   where id_vendeur = ?");
			ps.setString(1, vendeur.getEmail());
			ps.setString(2, vendeur.getPassword());
			ps.setString(3, vendeur.getRole());
			ps.setString(4, vendeur.getNom());
			ps.setString(5, vendeur.getPrenom());
			ps.setString(6, vendeur.getTel());
			ps.setString(7, vendeur.getAdresse());
			
			// execution de la requete SQL
			ps.executeUpdate();
			ps.close();
			
			System.out.println("vendeur bien Modifiee !!...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification de vendeur "+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Vendeur vendeur) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("delete from vendeur where id_vendeur = ?");
			
			ps.setInt(1, vendeur.getIdVendeur());

			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("vendeur bien supprim�e !! ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la supression de vendeur "+e.getMessage());
		}
		return false;
	}

	@Override
	public Vendeur getById(int id) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from vendeur where id_vendeur = ? ");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				Vendeur vendeur = new Vendeur();
				vendeur.setIdVendeur(rs.getInt("id_vendeur"));
				vendeur.setEmail(rs.getString("email"));
				vendeur.setPassword(rs.getString("password"));
				vendeur.setRole(rs.getString("role"));
				vendeur.setNom(rs.getString("nom"));
				vendeur.setPrenom(rs.getString("prenom"));
				vendeur.setTel(rs.getString("tel"));
				vendeur.setAdresse(rs.getString("adresse"));
				
				rs.close();
				ps.close();
				
				return vendeur;
			}
			
		} catch (SQLException e) {
			System.out.println("Probleme dans vendeur getById "+e.getMessage());
		}
		return null;
	}
   public Vendeur getByEmail(String email) {
	   connection = Connexion.getConnexion();
	   if(this.connection == null)
 			return null;
 		
 		try {
 			PreparedStatement ps = this.connection.prepareStatement
 					("select * from vendeur where email = ? ");
 			
 			ps.setString(1, email);
 			
 			ResultSet rs = ps.executeQuery();
 			
 			if(rs != null && rs.next())
 			{
 				Vendeur vendeur = new Vendeur();
 				vendeur.setIdVendeur(rs.getInt("id_acheteur"));
 				vendeur.setEmail(rs.getString("email"));
 				vendeur.setPassword(rs.getString("password"));
 				vendeur.setRole(rs.getString("role"));
 				vendeur.setNom(rs.getString("nom"));
 				vendeur.setPrenom(rs.getString("prenom"));
 				vendeur.setPassword(rs.getString("tel"));
 				vendeur.setRole(rs.getString("adresse"));
 				rs.close();
 				ps.close();
 				
 				return vendeur;
 			}
 			
 		} catch (SQLException e) {
 			System.out.println("Probleme dans vendeur getByEmail "+e.getMessage());
 		}
		return null;
	}

	@Override
	public List<Vendeur> getAll() {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from vendeur");
			
			ResultSet rs = ps.executeQuery();
			
			List<Vendeur> vendeurs=new  ArrayList<Vendeur>();
			
			while (rs.next())
			{
				Vendeur vendeur = new Vendeur();
				vendeur.setIdVendeur(rs.getInt("id_acheteur"));
				vendeur.setEmail(rs.getString("email"));
				vendeur.setPassword(rs.getString("password"));
				vendeur.setNom(rs.getString("nom"));
				vendeur.setPrenom(rs.getString("prenom"));
				vendeur.setTel(rs.getString("tel"));
				vendeur.setAdresse(rs.getString("adresse"));
				
				vendeurs.add(vendeur);
			}
			
			rs.close();
			ps.close();
			
			return vendeurs;
			
		} catch (SQLException e) {
			System.out.println("Probleme dans acheteurs getAll "+e.getMessage());
		}
		return null;
	}

	@Override
	
	public List<String> getAllFields() {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from vendeur");
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			List<String> fields = new ArrayList<String>();
			
			for(int i=1; i<=rsmd.getColumnCount(); i++)
				fields.add(rsmd.getColumnName(i));
			
			rs.close();
			ps.close();
			
			return fields;
			
		} catch (SQLException e) {
			System.out.println("Probleme dans vendeurs getAllFields "+e.getMessage());
		}
		
		return null;
	}

}
