

import java.sql.*;

public class DriverDatabase {
    private String url = "jdbc:mysql://localhost:8889/Esgi_breizhlink";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;

    public Connection getConnection() throws SQLException {
        if (this.connection == null)
        {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/Esgi_breizhlink", "root", "root");
            return this.connection;
        }
        return this.connection;
    }
}
