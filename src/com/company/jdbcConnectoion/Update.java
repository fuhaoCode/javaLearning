package com.company.jdbcConnectoion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //2.创建数据库连接
            String url="jdbc:mysql://192.168.8.121:3306/hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
            String user="hbnujixin";
            String password="123456";
            connection=DriverManager.getConnection(url,user,password);

            //3.获取数据库操作对像
            statement=connection.createStatement();

            //4.执行sql语句
//            String sql="update userinfo set salary=36000 where realname='fh'";
//            int count=statement.executeUpdate(sql);

            String sqldelete="delete from userinfo";
            int count1=statement.executeUpdate(sqldelete);
            System.out.println(count1);

            //5.处理数据库结果集

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
