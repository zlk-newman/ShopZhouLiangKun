package com.ZhouLiangKun.shop.tool;

import java.sql.Connection;

import com.ZhouLiangKun.shop.pojo.Goods;

/*
 * 对于商品数据库的增删
 * 
 */



public class GoodsDao {
	public boolean addUser(Goods goods) {
		
		boolean flage=false;
		
		Connection conn=DButil.getConnection();
		String sql="insert into goods value(?,?,?,?)";
		 
		int n=DButil.executeUpdate(sql, new Object[] {
				goods.getId(),goods.getDname(),goods.getNumber(),goods.getPrice()});
		if(n==1) flage=true;
		
		DButil.close(null,null,conn);  
		
		return flage;
}
	public boolean delUser(Goods goods) {
			boolean flage=false;
		Connection conn=DButil.getConnection();
		String sql="delete from goods where id=?";
		 
		int n=DButil.executeUpdate(sql, new Object[] {
				goods.getId()});
		if(n==1) flage=true;
		
		DButil.close(null,null,conn);  
		return flage;
		
	}
	public boolean updateUser(Goods goods) {
		boolean flage=false;
		Connection conn=DButil.getConnection();
		String sql="update goods set Dname=?,number=?,price=? where id=?";
		int n=DButil.executeUpdate(sql,new Object[] {
				goods.getDname(),goods.getNumber(),goods.getPrice(),goods.getId()
		});
		if(n==1)flage=true;
		DButil.close(null, null, conn);
		return flage;
	}

}