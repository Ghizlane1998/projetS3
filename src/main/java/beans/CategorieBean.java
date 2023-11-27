package beans;

import java.util.List;

import entities.Categorie;
import service.CategorieService;
import service.impl.CategorieServiceImpl;

public class CategorieBean {

	private Categorie categorie;
	private boolean modifyContext;
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public boolean isModifyContext() {
		return modifyContext;
	}
	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}
	
	public List<Categorie> getCategories()
	{
		CategorieService categorieService =  new CategorieServiceImpl();
		return categorieService.getSortedCategorie();
	}
	public String getLabel()
	{
		return modifyContext ? "Modification"  : "Ajout";
	}

}
