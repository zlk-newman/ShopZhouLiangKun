package com.ZhouLiangKun.shop.pojo;

public class Goods implements Comparable<Goods>,Cloneable{
	private int id;
	private String Dname;
	private int number;
	private double price;
	
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", Dname=" + Dname + ",  number=" + number + ", price=" + price
				+ "]";
	}
	public Goods() {} 
	
	public Goods(int id,String Dname,int number,double price) {
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
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int compareTo(Goods goods) {
		return this.Dname.compareTo(goods.Dname);
		
	}
	@Override
	public Goods clone() throws CloneNotSupportedException {

		Goods goods=(Goods)super.clone();
		return goods;
	}

}
