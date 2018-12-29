package com.ZhouLiangKun.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ZhouLiangKun.shop.pojo.Goods;
import com.ZhouLiangKun.shop.tool.DButil;


public class GoodsSelect {
    
    /**
     * ���ݻ����Ų�ѯ�û�������Ϣ
     * @param id
     * 
     */
   
	public Goods findUser(int  id){//��static������ǰ�γ����ݣ���ֹ��ʧ����
		/*String dname=null;String number=null;Double price=0.0;*/
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Goods g = null;
        try {
            conn = DButil.getConnection();//�õ����Ӷ���Connection
            String sql ="SELECT * FROM goods WHERE id=? ";
            /*AND Dname=? AND number=? AND price=?*/
            stmt = conn.prepareStatement(sql);//�õ�ִ��sql���Ķ���Statement
            //������ֵ
            stmt.setInt(1, id);
            /*stmt.setString(2, dname);
            stmt.setString(3, number);
            stmt.setDouble(4, price);*/
            
            rs = stmt.executeQuery();//ִ��sql���
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


