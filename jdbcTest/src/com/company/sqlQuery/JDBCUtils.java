package com.company.sqlQuery;

import java.sql.*;
import java.util.ResourceBundle;

//解决sql注入问题

public class JDBCUtils {

    private static Connection connection=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs=null;

    private static ResourceBundle resourceBundle=ResourceBundle.getBundle("dataJdbc");
    private static String driver = resourceBundle.getString("driver");
    private static String url = resourceBundle.getString("url");
    private static String user = resourceBundle.getString("username");
    private static String password = resourceBundle.getString("password");
    //连接数据库
    public static Connection getConnection(){
        try {
            //1.注册驱动
            Class.forName(driver);
            //2.创建数据库连接
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }

    //关闭数据库
    public static void close() {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    //查询
    public static void query() {

        try {
            connection=getConnection();
            connection.setAutoCommit(false);
            String selectSql="select username,password,realname,salary from userinfo";
            ps = connection.prepareStatement(selectSql);
            //5.处理查询结果集
            rs=ps.executeQuery();
            System.out.println("\t姓名\t" + "密码\t" + "真实名\t" + "薪水\t");
            while (rs.next()){
                String username=rs.getString("username");
                String pwd=rs.getString("password");
                String real=rs.getString("realname");
                double sal=rs.getDouble("salary");
                System.out.println(username+" \t"+pwd+" \t"+real+" \t"+sal);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }


    }

    //删除
    public static void delete() {
        try {
            //3.获取数据库操作对象
            connection=getConnection();
            String sql="delete from userinfo where username=?";
            ps = connection.prepareStatement(sql);
            //执行sql语句
            ps.setString(1,"root");
            int result=ps.executeUpdate();
            System.out.println(result);
            //5.处理查询结果集
            if (result>0){
                System.out.println("删除数据成功");
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            close();
        }
    }
    //修改
    public static void update() {
        try {
            connection=getConnection();
            //3.获取数据库操作对象
            String sql="update userinfo set salary=? where realname=?";
            ps = connection.prepareStatement(sql);
            //执行sql语句
            ps.setDouble(1,15000);
            ps.setString(2,"fh");
            int result=ps.executeUpdate();

            //5.处理查询结果集
            if (result>0){
                System.out.println("修改数据成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    //添加
    public static void insert() {
        try {
            connection=getConnection();
            //3.获取数据库操作对象
            String sql="insert into userinfo(username,password,realname,salary)" +
                    "values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            //执行sql语句
            ps.setString(1,"111");
            ps.setString(2,"2018222");
            ps.setString(3,"cs");
            ps.setDouble(4,12000);
            int result=ps.executeUpdate();

            //5.处理查询结果集
            if (result==1){
                System.out.println("插入数据成功");
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }



}
