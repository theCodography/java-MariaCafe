package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.postgresql.Driver;
/**
 *
 * @author Thaycacac
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://" + serverName + ":" + portNumber + "/" + dbName +"?sslmode=require";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "ec2-52-50-171-4.eu-west-1.compute.amazonaws.com";
    private final String dbName = "dafo4gv2nth1me";
    private final String portNumber = "5432";
    private final String userID = "rxiebivhlvefpr";
    private final String password = "33b56bf8b84c75e8a10cd7c591c51c6b0bcdf34bac0bbe93e5214fea08616991";

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}

     
//public class DBContext {
//
//    InitialContext initCxt;
//    Context envirCxt;
//    String serverName;
//    String port;
//    String username;
//    String password;
//    String dbName;
//    String imgFolder;
//
//    public DBContext() throws Exception {
//        initCxt = new InitialContext();
//        envirCxt = (Context) initCxt.lookup("java:/comp/env");
//        serverName = (String) envirCxt.lookup("severName");
//        port = (String) envirCxt.lookup("port");
//        username = (String) envirCxt.lookup("username");
//        password = (String) envirCxt.lookup("password");
//        dbName = (String) envirCxt.lookup("dbName");
//        imgFolder = (String) envirCxt.lookup("imgFolder");
//    }
//
//    public Connection getConnection() throws Exception {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection("jdbc:sqlserver://" + serverName + ":" + port + ";databaseName=" + dbName, username, password);
//    }
//
//    public String getResource() throws Exception {
//        return imgFolder;
//    }
//
//}
