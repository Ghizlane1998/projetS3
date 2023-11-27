package entities;

public class Acheteur {
	private int id_acheteur ; 
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String tel;
	private String adresse;
	private int role;
	public Acheteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Acheteur(int id_acheteur, String nom, String prenom, String email, String password, String tel,
			String adresse, int role) {
		super();
		this.id_acheteur = id_acheteur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.adresse = adresse;
		this.role = role;
	}
	public int getId_acheteur() {
		return id_acheteur;
	}
	public void setId_acheteur(int id_acheteur) {
		this.id_acheteur = id_acheteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	

}
