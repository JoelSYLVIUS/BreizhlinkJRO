

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Raccourcisusr
 */
@WebServlet(name = "servletRaccourcisusr", urlPatterns = "/raccourcisusr")
public class Raccourcisusr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private char[] shorturl;
	private ServletRequest session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Raccourcisusr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//PrintStream out = new PrintStream(response.getOutputStream());
		if (request.getParameter("url") != null || request.getParameter("url") != " " || request.getParameter("url") != "" && request.getParameter("iduser") != null) {
			String url = request.getParameter("url");
			String iduser = request.getParameter("iduser");
            String mdp_bjro = request.getParameter("mdp");
            String datelimite = request.getParameter("datelimit");
            if(request.getParameter("datelimit") == "") {
            	datelimite = null;
            }
            String check = request.getParameter("check");
            if(request.getParameter("check") == "") {
            	 check = null;
            }
            String clicmax = request.getParameter("clicmax");
            if(request.getParameter("clicmax") == "") {
            	clicmax = null;
            }
            String datestart = request.getParameter("datestart");
            if(request.getParameter("datestart") == "") {
            	datestart = null;
            }
            String dateend = request.getParameter("dateend");
            if(request.getParameter("dateend") == "") {
            	dateend = null;
            }
            
            
            
            ArrayList<Character> surl = new ArrayList<Character>();
            Random rand = new Random();
            String alphabet = "abc1defgh2ij3klm4no5pq6rs7tuv8wx9y0z";
            char shorturl = 'a';
            int longueur = alphabet.length();
            for(int i = 0; i < 5; i++) {
              int k = rand.nextInt(longueur);
               shorturl =  alphabet.charAt(k);
               surl.add(shorturl);         
            }
            String monurl = (" "+surl.get(0)+surl.get(1)+surl.get(2)+surl.get(3)+surl.get(4));
            String urlshort = monurl.replaceFirst(" ", "");
            
            try {
            	DriverDatabase db = new DriverDatabase();
                if(mdp_bjro != null) {
                	
                	
                    Connection connection = db.getConnection();
                    Calendar currentTime = Calendar.getInstance();
                    
                	PreparedStatement create = connection.prepareStatement("INSERT INTO link (originallink, shortlink, pwd_link, create_date, id_user, captcha, date_limit, start_date, end_date, max_click) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                    create.setString(1, url);
                    create.setString(2, urlshort);
                    create.setString(3, "1");
                    create.setDate(4, new java.sql.Date(currentTime.getTime().getTime()));
                    create.setString(5, iduser);
                    create.setString(6, check);
                    create.setString(7, datelimite);
                    create.setString(8, datestart);
                    create.setString(9, dateend);
                    create.setString(10, clicmax);
                    
                    create.executeUpdate();
                    
                    
                    String query = "SELECT * FROM link WHERE shortlink = ?";
                    PreparedStatement pst = connection.prepareStatement(query);
                      pst.setString(1, urlshort);
                    ResultSet rs = pst.executeQuery();
                    
                    int id_user = 0;
                    if(rs.next()) {
                    	id_user = rs.getInt("id");
                    	PreparedStatement create1 = connection.prepareStatement("INSERT INTO mdp_bjro (mdp_link, id_link) VALUES (?, ?);");
                        create1.setString(1, mdp_bjro);
                        create1.setString(2, ""+id_user+"");
                        
                        create1.executeUpdate();
                        connection.close();
                        
                        request.setAttribute("urlshort", urlshort);
                        getServletContext().getRequestDispatcher("/affiche_url.jsp").forward(request, response);
                        
                    }
                    
                }
                else {
                	Connection connection = db.getConnection(); 
                    Calendar currentTime = Calendar.getInstance();
                	
                	PreparedStatement create2 = connection.prepareStatement("INSERT INTO link (originallink, shortlink, pwd_link, create_date, id_user, captcha, date_limit, start_date, end_date, max_click) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                	create2.setString(1, url);
                    create2.setString(2, urlshort);
                    create2.setString(3, "0");
                    create2.setDate(4, new java.sql.Date(currentTime.getTime().getTime()));
                    create2.setString(5, iduser);
                    create2.setString(6, check);
                    create2.setString(7, datelimite);
                    create2.setString(8, datestart);
                    create2.setString(9, dateend);
                    create2.setString(10, clicmax);

                    create2.executeUpdate();
                    connection.close();
                    
                    request.setAttribute("urlshort", urlshort);
                    
                    getServletContext().getRequestDispatcher("/affiche_url.jsp").forward(request, response);
                }
                
                
               
            }  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }else {
            	response.sendRedirect("login.jsp");
        }
	}

}
