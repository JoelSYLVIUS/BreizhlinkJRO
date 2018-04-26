

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;

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
            //out.println(name);
            //out.println(firstname);
        	//out.println(email);
        	//out.println(password);
        	//out.println(pseudo);
            //out.println("ok");

            try {
            	out.println("ok");
            	Class.forName("com.mysql.jdbc.Driver");                
                out.println("ok");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:8889/Esgi_breizhlink", "root", "root");
                out.println("ok");
                String query = "INERT INTO user ('prenom', 'nom', 'email', 'mdp', 'pseudo') VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pst = c.prepareStatement(query);
                  pst.setString(1, firstname);
                  pst.setString(2, name);
                  pst.setString(3, email);
                  pst.setString(4, pwd);
                  pst.setString(5, pseudo);
                ResultSet rs = pst.executeQuery();
               
                out.println(name);
            	out.println(firstname);
            	out.println(email);
            	out.println(pwd);
            	out.println(pseudo);
            	response.sendRedirect("index");	
                if(rs.next()) {
                	//HttpSession session = request.getSession();

                    //session.setAttribute("username", usrname); 
                	out.println(name);
                	out.println(firstname);
                	out.println(email);
                	out.println(pwd);
                	out.println(pseudo);
                    
                	response.sendRedirect("index");	
                }
                else {
                	response.sendRedirect("index");
                }
                c.close();
            }  catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }else {
        }
        out.println("ERROR");
    }   
}