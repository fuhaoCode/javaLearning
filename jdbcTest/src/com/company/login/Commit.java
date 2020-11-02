package com.company.login;

import java.sql.*;
import java.util.ResourceBundle;

public class Commit {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        ResourceBundle resourceBundle=ResourceBundle.getBundle("dataJdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");

        try {
            //1.注册驱动
            Class.forName(driver);
            //2.创建数据库连接
            connection = DriverManager.getConnection(url, user, password);
            //3.获取数据库操作对象
            String selectSql = "update userinfo set salary=salary+? and username=?";
            ps = connection.prepareStatement(selectSql);
            connection.setAutoCommit(false);
            //执行sql语句
            ps.setString(1,"2000");
            ps.setString(2,"chendikai");
            ps.executeUpdate();

            ps.setString(1,"2000");
            ps.setString(2,"图灵一号");
            ps.executeUpdate();
            //5.提交事务
            connection.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            //6.释放资源
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
