import javax.servlet.ServletException;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;

@WebServlet(name = "servletLogin", urlPatterns = "/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintStream out = new PrintStream(response.getOutputStream());
        
        
        
        if (request.getParameter("pseudo") != null && request.getParameter("password") != null) {
            String pseudo = request.getParameter("pseudo");
            String password = request.getParameter("password");
            
            

            try {
            	
            	DriverDatabase db = new DriverDatabase();
            	
                Connection connection = db.getConnection();
                
                String query = "SELECT * FROM user WHERE pseudo = ? AND mdp = ?";
                PreparedStatement pst = connection.prepareStatement(query);
                  pst.setString(1, pseudo);
                  pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()) {
                	HttpSession session = request.getSession();

                    session.setAttribute("pseudo", pseudo);
                    session.setAttribute("iduser", rs.getInt("id"));
                    session.setAttribute("prenomuser", rs.getString("prenom"));
                    session.setAttribute("nomuser", rs.getString("nom"));
                    session.setAttribute("emailuser", rs.getString("email"));
                    
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    
                	//response.sendRedirect("index.jsp");	
                }
                else {
                	response.sendRedirect("login.jsp");
                }
                connection.close();
            }  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }else {
        }
       // out.println("ERROR");
    }   
}