

import java.sql.*;

public class DriverDatabase {
    private String url = "jdbc:mysql://localhost:8889/Esgi_breizhlink";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;

    public Connection getConnection() throws SQLException {
        if (this.connection == null)
        {
        	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/Esgi_breizhlink", "root", "root");
            return this.connection;
        }
        return this.connection;
    }
}
