package com.ZhouLiangKun.shop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ZhouLiangKun.shop.pojo.Goods;
import com.ZhouLiangKun.shop.tool.DButil;

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
	public List<Goods> selectAllUser () {

		List<Goods> list=new ArrayList<>();
		Connection conn=DButil.getConnection();
		String sql="select * from goods ";
		ResultSet rs=DButil.executeQuery(sql,null);
		try {
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setId(rs.getInt(1));
				goods.setDname(rs.getString(2));
				goods.setNumber(rs.getInt(3));
				goods.setPrice(rs.getDouble(4));
				list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DButil.close(rs,null,conn);  
			return	  list;		
		
}
}