package model;
import JDBC.Books;
import JDBC.DataBaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookAction {
    private Connection con;
    private  String sql;
    public BookAction() throws SQLException {
        con = DataBaseUtil.GetConnection();
        sql="";
    }
    public void addBook(Books book) throws SQLException {
        //sql语句
        sql = "insert into book (id,name,author,price) value(?,?,?,?)";
        //预编译
        PreparedStatement ps = con.prepareStatement(sql);
        //设置字段
        ps.setInt(1,book.getId());
        ps.setString(2,book.getName());
        ps.setString(3,book.getAuthor());
        ps.setDouble(4,book.getPrice());
        //执行
        ps.execute();
    }
    public void delBook(int id) throws SQLException {
//sql语句
        sql = "delete from book where id=?";
        //预编译
        PreparedStatement ps = con.prepareStatement(sql);
        //设置字段
        ps.setInt(1,id);
        //执行
        ps.execute();
    }
    public void update(Books books) throws SQLException {
//sql语句
        sql = "update book set name=?,author=?,price=? where id=?";
        //预编译
        PreparedStatement ps = con.prepareStatement(sql);
        //设置字段
        ps.setInt(2,books.getId());
        ps.setString(3,books.getName());
        ps.setString(4,books.getAuthor());
        ps.setDouble(1,books.getPrice());
        //执行
        ps.execute();
    }
    public List<Books> query() throws SQLException {
        List<Books> L = new ArrayList<>();
        Books book = new Books();
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
        return  L;
    }

    public List<Books> query(List<Map<String,Object> >params) throws SQLException {
        List<Books> L = new ArrayList<>();
        Map<String,Object> map;
        StringBuffer sb = new StringBuffer();
        sb.append("select * from book where 1=1 ");
        if( params!=null && params.size()>0)
        {
            int i;
            for ( i = 0; i <params.size() ; i++) {
                map = params.get(i);
                sb.append(" and " + map.get("name") + map.get("rela") + map.get("value"));
            }
        }
        PreparedStatement ps = con.prepareStatement(sb.toString());
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            Books book = new Books();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getDouble("price"));
            L.add(book);
        }
        return  L;
    }
}

