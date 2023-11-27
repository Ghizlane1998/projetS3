package entities;
import entities.Vendeur;

public class Stock {

	private int id_stock ; 

	private Vendeur vendeur ; 

	private String nomStock ;

	public Stock(int id_stock, Vendeur vendeur, String nomStock) {
		super();
		this.id_stock = id_stock;
		this.vendeur = vendeur;
		this.nomStock = nomStock;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_stock() {
		return id_stock;
	}

	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public String getNomStock() {
		return nomStock;
	}

	public void setNomStock(String nomStock) {
		this.nomStock = nomStock;
	} 
	
	

}
