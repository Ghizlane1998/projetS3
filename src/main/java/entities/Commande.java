package entities;

import java.sql.Date;
import entities.Acheteur;

public class Commande {

	private int id_commande ; 
	private Acheteur acheteur ;
	private  int numeroCommande ;
	private Date dateCommande;
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public Acheteur getAcheteur() {
		return acheteur;
	}
	public void setAcheteur(Acheteur acheteur) {
		this.acheteur = acheteur;
	}
	public int getNumeroCommande() {
		return numeroCommande;
	}
	public void setNumeroCommande(int numeroCommande) {
		this.numeroCommande = numeroCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Commande(int id_commande, Acheteur acheteur, int numeroCommande, Date dateCommande) {
		super();
		this.id_commande = id_commande;
		this.acheteur = acheteur;
		this.numeroCommande = numeroCommande;
		this.dateCommande = dateCommande;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
