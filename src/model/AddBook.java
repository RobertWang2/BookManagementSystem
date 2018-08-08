package model;

import JDBC.Books;
import JDBC.DataBaseUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class AddBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        Connection con = DataBaseUtil.GetConnection();
        String sql;
        Books book = new Books();
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        sql = "insert into book (id,name,author,price) value(?,?,?,?)";
        //预编译
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,author);
            ps.setDouble(4,price);
            //执行
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Books> L = new ArrayList<>();
        BookAction ba = null;
        try {
            //查询
//            L = ba.query();
            Statement st = con.createStatement();
            sql = "select id,name,author,price from book";
            ResultSet rs =  st.executeQuery(sql);
            while (rs.next())
            {
                book = new Books();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                L.add(book);
            }
            //设置会话属性
            req.getSession().setAttribute("BOOK",L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("index.jsp");
    }
}
