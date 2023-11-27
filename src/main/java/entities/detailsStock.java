package entities;

public class detailsStock {
	
	private int id_detailsStock ; 
	private int id_stock ; 
	private int id_article ; 
	private int qteStocke ;
	
	
	public detailsStock() {
		super();
		// TODO Auto-generated constructor stub
	}


	public detailsStock(int id_detailsStock, int id_stock, int id_article, int qteStocke) {
		super();
		this.id_detailsStock = id_detailsStock;
		this.id_stock = id_stock;
		this.id_article = id_article;
		this.qteStocke = qteStocke;
	}


	public int getId_detailsStock() {
		return id_detailsStock;
	}


	public void setId_detailsStock(int id_detailsStock) {
		this.id_detailsStock = id_detailsStock;
	}


	public int getId_stock() {
		return id_stock;
	}


	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}


	public int getId_article() {
		return id_article;
	}


	public void setId_article(int id_article) {
		this.id_article = id_article;
	}


	public int getQteStocke() {
		return qteStocke;
	}


	public void setQteStocke(int qteStocke) {
		this.qteStocke = qteStocke;
	} 
	
	
	
	
	

}
