

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import java.util.Calendar;

@WebServlet(name = "servletInscriptuser", urlPatterns = "/inscriptuser")
public class Inscriptuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscriptuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintStream out = new PrintStream(response.getOutputStream());
        
        if (request.getParameter("nom") != null && request.getParameter("prenom") != null && request.getParameter("email") != null && request.getParameter("password") != null && request.getParameter("pseudo") != null) {
            String name = request.getParameter("nom");
            String firstname = request.getParameter("prenom");
            String email = request.getParameter("email");
            String pwd = request.getParameter("password");
            String pseudo = request.getParameter("pseudo");
            

            try {

            	DriverDatabase db = new DriverDatabase();
            	
                Connection connection = db.getConnection();
                Calendar currentTime = Calendar.getInstance();

                PreparedStatement create = connection.prepareStatement("INSERT INTO user (prenom, nom, email, mdp, pseudo, date_create) VALUES (?, ?, ?, ?, ?, ?);");
                create.setString(1, firstname);
                create.setString(2, name);
                create.setString(3, email);
                create.setString(4, pwd);
                create.setString(5, pseudo);
                create.setDate(6, new java.sql.Date(currentTime.getTime().getTime()));

                create.executeUpdate();
               
                
                    
                	response.sendRedirect("index.jsp");	
                
                connection.close();
            }  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }else {
        }
        //out.println("ERROR");
    }   
}