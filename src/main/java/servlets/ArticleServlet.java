package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beans.ArticleBean;
import dao.ArticleDao;
import dao.CategorieDao;
import dao.impl.ArticleDaoImpl;
import dao.impl.CategorieDaoImpl;
import entities.Article;
import entities.Categorie;
import jakarta.servlet.http.HttpSession;


@WebServlet("/article/*")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		ArticleDao articleDao = new ArticleDaoImpl();
		CategorieDao categorieDao = new CategorieDaoImpl();
		ArticleBean articleBean = (ArticleBean)request.getSession().getAttribute("articleBean");
		
		if (articleBean == null) {
			articleBean = new ArticleBean();
	        session.setAttribute("articleBean", articleBean);
	    }
		
		if(request.getRequestURI().contains("save"))
		{
			int id_article = Integer.parseInt(request.getParameter("id_article"));
			String nomArticle = request.getParameter("nomArticle");
			String designation = request.getParameter("nomArticle");
			 int prix = Integer.parseInt(request.getParameter("prix"));
			Categorie c = ((CategorieDaoImpl)categorieDao).getByNomCategorie(request.getParameter("nomCategorie"));
			Article article = new Article();
			article.setNomArticle(nomArticle);
			article.setDesignation(designation);
			article.setPrix(prix);
			article.setCategorie(c);
			article.setId_article(id_article);
			if(articleBean.isModifyContext())
			{

				articleDao.update(article);
				articleBean.setModifyContext(false);
			}
			else
				articleDao.create(article);	
			articleBean.setArticle(new Article());
		}
		else if(request.getRequestURI().contains("modify"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			articleBean.setArticle(articleDao.getById(id));
			articleBean.setModifyContext(true);			
		}
		else if(request.getRequestURI().contains("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			articleDao.delete(articleDao.getById(id));
		}
		// apres chaque action l'admin est redirigé vers Article.jsp avec les nouvelles modifs
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Article.jsp");
				dispatcher.forward(request, response);
		
	}

}
