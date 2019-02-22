package com.lw.pj5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	private static String DriverName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/eshop";
	private static String username="root";
	private static String password="root";
	private static Connection conn=null;
	//创建连接
	public static Connection getConnection(){
		try{
			Class.forName(DriverName);
			conn=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	//关闭连接
	public static void closeConnection(){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
	