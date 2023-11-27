package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import beans.CategorieBean;
import dao.CategorieDao;
import dao.impl.CategorieDaoImpl;
import entities.Categorie;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/categorie/*")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 
    HttpSession session = request.getSession(true);
		
	CategorieBean categorieBean = (CategorieBean)request.getSession().getAttribute("categorieBean");
	
	CategorieDao categorieDao = new CategorieDaoImpl();	
	
	  if (categorieBean == null) {
	        categorieBean = new CategorieBean();
	        session.setAttribute("categorieBean", categorieBean);
	    }
		
		if(request.getRequestURI().contains("save"))
		{
			Categorie categorie = new Categorie();
			categorie.setNomCategorie(request.getParameter("nomCategorie"));
			categorieBean.setCategorie(categorie);
			if(categorieBean.isModifyContext())
			{
				int id = Integer.parseInt(request.getParameter("id_categorie"));
                 categorie.setId_categorie(id);
				categorieDao.update(categorie);
				categorieBean.setModifyContext(false);
			}
			else
				categorieDao.create(categorie);
			categorieBean.setCategorie(new Categorie());
		}
       if(request.getRequestURI().contains("modify"))
		{
			int id1 = Integer.parseInt(request.getParameter("id_categorie"));
			categorieBean.setCategorie(categorieDao.getById(id1));
			categorieBean.setModifyContext(true);
		}
		if(request.getRequestURI().contains("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id_categorie"));
			categorieDao.delete(categorieDao.getById(id));
		}
		response.sendRedirect("../");
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


