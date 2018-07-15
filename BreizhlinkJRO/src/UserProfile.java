import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* Servlet implementation class UserProfile
*/
@WebServlet(name = "servletUserProfile", urlPatterns = "/usersprofile")
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
    	
    	String message = "Transmission de variables : OK !";
        request.setAttribute( "texte", message );
        
        
        
        //out.println(prenomuser);
        
//        HttpSession session = request.getSession();
//        session.setAttribute("texte", message);
        
        getServletContext().getRequestDispatcher( "/user-profile.jsp" ).forward( request, response ); 
    }

}