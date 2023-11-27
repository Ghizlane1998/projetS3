package entities;

public class Categorie {

	
	private int id_categorie ; 
	private String nomCategorie;

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(int id_categorie, String nomCategorie) {
		super();
		this.id_categorie = id_categorie;
		this.nomCategorie = nomCategorie;
	}

	public int getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	@Override
	public String toString() {
		return "categorie [id_categorie=" + id_categorie + ", nomCategorie=" + nomCategorie + "]";
	}


	
	
	 

}
