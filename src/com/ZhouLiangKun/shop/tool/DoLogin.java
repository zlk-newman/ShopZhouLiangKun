package com.ZhouLiangKun.shop.tool;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ZhouLiangKun.shop.pojo.Shopper;



public class DoLogin {
    
    /**
     * 根据用户名和密码查询用户对象信息
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
            conn = DButil.getConnection();//得到连接对象Connection
            String sql ="SELECT * FROM shopper WHERE Uname=? ";
            stmt = conn.prepareStatement(sql);//得到执行sql语句的对象Statement
            //给？赋值
            stmt.setString(1, name);
           
            
            rs = stmt.executeQuery();//执行sql语句
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





