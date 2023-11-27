package entities;

import java.sql.Date;
import entities.Commande;

public class Facture {
	

	private int id_facture ; 
	private Date dateFacture;
	private int totale;
	private Commande commande;
	
	
	public Facture(int id_facture, Date dateFacture, int totale, Commande commande) {
		super();
		this.id_facture = id_facture;
		this.dateFacture = dateFacture;
		this.totale = totale;
		this.commande = commande;
	}


	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_facture() {
		return id_facture;
	}


	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}


	public Date getDateFacture() {
		return dateFacture;
	}


	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}


	public int getTotale() {
		return totale;
	}


	public void setTotale(int totale) {
		this.totale = totale;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	
	

}
