package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.ArticleBean;
import beans.CategorieBean;
/**
 * Servlet implementation class GlobalServlet
 */
@WebServlet("/home")
public class GlobalServlet extends HttpServlet {
 
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    		
    		/*if(request.getSession().getAttribute("categorieBean") == null)
    			request.getSession().setAttribute("categorieBean", new CategorieBean());
    		request.getRequestDispatcher("WEB-INF/Categorie.jsp").forward(request, response);*/
    		
    		
    	/*	if(request.getSession().getAttribute("articleBean") == null)
    			request.getSession().setAttribute("articleBean", new ArticleBean());
    		request.getRequestDispatcher("WEB-INF/Article.jsp").forward(request, response);*/
      
			RequestDispatcher RD = getServletContext().getRequestDispatcher("/login.jsp");
		    RD.forward(request, response);
    		
    	}

}
