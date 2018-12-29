package com.ZhouLiangKun.shop.tool;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ZhouLiangKun.shop.pojo.Shopper;



public class DoLogin {
    
    /**
     * �����û����������ѯ�û�������Ϣ
     * @param name
     * @param pwd
     * @return u
     */

    public static Shopper findUser(String name){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Shopper u = null;
        try {
            conn = DButil.getConnection();//�õ����Ӷ���Connection
            String sql ="SELECT * FROM shopper WHERE Uname=? ";
            stmt = conn.prepareStatement(sql);//�õ�ִ��sql���Ķ���Statement
            //������ֵ
            stmt.setString(1, name);
           
            
            rs = stmt.executeQuery();//ִ��sql���
            if(rs.next()){
                u = new Shopper();
               
                u.setUname(rs.getString(1));
                u.setUpassword(rs.getString(2));
                
                u.toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DButil.close(rs, stmt, conn);
        }
        
        return u;
    }
}





