package com.company.jdbcConnectoion;

import java.sql.*;
import java.util.ResourceBundle;

public class Query {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        ResourceBundle resourceBundle=ResourceBundle.getBundle("dataJdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        try {
            //1.注册驱动
            Class.forName(driver);
            //2.创建数据库连接
            connection= DriverManager.getConnection(url,user,password);
            //3.获取数据库操作对象
            statement=connection.createStatement();
            //执行sql语句
            String selectSql="select username,password,realname,salary from userinfo";
            resultSet=statement.executeQuery(selectSql);
            //5.处理查询结果集
            System.out.println("\t姓名\t" + "密码\t" + "真实名\t" + "薪水\t");
            /*while (resultSet.next()){
                String username=resultSet.getString(1);
                String pwd=resultSet.getString(2);
                String rel=resultSet.getString(3);
                String sal=resultSet.getString(4);
                System.out.println(username+" \t"+pwd+" \t"+rel+" \t"+sal);
            }*/
           /* while (resultSet.next()){
                String username=resultSet.getString("username");
                String pwd=resultSet.getString("password");
                String real=resultSet.getString("realname");
                double sal=resultSet.getDouble("salary");
                System.out.println(username+" \t"+pwd+" \t"+real+" \t"+sal);
            }*/
            while (resultSet.next()){
                String username=resultSet.getString("username");
                String pwd=resultSet.getString("password");
                String real=resultSet.getString("realname");
                double sal=resultSet.getDouble("salary");
                System.out.println(username+" \t"+pwd+" \t"+real+" \t"+sal);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
