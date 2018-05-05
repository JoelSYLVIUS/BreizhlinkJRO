

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;

public class Login extends DriverDatabase{
    private String username;
    private String password;
    private Date created_at;
    private String algorithm = "SHA-256";

    public Login (String username, String password, Date created_at) {
        this.username = username;
        this.password = password;
        this.created_at = created_at;
    }

    public void checkUser(String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = this.getConnection();
        Statement s = connection.createStatement();
        ResultSet res = s.executeQuery("Select username, password from users where username = "+ username + " and password = "+ password);
        res.getRow();
        while (res.next()) {
            System.out.println(res.getInt(1)+ " "+ res.getString(2));
        }

        connection.close();
    }
}
