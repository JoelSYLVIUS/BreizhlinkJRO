

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
		PrintStream out = new PrintStream(response.getOutputStream());
		String url = request.getParameter("url");
		InetAddress IP = InetAddress.getLocalHost();
		String MonIP = IP.getHostAddress();
		String user_agent = request.getHeader("user-agent");
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
                    	//out.println(rs1.getString("mdp_link"));
                    	
                    	out.println("<!DOCTYPE html ><html>");
                        out.println("<head>\n" + 
                        		"    <title>Mot de Passe</title>\n" + 
                        		"    <link rel=\"stylesheet\" href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css\">\n" + 
                        		"    <link rel=\"stylesheet\" href=\"static/css/materialize.min.css\">\n" + 
                        		"    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n" + 
                        		"    <link href=\"https://fonts.googleapis.com/css?family=Oswald\" rel=\"stylesheet\"><style>\n" +
                        		"            body{\n" +
                        		"			 display: flex;\n" + 
                        		"            min-height: 100vh;\n" + 
                        		"            flex-direction: column;\n" + 
                        		"            background-image: url(\"static/img/bg.jpg\");\n" + 
                        		"            background-repeat:no-repeat;\n" + 
                        		"            background-size: 100% 100%;\n" + 
                        		"            background-position: fixed;\n" + 
                        		"          }\n" + 
                        		"          .margTopForH1{\n" + 
                        		"            margin-top:-15vh;\n" + 
                        		"          }\n" + 
                        		"          .margTopForMainButton{\n" + 
                        		"            margin-top:5vh;\n" + 
                        		"          }\n" + 
                        		"          .tshadb{\n" + 
                        		"		  	text-shadow: 0 0 10px #000000;\n" + 
                        		"		  }\n" + 
                        		"          a{\n" + 
                        		"            color:white;\n" + 
                        		"          }\n" + 
                        		"          .ptot{\n" + 
                        		"		  	padding: 10px;\n" + 
                        		"		  }\n" + 
                        		"		  .rad10{\n" + 
                        		"		  border-radius:10px;\n" + 
                        		"		  }"
                        		+ "			.formgen{\n" + 
                        		"				background-color: rgba(0, 0, 0, 0.4);\n"
                        		+ "				padding: 20px!important;\n" + 
                        		"				border-radius:10px;\n" + 
                        		"				border:1px solid #ffffff;\n" + 
                        		"			}</style>\n" + 
                        		"</head>\n" + 
                        		"<body>\n" + 
                        		"<div style=\"width: 40%;margin: auto;text-align:center\">\n" +
                        		"<h1 class=\" amber-text tshadb\">Mot de passe</h1>"
                        		+ "<div class=\"row\">\n" + 
                        		"       <form action=\"\" method=\"post\" class=\"col s12 inplink formgen\">\n" + 
                        		"               <div class=\"input-field col s12\">\n" + 
                        		"                     <input name=\"password\" id=\"password\" type=\"password\" class=\"validate white-text tshadb inplink\">\n" + 
                        		"               </div>\n" + 
                        		"             </div>\n" + 
                        		"             <div class\"row\">\n" + 
                        		"                 <div class=\"col l12 center\">\n" + 
                        		"                     <input type=\"submit\" value=\"Valider\" class=\"btn btn-success amber hoverable\">\n" + 
                        		"                 </div>\n" + 
                        		"             </div>\n" + 
                        		"         </form>\n" + 
                        		"  </div>\n" +
                        		"<a href=\"/javaSite/login\">Se connecter</a>\n" + 
                        		"<jsp:include page=\"inc/footer.jsp\"/>");
                        out.println("</html>");
                    }
            	}        
            	
            	out.println("<!DOCTYPE html ><html>");
                out.println("<head>\n" + 
                		"    <title>Mot de Passe</title>\n" + 
                		"    <link rel=\"stylesheet\" href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css\">\n" + 
                		"    <link rel=\"stylesheet\" href=\"static/css/materialize.min.css\">\n" + 
                		"    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n" + 
                		"    <link href=\"https://fonts.googleapis.com/css?family=Oswald\" rel=\"stylesheet\"><style>\n" +
                		"            body{\n" +
                		"			 display: flex;\n" + 
                		"            min-height: 100vh;\n" + 
                		"            flex-direction: column;\n" + 
                		"            background-image: url(\"static/img/bg.jpg\");\n" + 
                		"            background-repeat:no-repeat;\n" + 
                		"            background-size: 100% 100%;\n" + 
                		"            background-position: fixed;\n" + 
                		"          }\n" + 
                		"          .margTopForH1{\n" + 
                		"            margin-top:-15vh;\n" + 
                		"          }\n" + 
                		"          .margTopForMainButton{\n" + 
                		"            margin-top:5vh;\n" + 
                		"          }\n" + 
                		"          .tshadb{\n" + 
                		"		  	text-shadow: 0 0 10px #000000;\n" + 
                		"		  }\n" + 
                		"          a{\n" + 
                		"            color:white;\n" + 
                		"          }\n" + 
                		"          .ptot{\n" + 
                		"		  	padding: 10px;\n" + 
                		"		  }\n" + 
                		"		  .rad10{\n" + 
                		"		  border-radius:10px;\n" + 
                		"		  }"
                		+ "			.formgen{\n" + 
                		"				background-color: rgba(0, 0, 0, 0.4);\n"
                		+ "				padding: 20px!important;\n" + 
                		"				border-radius:10px;\n" + 
                		"				border:1px solid #ffffff;\n" + 
                		"			}</style>\n" + 
                		"</head>\n" + 
                		"<body>\n" + 
                		"<div style=\"width: 40%;margin: auto;text-align:center\">\n" +
                		"<h1 class=\" amber-text tshadb\">Captcha</h1>"
                		+ "<div class=\"row\">"
                		+ "<div class=\"row\">\n" + 
                		"		             		<div class=\"g-recaptcha\" data-sitekey=\"6Ld9Al0UAAAAAN3J_SXGMfKywC5M2pa4nYVYSaZI\"></div>\n" + 
                		"	</div>\n" + 
                		
                		"  </div>\n" +
                		"<a href=\"/javaSite/login\">Se connecter</a>\n" + 
                		"<jsp:include page=\"inc/footer.jsp\"/>");
                out.println("</html>");
            	//response.sendRedirect("index.jsp");	
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
