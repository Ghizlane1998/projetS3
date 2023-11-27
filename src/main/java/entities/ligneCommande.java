package entities;

public class ligneCommande {
	private int id_ligneCommande ;
	private int id_commande ; 
	private int id_acheteur ;
	private int qteCommande ;
	
	
	public ligneCommande(int id_ligneCommande, int id_commande, int id_acheteur, int qteCommande) {
		super();
		this.id_ligneCommande = id_ligneCommande;
		this.id_commande = id_commande;
		this.id_acheteur = id_acheteur;
		this.qteCommande = qteCommande;
	}


	public ligneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_ligneCommande() {
		return id_ligneCommande;
	}


	public void setId_ligneCommande(int id_ligneCommande) {
		this.id_ligneCommande = id_ligneCommande;
	}


	public int getId_commande() {
		return id_commande;
	}


	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}


	public int getId_acheteur() {
		return id_acheteur;
	}


	public void setId_acheteur(int id_acheteur) {
		this.id_acheteur = id_acheteur;
	}


	public int getQteCommande() {
		return qteCommande;
	}


	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	} 
	
	
	

}
