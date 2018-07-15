

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Url
 */
@WebServlet(name = "servletUrl", urlPatterns = "/url")
public class Url extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Url() {
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
	
	public static void disableWarning() {
	    System.err.close();
	    System.setErr(System.out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintStream out = new PrintStream(response.getOutputStream());
		String url = request.getParameter("url");
		InetAddress IP = InetAddress.getLocalHost();
		String MonIP = IP.getHostAddress();
		String user_agent = request.getHeader("user-agent");
		String captchaoklink = "PASOK";
		String mdpoklink = "PASOK";
		String s = url;
        int n = 5; // nbre de caractères
        int length = s.length();
        String shorturl = s.substring(length -n, length);
        
        String[] myTab = user_agent.split(" ");
        String device = myTab[1] + " " + myTab[2] + " " + myTab[3] + " " + myTab[4] + " " + myTab[5] + " " + myTab[6];
        String navigateur = myTab[12];
        //out.println(shorturl);
        //out.println(MonIP);
        //out.println(user_agent);
        
        //out.println(device);
        
        
        //out.println(navigateur);
        
        try {
        	
        	DriverDatabase db = new DriverDatabase();
        	
            Connection connection = db.getConnection();
            
            String query = "SELECT * FROM link WHERE shortlink = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
              pst.setString(1, shorturl);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
            	//out.println("cette url existe !!!");
            	int id_link = rs.getInt("id");
            	//out.println(id_link);
            	//out.println(rs.getInt("pwd_link"));
            	//out.println(rs.getString("originallink"));
            	if(rs.getInt("pwd_link") != 0) {
            		String query1 = "SELECT * FROM mdp_bjro WHERE id_link = ? ";
                    PreparedStatement pst1 = connection.prepareStatement(query1);
                      pst1.setLong(1, id_link);
                    ResultSet rs1 = pst1.executeQuery();
                    if(rs1.next()) {
                    	String mdplinkbase = rs1.getString("mdp_link");
                    	mdpoklink = "OK";
                    	//out.println(mdplinkbase);
                    	//out.println(mdpoklink);   
                    }
            	}
            	
            	if(rs.getInt("captcha") != 0) {
            		
                    	captchaoklink = "OK";
                    	//out.println(captchaoklink);   
            	}
            	
            	HttpSession session = request.getSession();
            	
            	session.setAttribute("url", shorturl);
                session.setAttribute("ipuser", MonIP);
                session.setAttribute("deviceuser", device);
                session.setAttribute("navigateuruser", navigateur);
                session.setAttribute("captchaok", captchaoklink);
                session.setAttribute("mdpok", mdpoklink);
                
                if((session.getAttribute("pseudo")) != null) { 
                
                	getServletContext().getRequestDispatcher("/valurl/validUrlUser.jsp").forward(request, response);
                }
                else {
                	getServletContext().getRequestDispatcher("/valurl/validUrl.jsp").forward(request, response);
                }
            	
            		
            }
            else {
            	response.sendRedirect("error404bis.html");
            }
            connection.close();
        }  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	
	}

}
