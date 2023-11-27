package service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.CategorieDao;
import dao.impl.CategorieDaoImpl;
import entities.Categorie;
import service.CategorieService;

public class CategorieServiceImpl implements CategorieService {


	private CategorieDao categorieDao = new CategorieDaoImpl();



	@Override
	public List<Categorie> getSortedCategorie() {
		List<Categorie> categories = this.categorieDao.getAll();
		
		Collections.sort(categories, new Comparator<Categorie>() {
			
			public int compare(Categorie e1, Categorie e2) {
				
				return e2.getNomCategorie().compareTo(e1.getNomCategorie());
			}
		}
		);
		
		return categories;
	}
}
