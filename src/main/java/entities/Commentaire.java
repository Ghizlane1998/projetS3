package entities;

import java.sql.Date;

public class Commentaire {
	private int id_commentaire;
	private int id_acheteur;
	private int id_article;
	private String contenu;
	private Date date;
	
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Commentaire(int id_commentaire, String contenu, Date date) {
			super();
			this.id_commentaire = id_commentaire;
			this.contenu = contenu;
			this.date = date;
		}
	public int getId_commentaire() {
		return id_commentaire;
	}

	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}
	public int getId_acheteur() {
		return id_acheteur;
	}

	public void setId_acheteur(int id_acheteur) {
		this.id_acheteur = id_acheteur;
	}
	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
	
	

}
