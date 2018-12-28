package com.ZhouLiangKun.shop.pojo;

public class Shopper {

	private String Uname;
	private String Upassword;
	
	
	
	@Override
	public String toString() {
		return "Shopper [Uname=" + Uname + ", Upassword=" + Upassword + "]";
	}
    public Shopper() {} 
	
	public Shopper(String Uname,String Upassword) {
		this.Uname=Uname;
		this.Upassword=Upassword;
	}
	
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpassword() {
		return Upassword;
	}
	public void setUpassword(String upassword) {
		Upassword = upassword;
	}
	
}
