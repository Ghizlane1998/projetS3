package entities;

import java.sql.Date;

public class Commentaire {
	private int id_commentaire;
	private String contenu;
	private Date date;
	
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId_commentaire() {
		return id_commentaire;
	}
	public Commentaire(int id_commentaire, String contenu, Date date) {
			super();
			this.id_commentaire = id_commentaire;
			this.contenu = contenu;
			this.date = date;
		}

	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
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
