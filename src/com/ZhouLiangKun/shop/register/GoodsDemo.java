package com.ZhouLiangKun.shop.register;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ZhouLiangKun.shop.pojo.Goods;
import com.ZhouLiangKun.shop.tool.GoodsDao;
import com.ZhouLiangKun.shop.tool.GoodsSelect;


public class GoodsDemo {

	public static void addGood() {
		Goods goods=new Goods();
		System.out.println("******开始添加商品******");
		System.out.println("请输入商品编号：");
		Scanner s1=new Scanner(System.in);
		goods.setId(s1.nextInt());
		
		System.out.println("请输入商品名称：");
		Scanner s2=new Scanner(System.in);
		goods.setDname(s2.next());
		
		System.out.println("请输入商品数量：");
		Scanner s4=new Scanner(System.in);
		goods.setNumber(s4.next());
		
		System.out.println("请输入商品价格：");
		Scanner s3=new Scanner(System.in);
		goods.setPrice(s3.nextDouble());
		
		GoodsDao us = new GoodsDao();
		if (us.addUser(goods)) {

			System.out.println("添加商品成功！");
			
		}
		
	}
	public static Goods SelectGoods(int id) {
			Goods returnGoods=null;
			Goods goods=new Goods();
			
			GoodsSelect n=new GoodsSelect();
			Goods g1=n.findUser(id);
			List<Goods> list=new ArrayList<>();
			list.add(g1);
			System.out.println("被改动的商品信息如下："+list);
			for(Goods g:list) {
			
			/*	if(goods.equals(g)) {//有错误！
					returnGoods=g;
					break;
		}*/
				returnGoods=g;
				break;
			}
			return returnGoods;
			}
	
		public static void updateGoods() {
			System.out.println("******开始修改商品******");
			System.out.println("请输入商品编号：");
			
			while(true) {
				
				Scanner sc=new Scanner(System.in); 
				int id=sc.nextInt();
				
				
				Goods goods=SelectGoods(id);
				
				if(goods==null) {

					System.out.println("未找到该商品！");
					System.out.println("请重新输入要修改的商品编号：");
				}else {
					System.out.println("该商品信息如下：");
					System.out.println("商品编号\t商品名称\t商品价格\t商品数量");
					System.out.println(goods.getId()+"\t"+goods.getDname()+"\t"+goods.getNumber()+"\t"+goods.getPrice());
					
					Scanner in=new Scanner(System.in);
					System.out.println("请输入修改后的商品名称：");
					String name=in.nextLine();

					System.out.println("请输入修改后的商品数量：");
					String number=in.nextLine();
					
					System.out.println("请输入修改后的商品价格：");
					Double price=in.nextDouble();
					
					goods.setDname(name);
					goods.setNumber(number);
					goods.setPrice(price);
					
					GoodsDao usl = new GoodsDao();
					if(usl.updateUser(goods)) {
						System.out.println("修改商品成功！\t");
						System.out.println("修改后的商品信息如下：");
						System.out.println("商品编号\t商品名称\t商品价格\t商品数量");
						System.out.println(goods.getId()+"\t"+goods.getDname()+"\t"+goods.getNumber()+"\t"+goods.getPrice());
						break;
					}
				}
				}
			}
		
		public static void deleteGoods() {
			System.out.println("*****开始删除商品******");
			System.out.println("请输入要删除的商品编号：");
			while(true) {
				Scanner sc=new Scanner(System.in);
				int id=sc.nextInt();
				
				Goods goods=SelectGoods(id);
				if(goods==null) {

					System.out.println("未找到该商品！");
					System.out.println("请重新输入要修改的商品编号：");
				}else {
					GoodsDao usn = new GoodsDao();
					if(usn.delUser(goods)) {
						System.out.println("删除商品成功！");
					}
				}
			}
		}
		public static void seeGoods() {
			System.out.println("欢迎来到电子商城：");
			
		}
	
}

