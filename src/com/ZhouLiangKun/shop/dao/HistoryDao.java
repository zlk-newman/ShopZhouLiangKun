package com.ZhouLiangKun.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ZhouLiangKun.shop.pojo.History;
import com.ZhouLiangKun.shop.tool.DButil;

public class HistoryDao{
public boolean addUser(History his) {
		
		boolean flage=false;
		
		Connection conn=DButil.getConnection();
		String sql="insert into history (Uname,Gid,Gname,Gnumber,Gprice)value(?,?,?,?,?)";
		 
		int n=DButil.executeUpdate(sql, new Object[] {
				his.getUname(),his.getGid(),his.getGname(),his.getGnumber(),his.getGprice()});
		if(n==1) flage=true;
		
		DButil.close(null,null,conn);  
		
		return flage;
}

public boolean delUser(History his) {
	boolean flage=false;
Connection conn=DButil.getConnection();
String sql="delete from history where Gid=?";
 
int n=DButil.executeUpdate(sql, new Object[] {
		his.getGid()});
if(n==1) flage=true;

DButil.close(null,null,conn);  
return flage;

}

public static History findUser(String  name){//��static������ǰ�γ����ݣ���ֹ��ʧ����
	
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    History h = null;
    try {
        conn = DButil.getConnection();//�õ����Ӷ���Connection
        String sql ="SELECT * FROM history WHERE Uname=? ";
        
        stmt = conn.prepareStatement(sql);//�õ�ִ��sql���Ķ���Statement
        //������ֵ
        stmt.setString(1, name);
        
        
        rs = stmt.executeQuery();//ִ��sql���
        if(rs.next()){
        	 h = new History();
            h.setDid(rs.getInt(1));
            h.setUname(rs.getString(2));
            h.setGid(rs.getInt(3));
            h.setGname(rs.getString(4));
            h.setGnumber(rs.getInt(5));
            h.setGprice(rs.getDouble(6));
            
            h.toString();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    	
		
    }finally{
        DButil.close(rs, stmt, conn);
    }
    
    return h;
}

public List<History> selectAllUser () {

	List<History> list=new ArrayList<>();
	Connection conn=DButil.getConnection();
	String sql="select * from history ";
	
	ResultSet rs=DButil.executeQuery(sql,null);
	
	try {
		while(rs.next()) {
			History his=new History();
			his.setDid(rs.getInt(1));
			his.setUname(rs.getString(2));
			his.setGid(rs.getInt(3));
			his.setGname(rs.getString(4));
			his.setGnumber(rs.getInt(5));
			his.setGprice(rs.getDouble(6));
			list.add(his);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	DButil.close(rs,null,conn);  
		return	  list;		
	
}
}