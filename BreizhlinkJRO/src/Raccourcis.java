

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Raccourcis
 */
@WebServlet(name = "servletRaccourcis", urlPatterns = "/raccourcis")
public class Raccourcis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private char[] shorturl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Raccourcis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintStream out = new PrintStream(response.getOutputStream());
		if (request.getParameter("url") != null ) {
            String url = request.getParameter("url");
            String mdp_bjro = request.getParameter("mdp");
            //out.println(url);
            //out.println(mdp_bjro);
            
            
            ArrayList<Character> surl = new ArrayList<Character>();
            Random rand = new Random();
            String alphabet = "abc1defgh2ij3klm4no5pq6rs7tuv8wx9yz";
            char shorturl = 'a';
            int longueur = alphabet.length();
            for(int i = 0; i < 5; i++) {
              int k = rand.nextInt(longueur);
               shorturl =  alphabet.charAt(k);
               surl.add(shorturl);
               
              //out.print(shorturl);
              
            }
            String test = (" "+surl.get(0)+surl.get(1)+surl.get(2)+surl.get(3)+surl.get(4));
            out.print(test);

            try {

            	DriverDatabase db = new DriverDatabase();
            	
                Connection connection = db.getConnection();
                Calendar currentTime = Calendar.getInstance();
                
                
                if(mdp_bjro != null) {
                	PreparedStatement create = connection.prepareStatement("INSERT INTO link (orginallink, pwd_link, create_date) VALUES (?, ?, ?, ?, ?, ?);");
                    create.setString(1, mdp_bjro);

                    create.executeUpdate();
                }

                PreparedStatement create = connection.prepareStatement("INSERT INTO link (orginallink, pwd_link, create_date) VALUES (?, ?, ?, ?, ?, ?);");
                create.setString(1, mdp_bjro);

                create.executeUpdate();
               
                
                    
                	response.sendRedirect("login.jsp");	
                
                connection.close();
            }  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }else {
        }
	}

}
