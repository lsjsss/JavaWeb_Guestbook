package com.guestbook.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTools {
    //数据库连接需要的四个信息
    //1 数据库的驱动信息
    private static String driver = "com.mysql.jdbc.Driver";
    //2 数据库的连接字符串信息
    private static String url = "jdbc:mysql://127.0.0.1:3306/guestbook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //3 连接数据库的用户名
    private static String user = "root";
    //4 连接数据路的密码
    private static String password = "root";

    //加载数据库驱动,静态代码块，反射
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库访问连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭各种数据访问对象，为什么要关闭？
     * @param conn
     * @param st
     * @param rs
     */
    public static void close(Connection conn, Statement st, ResultSet rs) {
        //在使用过程中，先出现的后关闭，后出现的先关闭(null)
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
               if(st != null){
                   try {
                       st.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }finally {
                       if(conn != null){
                           try {
                               conn.close();
                           } catch (SQLException e) {
                               e.printStackTrace();
                           }
                       }
                   }
               }
            }
        }
    }
    public static void main(String[] args) {
    	Connection conn = DBTools.getConnection();
    	System.out.println(conn);
	}
}
