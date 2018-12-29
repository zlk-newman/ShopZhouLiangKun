package com.ZhouLiangKun.shop.pojo;

public class History {
	private int did;
	private int Gid;
	private String Gname;
	private int Gnumber;
	private Double Gprice;
	
	
	
	public History() {
		
	}
	
	@Override
	public String toString() {
		return "History [did=" + did + ", Gid=" + Gid + ", Gname=" + Gname + ", Gnumber=" + Gnumber + ", Gprice="
				+ Gprice + "]";
	}
	

	public History(int did, int gid, String gname, int gnumber, Double gprice) {
		super();
		this.did = did;
		Gid = gid;
		Gname = gname;
		Gnumber = gnumber;
		Gprice = gprice;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
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
	public int getGnumber() {
		return Gnumber;
	}
	public void setGnumber(int gnumber) {
		Gnumber = gnumber;
	}
	public Double getGprice() {
		return Gprice;
	}
	public void setGprice(Double gprice) {
		Gprice = gprice;
	}
	
	

}
