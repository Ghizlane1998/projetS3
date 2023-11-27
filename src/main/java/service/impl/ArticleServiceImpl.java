package service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.ArticleDao;
import dao.impl.ArticleDaoImpl;
import entities.Article;
import service.ArticleService;

public class ArticleServiceImpl implements ArticleService{

	

	private ArticleDao articleDao = new ArticleDaoImpl();



	@Override
	public List<Article> getSortedArticle() {
		List<Article> articles = this.articleDao.getAll();
		
		Collections.sort(articles, new Comparator<Article>() {
			
			public int compare(Article e1, Article e2) {
				
				return e2.getNomArticle().compareTo(e1.getNomArticle());
			}
		}
		);
		
		return articles;
	}
}
