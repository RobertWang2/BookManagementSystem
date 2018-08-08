package user;

import JDBC.Books;
import model.AdminAction;
import model.BookAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private String name;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        name = req.getParameter("username");
        String password = req.getParameter("password");
        if(!name.equals("Robert_Wang") || !password.equals("123456"))
        {
            resp.sendRedirect("failed.jsp");
            return;
        }
        //管理员信息
        Admin admin = new Admin();
        AdminAction aa = null;
        try {
            aa = new AdminAction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //查询
           admin = aa.query(name);
           //设置会话属性
            req.getSession().setAttribute("ADMIN",admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //获取图书信息
        BookAction ba = null;
        try {
            ba = new BookAction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Books> L = new ArrayList<>();
        try {
            //查询
            L = ba.query();
            //设置会话属性
            req.getSession().setAttribute("BOOK",L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //最后跳转页面
        resp.sendRedirect("index.jsp");

    }
}
