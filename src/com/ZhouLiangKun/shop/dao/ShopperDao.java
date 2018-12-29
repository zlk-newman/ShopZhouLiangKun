package com.ZhouLiangKun.shop.dao;

import java.sql.Connection;

import com.ZhouLiangKun.shop.pojo.Goods;
import com.ZhouLiangKun.shop.pojo.Shopper;
import com.ZhouLiangKun.shop.tool.DButil;




public class ShopperDao {
	public boolean addUser(Shopper user) {
		
		boolean flage=false;
		
		Connection conn=DButil.getConnection();
		String sql="insert into shopper value(?,?)";
		 
		int n=DButil.executeUpdate(sql, new Object[] {
				user.getUname(),user.getUpassword()});
		if(n==1) flage=true;
		
		DButil.close(null,null,conn);  
		
		return flage;
}
	public boolean delUser(Shopper user) {
			boolean flage=false;
		Connection conn=DButil.getConnection();
		String sql="delete from shopper where Uname=?";
		 
		int n=DButil.executeUpdate(sql, new Object[] {
				user.getUname()});
		if(n==1) flage=true;
		
		DButil.close(null,null,conn);  
		return flage;
		
	}	
	public boolean updateUser(Shopper user) {
		 user.setUname(null);
		 user.setUpassword(null);

		boolean flage=false;
		Connection conn=DButil.getConnection();
		String sql="update shopper set Upassword=? where Uname=?";
		int n=DButil.executeUpdate(sql,new Object[] {
				user.getUpassword(),user.getUname()
		});
		if(n==1)flage=true;
		DButil.close(null, null, conn);
		return flage;
	}


}