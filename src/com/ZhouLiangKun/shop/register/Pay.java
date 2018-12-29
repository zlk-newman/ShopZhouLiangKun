package com.ZhouLiangKun.shop.register;

import java.util.Scanner;

import com.ZhouLiangKun.shop.Shop2;
import com.ZhouLiangKun.shop.dao.GoodsDao;
import com.ZhouLiangKun.shop.dao.HistoryDao;
import com.ZhouLiangKun.shop.pojo.Goods;
import com.ZhouLiangKun.shop.pojo.History;

public class Pay {
	public static void pay() {
		String is_continue="Y";
		while("Y".equals(is_continue)||"y".equals(is_continue)) {
			
			BuyDemo.buy();
			
			
			
			System.out.println("是否继续购买：Y/N");
			Scanner sc1=new Scanner(System.in);
			is_continue=sc1.nextLine();
		}

		System.out.println("下面是您本次购物车中的全部商品信息信息：");
		System.out.println(BuyDemo.list);
		Double total=new Double("0.0");
		
		for(Goods goods1:BuyDemo.list) {
			
			Double price=new Double(goods1.getPrice());
			int num=goods1.getNumber();
			
			total=total+(num*price);
			
		}
		
		
		
		System.out.println("总价格为："+total); 
		
		System.out.println("本电子商城的购物规则为：如果购物车中的商品未支付，系统将清空您的购物车！\t");
		System.out.println("请选择是否进行支付：Y/N");
		Scanner sc2=new Scanner(System.in);
		is_continue=sc2.nextLine();
		if("Y".equals(is_continue)||"y".equals(is_continue)) {
			for(Goods goods2:BuyDemo.list) {
				HistoryDao h=new HistoryDao();
				History his=new History();
				his.setGid(goods2.getId());
				his.setGname(goods2.getDname());
				his.setGnumber(goods2.getNumber());
				his.setGprice(goods2.getPrice()*goods2.getNumber());
				
				if(h.addUser(his)) {
					
					Goods go=GoodsDemo.SelectGoods(goods2.getId());
					
					go.setNumber(go.getNumber()-goods2.getNumber());
					GoodsDao usl = new GoodsDao();
					if(usl.updateUser(go)) {
						System.out.println("******商品购买成功！******");
						Shop2 s3=new Shop2();
						s3.showMainMenu2();
						break;
					}
				}
				
			}
			
			
		}else {
			System.out.println("支付失败！系统将返回您登陆后的界面 "+"\t"+" Loading......");
			BuyDemo.list=null;
			Shop2 s4=new Shop2();
			s4.showMainMenu2();
			
		}
		
		
		
	}

}
