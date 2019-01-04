package com.ZhouLiangKun.shop.register;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.ZhouLiangKun.shop.pojo.Goods;

public class BuyDemo {
	public static List<Goods> list=new ArrayList<Goods>();
	public static Goods mygood=new Goods();
	public static Goods  goods=new Goods();
	public static void buy() {
		System.out.println("请输入您要购买的商品编号：");
		
		while(true) {
			Scanner sc1=new Scanner(System.in);
			int id=sc1.nextInt();
			
			goods=GoodsDemo.SelectGoods(id);
			if(goods==null) {
				System.out.println("未找到该商品！");
				System.out.println("请重新数入您要购买的商品编号：");
			}else {
				System.out.println("您将要购买的商品信息如下：");
				System.out.println(goods);
				break;
				
			}
			
		}
		System.out.println("请输入您要购买的商品数量：");
		while(true) {
			Scanner sc2=new Scanner(System.in);
			int num=sc2.nextInt();
			
			
			if(num>goods.getNumber()) {
				System.out.println("库存不足！");
				System.out.println("请重新输入您要购买的商品数量：");
			}else {
				
				
				try {
					mygood=goods.clone();
					mygood.setNumber(num);
					Double total=new Double("0.0");	
					Double price=new Double(goods.getPrice());
					mygood.setPrice(total+(num*price));
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				list.add(mygood);
				
				
				
					System.out.println("下面是您的购物车信息：");
					System.out.println("商品编号\t商品名\t购买数量\t商品总价");
					for(Goods go:list) {
					
					System.out.println(go.getId()+"\t"+go.getDname()+"\t"+go.getNumber()+"\t"+go.getPrice());
					
					}
				
			
				
			}
			break;	
		}
	}

}
