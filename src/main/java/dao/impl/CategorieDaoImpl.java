package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Connexion;
import dao.CategorieDao;
import entities.Categorie;

public class CategorieDaoImpl implements CategorieDao {

	private Connection connection = Connexion.getConnexion();
	
	@Override
	public boolean create(Categorie o) {
		
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement
					("insert into categorie (nomCategorie) values ( ?)");
			
			ps.setString(1, o.getNomCategorie());
			
			
			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("Categorie bien Ajoute ...");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de l'ajout de categorie "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean update(Categorie o) {
		
		if(this.connection == null)
			return false;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement("update categorie set nomCategorie = ? where id_categorie = ?");
			ps.setString(1, o.getNomCategorie());
			ps.setInt(2, o.getId_categorie());			
			ps.executeUpdate();
			ps.close();
			System.out.println("Categorie bien Modifi�e ...");				
			return true;
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification de la Categorie ***"+e.getMessage());
		}
		return false;

	}

	@Override
	public boolean delete(Categorie o) 
	{
		if(this.connection == null)
			return false;

		try {
			PreparedStatement ps = this.connection.prepareStatement("delete from categorie where id_categorie=?");
			ps.setInt(1, o.getId_categorie());
			ps.executeUpdate();
			ps.close();
			System.out.println("Categorie bien suppprim�e ***");
			return true;
		}
		catch (SQLException e) {
			System.out.println("Probleme lors de la suppression de la categorie !!"+e.getMessage());
		}
		return false;		
	}

	@Override
	public Categorie getById(int id) {
		if(this.connection == null)
			return null;
		try {
			PreparedStatement ps = this.connection.prepareStatement("select *  from categorie where id_categorie=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if((rs != null) && (rs.next()))
			{
				Categorie f = new Categorie();
				f.setId_categorie(rs.getInt(1));
				f.setNomCategorie(rs.getString(2));
				rs.close();
				ps.close();
				return f;
			}

		}
		catch (SQLException e) {
			System.out.println("Probleme lors de la selection de la categorie dont l'id = "+id+" !!\n"+e.getMessage());
		}
		return null;

		

	}

	@Override
	public List<Categorie> getAll() {
		if(this.connection == null)
			return null;
		try {
			PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM categorie");
			ResultSet rs = ps.executeQuery();
			List<Categorie> listCategories = new ArrayList<Categorie>();
			while(rs.next())
			{
				Categorie f = new Categorie();
				f.setId_categorie(rs.getInt(1));
				f.setNomCategorie(rs.getString(2));
				listCategories.add(f);
			}
			rs.close();
			ps.close();
			return listCategories;
		} 
		catch (SQLException e) {
			System.out.println("Probleme lors de la selection ***"+e.getMessage());
		}
		return null;
	}

	@Override
	public List<String> getAllFields() {
		if(this.connection == null)
			return null;
		PreparedStatement ps;
		try {
			ps = this.connection.prepareStatement("SELECT * FROM categorie");
		    ResultSet rs = ps.executeQuery();
		    ResultSetMetaData rsmd = rs.getMetaData();
		    List<String> fields = new ArrayList<String>();
		    // fields va contenir les noms des colonnes de la table
		    for(int i=1;i<rsmd.getColumnCount();i++)
		    	fields.add(rsmd.getCatalogName(i));
		    rs.close();
		    ps.close();
		    return fields;
		} catch (SQLException e) {
			System.out.println("Probleme lors de la selection des noms de colonnes ***"+e.getMessage());
		}
		return null;		
	}
	
	public Map<Integer,String> getNomCategorie()
	{
		if(this.connection == null)
			return null;
		try {
			PreparedStatement ps = this.connection.prepareStatement("SELECT id_categorie,nomCategorie from categorie");
			ResultSet rs = ps.executeQuery();
			Map<Integer , String> nomCategories = new HashMap<Integer , String>();
			while(rs.next())
				nomCategories.put(rs.getInt("id_categorie"),rs.getString("nomCategorie"));
			rs.close();
			ps.close();
			return nomCategories;
			
		} catch (SQLException e) {
			System.out.println("Probleme lors de la selections des noms de categorie !! "+e.getMessage());
		}
		return null;
		
	}
	
	public Categorie getByNomCategorie(String nomCategorie)
	{
		if(this.connection == null)
			return null;
		try {
			PreparedStatement ps = this.connection.prepareStatement("SELECT * from categorie where nomCategorie=?");
			ps.setString(1, nomCategorie);
			ResultSet rs = ps.executeQuery();
			if(rs!=null && rs.next())
			{
				System.out.println("Categorie trouve");
				Categorie f = new Categorie();
				f.setId_categorie(rs.getInt(1));
				f.setNomCategorie(rs.getString(2));
				rs.close();
				ps.close();
				return f;
			}
			else
			{
				rs.close();
				ps.close();
			}
		} 
		catch (SQLException e) {
			System.out.println("Probleme lors de la selection de la categorie dont le nomCategorie = "+nomCategorie+" !!\n"+e.getMessage());
		}
		return null;
		
	}
}
