package com.ZhouLiangKun.shop.pojo;

public class History {
	private int Gid;
	private String Gname;
	private String Gnumber;
	private Double Gprice;
	
	
	
	public History() {
		
	}
	public History(int gid, String gname, String gnumber, Double gprice) {
		super();
		Gid = gid;
		Gname = gname;
		Gnumber = gnumber;
		Gprice = gprice;
	}
	@Override
	public String toString() {
		return "History [Gid=" + Gid + ", Gname=" + Gname + ", Gnumber=" + Gnumber + ", Gprice=" + Gprice + "]";
	}
	public int getGid() {
		return Gid;
	}
	public void setGid(int gid) {
		Gid = gid;
	}
	public String getGname() {
		return Gname;
	}
	public void setGname(String gname) {
		Gname = gname;
	}
	public String getGnumber() {
		return Gnumber;
	}
	public void setGnumber(String gnumber) {
		Gnumber = gnumber;
	}
	public Double getGprice() {
		return Gprice;
	}
	public void setGprice(Double gprice) {
		Gprice = gprice;
	}
	
	

}
