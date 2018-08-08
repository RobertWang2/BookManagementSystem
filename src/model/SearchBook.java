package model;

import JDBC.Books;
import JDBC.DataBaseUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认的情况下应该讲这个方法去掉
//        super.doGet(req, resp);
        Connection con = DataBaseUtil.GetConnection();
        String sql ;
        List<Books> L = new ArrayList<>();
        BookAction ba = null;
        Books book = new Books();
        String bookname =  req.getParameter("whichbook");
        sql = "select * from  book where name=" + "\'"+ bookname +"\'";
//        sql = "select * from book where name=bookname";
        //预编译
        try {
            //执行
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
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
            req.getSession().setAttribute("SearchBook",L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //重定向到原页面
        resp.sendRedirect("search_book.jsp");
    }
    }
