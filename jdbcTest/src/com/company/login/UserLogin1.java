package com.company.login;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
//解决sql注入问题

public class UserLogin1 {
    public static void main(String[] args) {
        //1.用户输入用户名和密码入口
        Map<String,String> userinfo=initUI();

        //2.校验用户名和密码
        boolean successLogin = login(userinfo);

        //3.登录成功或失败，给用户提示信息
        System.out.println(successLogin?"登录成功":"登录失败");

    }

    private static boolean login(Map<String, String> userinfo) {
        boolean flag=false;
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        ResourceBundle resourceBundle=ResourceBundle.getBundle("dataJdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");

        String myUser=userinfo.get("username");
        String myPassword=userinfo.get("password");
        try {
            //1.注册驱动
            Class.forName(driver);
            //2.创建数据库连接
            connection = DriverManager.getConnection(url, user, password);
            //3.获取数据库操作对象
            String selectSql = "select * from userinfo where username=? and password=?";
            ps = connection.prepareStatement(selectSql);
            //执行sql语句
            ps.setString(1,myUser);
            ps.setString(2,myPassword);
            rs = ps.executeQuery();

            //5.处理查询结果集
            while (rs.next()){
                flag=true;
                break;
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
        return flag;
    }


    private static Map<String, String> initUI () {
        Map<String,String> hashMap=new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入账号：");
        String username=scanner.nextLine();

        System.out.println("请输入密码：");
        String password=scanner.nextLine();

        hashMap.put("username",username);
        hashMap.put("password",password);
        return hashMap;

    }
}
