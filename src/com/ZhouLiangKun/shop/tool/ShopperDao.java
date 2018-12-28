package com.ZhouLiangKun.shop.tool;

import java.sql.Connection;


import com.ZhouLiangKun.shop.pojo.Shopper;




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
	

}