import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet(name = "servletUserProfile", urlPatterns = "/userprofile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//        PrintStream out = new PrintStream(response.getOutputStream());
		
    		ArrayList listLink = new ArrayList();
    		
    		HttpSession session = request.getSession();
    		Integer idUser = (Integer) session.getAttribute("iduser");
    		
    		if(idUser != null) {
		
		try {
        	DriverDatabase db = new DriverDatabase();            	
            	
                Connection connection = db.getConnection();
                
                String query = "SELECT * FROM link WHERE id_user = ?";
                PreparedStatement pst = connection.prepareStatement(query);
                  pst.setInt(1, idUser);
                ResultSet rs = pst.executeQuery();
               
                
                while(rs.next()) {
                	
            			Map links = new HashMap();
                	
	            	    links.put("originalLink", rs.getString("originallink"));
	            	    links.put("shortLink", rs.getString("shortLink"));
	            	    
	            	    listLink.add(links);                    
                    
                }
                
                request.setAttribute("listLink", listLink);
                
                this.getServletContext().getRequestDispatcher("/user-profile.jsp").forward(request, response);                
            	
            	connection.close();
            
            
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    		}
    		else {
            	response.sendRedirect("login.jsp");
    		}
        
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        if (request.getParameter("prenom") != null && request.getParameter("nom") != null) {
            String firstname = request.getParameter("prenom");
            String lastname = request.getParameter("nom");
            String pseudo = request.getParameter("pseudo");            
            String email = request.getParameter("email");            
            String password = request.getParameter("password");            

	            try {
	            	
                		HttpSession session = request.getSession();
                		int idUser = (int) session.getAttribute("iduser");
                		
                		session.setAttribute("pseudo", pseudo);
                    session.setAttribute("prenomuser", firstname);
                    session.setAttribute("nomuser", lastname);
                    session.setAttribute("emailuser", email);
                    session.setAttribute("mdp", password);
                        
	            		DriverDatabase db = new DriverDatabase();
	            	                
	                Connection connection = db.getConnection();
	                Calendar currentTime = Calendar.getInstance();
	
	                PreparedStatement pst = connection.prepareStatement("UPDATE user SET prenom = ?, nom"
	                		+ " = ?, email = ?, mdp = ?, pseudo = ?, date_create = ?  WHERE user.id = ?;");
	                pst.setString(1, firstname);
	                pst.setString(2, lastname);
	                pst.setString(3, email);
	                pst.setString(4, password);
	                pst.setString(5, pseudo);
	                pst.setDate(6, new java.sql.Date(currentTime.getTime().getTime()));
	                pst.setInt(7, idUser);
	
	                pst.executeUpdate();
	                
	                	response.sendRedirect("userprofile");
	                
	                connection.close();
	            }
	            
	            catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
            }
        
        else {
            	response.sendRedirect("user-profile.jsp");
        }
    
	}

}