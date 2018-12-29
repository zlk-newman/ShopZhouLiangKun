package com.ZhouLiangKun.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ZhouLiangKun.shop.pojo.Goods;
import com.ZhouLiangKun.shop.tool.DButil;


public class GoodsSelect {
    
    /**
     * 根据货物编号查询用户对象信息
     * @param id
     * 
     */
   
	public Goods findUser(int  id){//加static可以提前形成数据，防止丢失数据
		/*String dname=null;String number=null;Double price=0.0;*/
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Goods g = null;
        try {
            conn = DButil.getConnection();//得到连接对象Connection
            String sql ="SELECT * FROM goods WHERE id=? ";
            /*AND Dname=? AND number=? AND price=?*/
            stmt = conn.prepareStatement(sql);//得到执行sql语句的对象Statement
            //给？赋值
            stmt.setInt(1, id);
            /*stmt.setString(2, dname);
            stmt.setString(3, number);
            stmt.setDouble(4, price);*/
            
            rs = stmt.executeQuery();//执行sql语句
            if(rs.next()){
                g = new Goods();
               
                g.setId(rs.getInt(1));
                g.setDname(rs.getString(2));
                g.setNumber(rs.getInt(3));
                g.setPrice(rs.getDouble(4));
                
                g.toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        	
			
        }finally{
            DButil.close(rs, stmt, conn);
        }
        
        return g;
    }
}


