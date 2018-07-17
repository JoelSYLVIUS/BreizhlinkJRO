

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
@WebServlet(name = "servletUrl2", urlPatterns = "/url2")
public class Url2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Url2() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
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
		String IPuser = request.getParameter("ipuser");
		String pwd = request.getParameter("password");
		String deviceuser = request.getParameter("deviceuser");
		String navigateuruser = request.getParameter("navigateuruser");
		int id_link = 0;
		String clickok = "PASOK";
		String dureeok = "PASOK";
		String periodeoks = "PASOK";
		String periodeoke = "PASOK";
		String motdepasseok = "PASOK";
		int clickactuel = 0;
		java.sql.Date dateToBeChecked = null;
		java.sql.Date dateToBeCheckedstart = null;
		java.sql.Date dateToBeCheckedend = null;
		String datelimitbase = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		Calendar currentTime = Calendar.getInstance();
		
		
		
		
        try {
        	
        	DriverDatabase db = new DriverDatabase();
        	
            Connection connection = db.getConnection();
            
            String query = "SELECT * FROM link WHERE shortlink = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
              pst.setString(1, url);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
            	id_link = rs.getInt("id");
            	int clickmax = rs.getInt("max_click");
            	
            	String query1 = "SELECT * FROM mdp_bjro WHERE id_link = ?";
                PreparedStatement pst1 = connection.prepareStatement(query1);
                pst1.setLong(1, id_link);
                ResultSet rs1 = pst1.executeQuery();
                
                if(rs1.next()) {
                	
                	String mdpbase = rs1.getString("mdp_link");
                	if(mdpbase == pwd) {
                		motdepasseok = "OK";
                	}
                	else { 
                		motdepasseok = "NOMDP";
                	}
                }
                
                if(rs.getInt("max_click") != 0) {
            		String query2 = "SELECT current_click FROM statistiques WHERE id_link = ? ";
                    PreparedStatement pst2 = connection.prepareStatement(query1);
                      pst2.setLong(1, id_link);
                    ResultSet rs2 = pst1.executeQuery();
                    if(rs2.next()) {
                    	 if(rs2.getInt("current_click") < rs.getInt("max_click") || rs2.getInt("current_click") == rs.getInt("max_click")) {
                    		 clickactuel = rs2.getInt("current_click") + 1;
                    		 clickok = "OK";
                    	 }
                    }
                    
                }else {
                	clickok = "NOCLICK";
                }
                    if(rs.getDate("date_limit") != null) {
                    	dateToBeChecked= new java.sql.Date((rs.getDate("date_limit")).getDate());
                    	if(dateToBeChecked.compareTo(date) > 0) {
                    		dureeok = "OK";
                    	}else if (dateToBeChecked.compareTo(date) == 0) {
                    		dureeok = "OK";
                    	}else if (dateToBeChecked.compareTo(date) < 0) {
                    		dureeok = "PASOK";
                    	}
                    }
                    else {
                    	dureeok = "NODATE";
                    }
                    
                    if(rs.getDate("start_date") != null && rs.getDate("end_date") != null) {
                    	dateToBeCheckedstart = new java.sql.Date((rs.getDate("start_date")).getDate());
                    	dateToBeCheckedend = new java.sql.Date((rs.getDate("end_date")).getDate());
                    	if (dateToBeCheckedstart.compareTo(date) > 0) {
                    		periodeoks = "PASOK";
                        } else if (dateToBeCheckedstart.compareTo(date) < 0) {
                        	periodeoks = "OKPERIOD";
                        } else if (dateToBeCheckedstart.compareTo(date) == 0) {
                        	periodeoks = "OKPERIOD";
                        }
                    	if (dateToBeCheckedend.compareTo(date) > 0) {
                    		periodeoks = "OKPERIOD";
                        } else if (dateToBeCheckedend.compareTo(date) < 0) {
                        	periodeoks = "PASOK";
                        } else if (dateToBeCheckedend.compareTo(date) == 0) {
                        	periodeoks = "OKPERIOD";
                        }
                    	
                    }
                    else {
                    	periodeoks = "NOPERIOD";
                    	periodeoke = "NOPERIOD";
                    }	 
                }    
            
            else {
            	response.sendRedirect("error404bis.html");
            }
             
            
			 if(motdepasseok == "OK" ||
            		motdepasseok == "NOMDP" ||
            		clickok == "OK" || 
            		clickok == "NOCLICK" || 
            		dureeok == "OK" || 
            		dureeok == "NODATE"|| 
            		periodeoks == "OK" && periodeoke == "OK" || 
            		periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" || 
            		clickok == "OK" && dureeok == "OK" ||
            		clickok == "NOCLICK" && dureeok == "NODATE" ||
            		clickok == "NOCLICK" && dureeok == "OK" ||
            		clickok == "OK" && dureeok == "NODATE" ||
            		clickok == "OK" && periodeoks == "OK" && periodeoke == "OK" ||
            		clickok == "OK" && periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" ||
            		clickok == "NOCLICK" && periodeoks == "OK" && periodeoke == "OK" ||
            		clickok == "NOCLICK" && periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" ||
            		clickok == "OK" && motdepasseok == "OK" || 
            		clickok == "NOCLICK" && motdepasseok == "OK" || 
            		dureeok == "OK" && motdepasseok == "OK" || 
            		dureeok == "NODATE" && motdepasseok == "OK"|| 
            		periodeoks == "OK" && periodeoke == "OK" && motdepasseok == "OK" || 
            		periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" && motdepasseok == "OK" || 
            		clickok == "OK" && dureeok == "OK" && motdepasseok == "OK" ||
            		clickok == "NOCLICK" && dureeok == "NODATE" && motdepasseok == "OK" ||
            		clickok == "NOCLICK" && dureeok == "OK" && motdepasseok == "OK" ||
            		clickok == "OK" && dureeok == "NODATE" && motdepasseok == "OK" ||
            		clickok == "OK" && periodeoks == "OK" && periodeoke == "OK" && motdepasseok == "OK" ||
            		clickok == "OK" && periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" && motdepasseok == "OK" ||
            		clickok == "NOCLICK" && periodeoks == "OK" && periodeoke == "OK" && motdepasseok == "OK" ||
            		clickok == "NOCLICK" && periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" && motdepasseok == "OK" ||
            		clickok == "OK" && motdepasseok == "NOMDP" || 
            		clickok == "NOCLICK" && motdepasseok == "NOMDP" || 
            		dureeok == "OK" && motdepasseok == "NOMDP" || 
            		dureeok == "NODATE" && motdepasseok == "NOMDP"|| 
            		periodeoks == "OK" && periodeoke == "OK" && motdepasseok == "NOMDP" || 
            		periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" && motdepasseok == "NOMDP" || 
            		clickok == "OK" && dureeok == "OK" && motdepasseok == "NOMDP" ||
            		clickok == "NOCLICK" && dureeok == "NODATE" && motdepasseok == "NOMDP" ||
            		clickok == "NOCLICK" && dureeok == "OK" && motdepasseok == "NOMDP" ||
            		clickok == "OK" && dureeok == "NODATE" && motdepasseok == "NOMDP" ||
            		clickok == "OK" && periodeoks == "OK" && periodeoke == "OK" && motdepasseok == "NOMDP" ||
            		clickok == "OK" && periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" && motdepasseok == "NOMDP" ||
            		clickok == "NOCLICK" && periodeoks == "OK" && periodeoke == "OK" && motdepasseok == "NOMDP" ||
            		clickok == "NOCLICK" && periodeoks == "NOPERIOD" && periodeoke == "NOPERIOD" && motdepasseok == "NOMDP"
            		) {
            
                    PreparedStatement create = connection.prepareStatement("INSERT INTO statistiques (id_link, current_click, ip_user, date, navigateur, device) VALUES (?, ?, ?, ?, ?, ?);");
                    create.setLong(1, id_link);
                    create.setLong(2, clickactuel);
                    create.setString(3, IPuser);
                    create.setDate(4, new java.sql.Date(currentTime.getTime().getTime()));
                    create.setString(5, navigateuruser);
                    create.setString(6, deviceuser);

                    create.executeUpdate();
                    
                    
                    String query3 = "SELECT originallink FROM link WHERE shortlink = ? ";
                    PreparedStatement pst3 = connection.prepareStatement(query3);
                      pst3.setString(1, url);
                    ResultSet rs3 = pst3.executeQuery();
                    
                    if(rs3.next()) {
                    	String link = rs3.getString("originallink");
                    	response.sendRedirect(link);
                    }
            	
            }else {
            	response.sendRedirect("/nodispo.html");
            }            
            connection.close();
        }  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	
	}

}
