package com.ZhouLiangKun.shop.register;

import java.util.Scanner;

import com.ZhouLiangKun.shop.dao.GoodsDao;
import com.ZhouLiangKun.shop.pojo.Goods;

public class GoodsDemo1 {

	public static void deleteGoods() {
		System.out.println("*****开始删除商品******");
		System.out.println("请输入要删除的商品编号：");
		while(true) {
			Scanner sc=new Scanner(System.in);
			int id=sc.nextInt();
			
			Goods goods=GoodsDemo.SelectGoods(id);
			if(goods==null) {

				System.out.println("未找到该商品！");
				System.out.println("请重新输入要删除的商品编号：");
				
			}else {
				GoodsDao usn = new GoodsDao();
				if(usn.delUser(goods)) {
					System.out.println("删除商品成功！");
					break;
				}
			}
		}
	}
}
