package entities;

import java.util.Arrays;

import com.mysql.cj.jdbc.Blob;

public class Article {
	
	private int id_article ; 
	private String nomArticle;
	private String designation;
	private int prix ; 
	private Categorie categorie;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(int id_article, String nomArticle, String designation, int prix, Categorie categorie) {
		super();
		this.id_article = id_article;
		this.nomArticle = nomArticle;
		this.designation = designation;
		this.prix = prix;
		this.categorie = categorie;
	}

	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}



	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", nomArticle=" + nomArticle + ", designation=" + designation
				+ ", prix=" + prix + ",  categorie=" + categorie + "]";
	}
	

}
