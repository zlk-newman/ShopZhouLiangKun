package com.ZhouLiangKun.shop.pojo;

public class Goods {
	private int id;
	private String Dname;
	private String number;
	private double price;
	
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", Dname=" + Dname + ",  number=" + number + ", price=" + price
				+ "]";
	}
	public Goods() {} 
	
	public Goods(int id,String Dname,String number,double price) {
		this.id=id;
		this.Dname=Dname;
		this.number=number;
		this.price=price;
		
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
