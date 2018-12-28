package com.ZhouLiangKun.shop.tool;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
	
	private static	Connection conn=null;
	private static PreparedStatement stsm=null;
	private static	ResultSet rs=null; 
	
	static {
		
		try {
			Class.forName(Config.getValue("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	public static Connection getConnection() {

		String url=Config.getValue("url");
		String username=Config.getValue("username");
		String password=Config.getValue("password");
		
		try {
			conn =DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	//针对增删改的执行
	public static int executeUpdate(String sql ,Object[] params) {
		
		int n=0;
		try {
			stsm=conn.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					stsm.setObject(i+1, params[i]);
				}
			}
			n=stsm.executeUpdate();
		} catch (SQLException e) {

			//e.printStackTrace();//表示显示异常
			System.out.println("用户名已存在！");
		}
		
		return n;
		
	}
	
	/*//针对查询
	public static ResultSet executeQuery(String sql ,Object[] param)  {
			

			try {
				stsm=conn.prepareStatement(sql);
				if(param!=null) {
					for(int i=0;i<param.length;i++) {
						stsm.setObject(i+1, param[i]);
					}
				}
				
				rs=stsm.executeQuery();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		return rs;
	}
*/

//释放资源
	public static void close(ResultSet rs,PreparedStatement stsm,Connection conn) {

		try {
                if(rs!=null)rs.close();
				if(stsm!=null)stsm.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			
	}
public static void main(String[] args)  {
		
		Connection conn=DButil.getConnection();
		
		System.out.println("连接成功");
		
		DButil.close(null, null, conn);
		
		System.out.println("关闭连接");
		
	}


}

