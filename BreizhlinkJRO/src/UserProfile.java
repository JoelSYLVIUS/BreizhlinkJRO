import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
		
		
        //PrintStream out = new PrintStream(response.getOutputStream());
		String IdUser = request.getParameter("user");
		//out.println(IdUser);
		try {
        	DriverDatabase db = new DriverDatabase();            	
            	
                Connection connection = db.getConnection();
                
                String query = "SELECT * FROM link WHERE id_user = ?";
                PreparedStatement pst = connection.prepareStatement(query);
                  pst.setString(1, IdUser);
                ResultSet rs = pst.executeQuery();
               
                Map<String, String> al = new HashMap<String, String>();
                while(rs.next()) {
                	
                	al.put("link", rs.getString("originallink"));
                	al.put("slink",rs.getString("shortlink"));
                	
                }
                request.setAttribute("al", al);
                    
                    getServletContext().getRequestDispatcher("/user-profile.jsp").forward(request, response);
                //else {
                	//response.sendRedirect("/user-profile.jsp");
                //}
                               

            	
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