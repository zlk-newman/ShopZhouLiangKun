package com.ZhouLiangKun.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ZhouLiangKun.shop.pojo.Goods;
import com.ZhouLiangKun.shop.pojo.History;
import com.ZhouLiangKun.shop.tool.DButil;

public class HistoryDao{
public boolean addUser(History his) {
		
		boolean flage=false;
		
		Connection conn=DButil.getConnection();
		String sql="insert into history (Gid,Gname,Gnumber,Gprice)value(?,?,?,?)";
		 
		int n=DButil.executeUpdate(sql, new Object[] {
				his.getGid(),his.getGname(),his.getGnumber(),his.getGprice()});
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

public History findUser(int  id){//加static可以提前形成数据，防止丢失数据
	
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    History h = null;
    try {
        conn = DButil.getConnection();//得到连接对象Connection
        String sql ="SELECT * FROM history WHERE Gid=? ";
        
        stmt = conn.prepareStatement(sql);//得到执行sql语句的对象Statement
        //给？赋值
        stmt.setInt(1, id);
        
        
        rs = stmt.executeQuery();//执行sql语句
        if(rs.next()){
        	 h = new History();
            h.setDid(rs.getInt(1));
            h.setGid(rs.getInt(2));
            h.setGname(rs.getString(3));
            h.setGnumber(rs.getInt(4));
            h.setGprice(rs.getDouble(5));
            
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
			his.setGid(rs.getInt(2));
			his.setGname(rs.getString(3));
			his.setGnumber(rs.getInt(4));
			his.setGprice(rs.getDouble(5));
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