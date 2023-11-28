package servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beans.ArticleBean;
import beans.CategorieBean;
import dao.Connexion;
import dao.VendeurDao;
import dao.impl.VendeurDaoImpl;
import entities.Acheteur;
import entities.Admin;
import entities.Vendeur;
import dao.AcheteurDao;
import dao.impl.AcheteurDaoImpl;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//récupérer les données du formulaire de login
				
		        String email = request.getParameter("email");
				String password = request.getParameter("password");
				String role = request.getParameter("role");
				
				// LOGIN ADMIN
				if (role != null) {
				    if (role.equals("admin")) {
				    	 AdminDao adminDao = new AdminDaoImpl(Connexion.getConnexion());	
						 Admin admin = adminDao.getByEmail(email);
					     if (admin != null && password.equals(admin.getPassword())) {
									request.getSession().setAttribute("prenom", "Bonjour chère Admin");
									if(request.getSession().getAttribute("categorieBean") == null) {
						    		request.getSession().setAttribute("categorieBean", new CategorieBean());}
									if(request.getSession().getAttribute("articleBean") == null) {
							    		request.getSession().setAttribute("articleBean", new ArticleBean());}
									response.sendRedirect("home.jsp");}
				                
				         else {
				        	request.setAttribute("errorMessage", "Email ou mot de passe incorrect");
				        	 RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
							  rd.forward(request, response);        
				                                                  }
				    } if (role.equals("acheteur")) {
				        // Logique pour l'acheteur
				        AcheteurDao acheteurDao = new AcheteurDaoImpl(Connexion.getConnexion());
				        Acheteur acheteur = acheteurDao.getByEmail(email);
				        if (acheteur != null && password.equals(acheteur.getPassword()) ) {
				           // HttpSession session = request.getSession();
				           // session.setAttribute("acheteur", acheteur);
				           // int id_acheteur = acheteur.getIdAcheteur();
				           // session.setAttribute("id_acheteur", id_acheteur);
				            request.getSession().setAttribute("prenom", "Acheteur");
				            response.sendRedirect("home.jsp");
				        } else {
				            request.setAttribute("errorMessage", "Email ou mot de passe incorrect");
				            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
							  rd.forward(request, response);
				        }
				    } if (role.equals("vendeur")) {
				        // Logique pour le vendeur
				        VendeurDao vendeurDao = new VendeurDaoImpl(Connexion.getConnexion());
				        Vendeur vendeur = vendeurDao.getByEmail(email);
				        if (vendeur != null && password.equals(vendeur.getPassword())) {
				           // HttpSession session = request.getSession();
				           // session.setAttribute("vendeur", vendeur);
				           // int id_vendeur = vendeur.getIdVendeur();
				           // session.setAttribute("id_vendeur", id_vendeur);
				            request.getSession().setAttribute("prenom", "vendeur");
				            response.sendRedirect("home.jsp");
				        } else {
				            request.setAttribute("errorMessage", "Email ou mot de passe incorrect");
				            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
							  rd.forward(request, response);
				        }
				    }
				} else {
				    // Gérer le cas où le rôle n'est pas spécifié
				    request.setAttribute("errorMessage", "Le rôle n'est pas spécifié");
				    RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}


} 
	}
