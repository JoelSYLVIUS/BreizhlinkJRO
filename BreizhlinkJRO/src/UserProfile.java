import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

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
		
		try {
        	DriverDatabase db = new DriverDatabase();            	
            	
                Connection connection = db.getConnection();
                
                String query = "SELECT * FROM link WHERE id_user = ?";
                PreparedStatement pst = connection.prepareStatement(query);
                  pst.setInt(1, 6);
                ResultSet rs = pst.executeQuery();
               
                
                if(rs.next()) {
                	
//                    out.print(rs.getString("originallink"));

                    request.setAttribute("link", rs.getString("originallink"));
                    
                    
                    getServletContext().getRequestDispatcher("/user-profile.jsp").forward(request, response);
                }
                               
//            	response.sendRedirect("login.jsp");
                
//        		this.getServletContext().getRequestDispatcher( "/user-profile.jsp" ).forward( request, response );
                
            	
            	connection.close();
            
            
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    
	}

}