package model;
import JDBC.DataBaseUtil;
import user.Admin;
import java.sql.*;

public class AdminAction {
    private static Connection con;
    private  String sql;
    public AdminAction() throws SQLException {
        con = DataBaseUtil.GetConnection();
        sql = "";
    }
    public Admin query(String names) throws SQLException {
        sql = "select * from user where name=" + "\'" + names + "\'";
        con = DataBaseUtil.GetConnection();
        Statement st = con.createStatement();
        ResultSet rs =  st.executeQuery(sql);
        Admin admin = new Admin();
        while(rs.next()){
            admin.setId(rs.getInt("id"));
            admin.setName(rs.getString("name"));
            admin.setAge(rs.getInt("age"));
            admin.setMale("sex");
            admin.setPassword("password");
        }
        return  admin;
    }
}
