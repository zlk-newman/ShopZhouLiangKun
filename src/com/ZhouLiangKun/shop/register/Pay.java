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
		System.out.println("商品编号\t商品名\t购买数量\t商品总价");
		for(Goods go:BuyDemo.list) {
		
		System.out.println(go.getId()+"\t"+go.getDname()+"\t"+go.getNumber()+"\t"+go.getPrice());
		
		}
		
		Double total=new Double("0.0");
		
		for(Goods goods1:BuyDemo.list) {
			
			Double price=new Double(goods1.getPrice());
			
			total=total+price;
			
		}
		
		
		
		System.out.println("总价格为："+total); 
		
		/*System.out.println("本电子商城的购物规则为：如果购物车中的商品未支付，系统将清空您的购物车！\t");*/
		System.out.println("请选择是否进行支付：Y/N");
		Scanner sc2=new Scanner(System.in);
		is_continue=sc2.nextLine();
		if("Y".equals(is_continue)||"y".equals(is_continue)) {
			for(Goods goods2:BuyDemo.list) {
				HistoryDao h=new HistoryDao();
				History his=new History();
				his.setUname(Join.Duser.getUname());
				his.setGid(goods2.getId());
				his.setGname(goods2.getDname());
				his.setGnumber(goods2.getNumber());
				his.setGprice(goods2.getPrice());
				
				h.addUser(his);
					
				Goods go=GoodsDemo.SelectGoods(goods2.getId());
					
				go.setNumber(go.getNumber()-goods2.getNumber());
				GoodsDao usl = new GoodsDao();
				usl.updateUser(go);
			}
			System.out.println("******商品购买成功！******");
			Shop2 s3=new Shop2();
			s3.showMainMenu2();
			
		}else {
			System.out.println("您的购物车物品将保留，下面是您的购物车：");
			System.out.println(BuyDemo.list);
			System.out.println("注意：您的购物车中的物品在退出系统时会清空，请理性运用您的购物车！！！");
			System.out.println("支付失败！系统将返回您登陆后的界面 "+"\t"+" Loading......");
			Shop2 s4=new Shop2();
			s4.showMainMenu2();
			
		}
		
		
		
	}

}
