package JDBC;

import model.AdminAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DataBaseUtil {
    private static final String user = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static Connection con=null;

    public static  Connection GetConnection()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}

