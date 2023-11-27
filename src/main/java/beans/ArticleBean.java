package beans;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import entities.Article;
import entities.Categorie;
import service.ArticleService;
import service.CategorieService;
import service.impl.ArticleServiceImpl;
import service.impl.CategorieServiceImpl;

public class ArticleBean {
	private Article article;
	private boolean modifyContext;
	
	public Article getArticle() {
		return article;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	public boolean isModifyContext() {
		return modifyContext;
	}
	
	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}
	
	public List<Article> getArticles()
	{
		ArticleService articleService = new ArticleServiceImpl();
		return articleService.getSortedArticle();		
	}
	
	public List<String> getNomCategories()
	{
		CategorieService categorieService = new CategorieServiceImpl();
		List<String> listNoms  = new ArrayList<String>();
		for(Categorie categorie :  categorieService.getSortedCategorie())
		{
			listNoms.add(categorie.getNomCategorie());
		}
		return 	listNoms;	
	}
	
	public String getLabel()
	{
		return modifyContext ? "Modification " : "Ajout";
	}

public String getImageBase64(byte[] image) {
    if (image != null && image.length > 0) {
        return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(image);
    }
    return "";
}
}
