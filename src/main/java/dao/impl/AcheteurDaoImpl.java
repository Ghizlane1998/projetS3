package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AcheteurDao;
import dao.Connexion;
import entities.Acheteur;

public class AcheteurDaoImpl implements AcheteurDao {
	private Connection connection ;

	   public AcheteurDaoImpl(Connection connection) {
		   this.connection = connection;
	}
	public AcheteurDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean create(Acheteur acheteur) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
		 	return false;
			
			try {
				PreparedStatement ps = this.connection.prepareStatement
						("insert into acheteur (email,password,role,nom,prenom,tel,adresse) values (?, ?, ?,?, ?,?, ?);");
				
				ps.setString(1, acheteur.getEmail());
				ps.setString(2, acheteur.getPassword());
				ps.setString(3, acheteur.getRole());
				ps.setString(4, acheteur.getNom());
				ps.setString(5, acheteur.getPrenom());
				ps.setString(6, acheteur.getTel());
				ps.setString(7, acheteur.getAdresse());
				//execution de la requete SQL
				ps.executeUpdate();
				ps.close();
				System.out.println("Acheteur bien Ajoutee !! ...");
				
				return true;
				
			} catch (SQLException e) {
				System.out.println("Probleme lors de l'ajout de acheteur"+e.getMessage());
			}
			
		return false;
	}

	@Override
	public boolean update(Acheteur acheteur) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("update acheteur set email = ?, password = ? ,role=?,nom = ?, prenom = ? ,tel=?,adresse=?   where id_acheteur = ?");
			ps.setString(1, acheteur.getEmail());
			ps.setString(2, acheteur.getPassword());
			ps.setString(3, acheteur.getRole());
			ps.setString(4, acheteur.getNom());
			ps.setString(5, acheteur.getPrenom());
			ps.setString(6, acheteur.getTel());
			ps.setString(7, acheteur.getAdresse());
			
			// execution de la requete SQL
			ps.executeUpdate();
			ps.close();
			
			System.out.println("acheteur bien Modifiee !!...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification de acheteur "+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Acheteur acheteur) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("delete from acheteur where id_acheteur = ?");
			
			ps.setInt(1, acheteur.getIdAcheteur());

			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("acheteur bien supprim�e !! ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la supression de acheteur "+e.getMessage());
		}
		return false;
	}

	@Override
	public Acheteur getById(int id) {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from acheteur where id_acheteur = ? ");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				Acheteur acheteur = new Acheteur();
				acheteur.setIdAcheteur(rs.getInt("id_acheteur"));
				acheteur.setEmail(rs.getString("email"));
				acheteur.setPassword(rs.getString("password"));
				acheteur.setRole(rs.getString("role"));
				acheteur.setNom(rs.getString("nom"));
				acheteur.setPrenom(rs.getString("prenom"));
				acheteur.setTel(rs.getString("tel"));
				acheteur.setAdresse(rs.getString("adresse"));
				
				rs.close();
				ps.close();
				
				return acheteur;
			}
			
		} catch (SQLException e) {
			System.out.println("Probleme dans acheteur getById "+e.getMessage());
		}
		return null;
	}
    public Acheteur getByEmail(String email) {
    	connection = Connexion.getConnexion();
    	  if(this.connection == null)
  			return null;
  		
  		try {
  			PreparedStatement ps = this.connection.prepareStatement
  					("select * from acheteur where email = ? ");
  			
  			ps.setString(1, email);
  			
  			ResultSet rs = ps.executeQuery();
  			
  			if(rs != null && rs.next())
  			{
  				Acheteur acheteur = new Acheteur();
  				acheteur.setIdAcheteur(rs.getInt("id_acheteur"));
  				acheteur.setEmail(rs.getString("email"));
  				acheteur.setPassword(rs.getString("password"));
  				acheteur.setRole(rs.getString("role"));
  				acheteur.setNom(rs.getString("nom"));
  				acheteur.setPrenom(rs.getString("prenom"));
  				acheteur.setPassword(rs.getString("tel"));
  				acheteur.setRole(rs.getString("adresse"));
  				rs.close();
  				ps.close();
  				
  				return acheteur;
  			}
  			
  		} catch (SQLException e) {
  			System.out.println("Probleme dans admin getByEmail "+e.getMessage());
  		}
		return null;
	}

	@Override
	public List<Acheteur> getAll() {
		connection = Connexion.getConnexion();
		if(this.connection == null)
			return null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("select * from acheteur");
			
			ResultSet rs = ps.executeQuery();
			
			List<Acheteur> acheteurs=new  ArrayList<Acheteur>();
			
			while (rs.next())
			{
				Acheteur acheteur = new Acheteur();
				acheteur.setIdAcheteur(rs.getInt("id_acheteur"));
				acheteur.setEmail(rs.getString("email"));
				acheteur.setPassword(rs.getString("password"));
				acheteur.setNom(rs.getString("nom"));
				acheteur.setPrenom(rs.getString("prenom"));
				acheteur.setTel(rs.getString("tel"));
				acheteur.setAdresse(rs.getString("adresse"));
				
				acheteurs.add(acheteur);
			}
			
			rs.close();
			ps.close();
			
			return acheteurs;
			
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
			PreparedStatement ps = this.connection.prepareStatement("select * from acheteur");
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			List<String> fields = new ArrayList<String>();
			
			for(int i=1; i<=rsmd.getColumnCount(); i++)
				fields.add(rsmd.getColumnName(i));
			
			rs.close();
			ps.close();
			
			return fields;
			
		} catch (SQLException e) {
			System.out.println("Probleme dans acheteur getAllFields "+e.getMessage());
		}
		return null;
	}

}
