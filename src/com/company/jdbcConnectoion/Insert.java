package com.company.jdbcConnectoion;

import java.sql.*;

public class Insert {
    public static void main(String[] args) {
        Statement statement=null;
        Connection connection=null;
        try {

            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //2.创建数据库连接
            String url="jdbc:mysql://192.168.8.121:3306/hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
            String user="hbnujixin";
            String password="123456";
            connection = DriverManager.getConnection(url, user, password);

            //3.获取数据库操作对象
            statement=connection.createStatement();
            //4.执行sql语句
            String sql="insert into userinfo(username,password,realname,salary)" +
                    "values('root','123456','fh',18000)";
            int count = statement.executeUpdate(sql);
            System.out.println(count);

            //5.处理查询结果集

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            try {
                if (statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
