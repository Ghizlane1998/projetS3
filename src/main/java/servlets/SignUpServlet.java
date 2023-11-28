package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//import beans.VendeurBean;
import dao.VendeurDao;
import dao.impl.VendeurDaoImpl;
//import beans.AcheteurBean;
import dao.AcheteurDao;
//import beans.AdminBean;
import dao.AdminDao;
import dao.Connexion;
import dao.impl.AcheteurDaoImpl;
import dao.impl.AdminDaoImpl;
import entities.Acheteur;
import entities.Admin;
import entities.Vendeur;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		// TODO Auto-generated method stub
		String role = request.getParameter("role");
		// ADMIN SIGNUP
		if(role != null && role.equals("admin")) {
			//AdminBean adminBean = (AdminBean)request.getSession().getAttribute("adminBean");
			AdminDao adminDao = new AdminDaoImpl(Connexion.getConnexion());	
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Admin newadmin = new Admin( email, password,role);
			
			if(adminDao.getByEmail(email) == null) {
				  adminDao.create(newadmin);
				//  adminBean.setAdmin(new Admin());
				  RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
				  rd.forward(request, response);}
			else {
				  request.setAttribute("errorMessage", "Cet email est déjà utilisé.");
				  RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUp.jsp");
				  rd.forward(request, response);
				}
			}
		// ACHETEUR SIGNUP
		if(role != null && role.equals("acheteur")) {
			//AcheteurBean acheteurBean = (AcheteurBean)request.getSession().getAttribute("acheteurBean");
			AcheteurDao acheteurDao = new AcheteurDaoImpl(Connexion.getConnexion());	
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String tel = request.getParameter("tel");
			String adresse = request.getParameter("adresse");
			
			Acheteur newacheteur = new Acheteur( email, password,role,nom, prenom, tel, adresse);
			
			if(acheteurDao.getByEmail(email) == null) {
				 acheteurDao.create(newacheteur);
				// acheteurBean.setAcheteur(new Acheteur());
				 response.sendRedirect("/login.jsp");
				  
				}
			else {
				 request.setAttribute("errorMessage", "Cet email est déjà utilisé.");
				 RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUp.jsp");
				 rd.forward(request, response);
				}
			}
	   //VENDEUR SIGNUP
		if(role != null && role.equals("vendeur")) {
			//VendeurBean vendeurBean = (VendeurBean)request.getSession().getAttribute("vendeurBean");
			VendeurDao vendeurDao = new VendeurDaoImpl(Connexion.getConnexion());	
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String tel = request.getParameter("tel");
			String adresse = request.getParameter("adresse");
			
			Vendeur newvendeur = new Vendeur( email, password,role,nom, prenom, tel, adresse);
			
			if(vendeurDao.getByEmail(email) == null) {
				 vendeurDao.create(newvendeur);
				// vendeurBean.setVendeur(new Vendeur());
				 response.sendRedirect("/login.jsp");
				 }
			else {
				 request.setAttribute("errorMessage", "Cet email est déjà utilisé.");
				 RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUp.jsp");
				 rd.forward(request, response);
				}
		
	}
	}

}
