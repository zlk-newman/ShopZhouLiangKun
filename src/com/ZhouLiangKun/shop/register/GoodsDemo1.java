package com.ZhouLiangKun.shop.register;

import java.util.Scanner;

import com.ZhouLiangKun.shop.dao.GoodsDao;
import com.ZhouLiangKun.shop.pojo.Goods;

public class GoodsDemo1 {

	public static void deleteGoods() {
		System.out.println("*****��ʼɾ����Ʒ******");
		System.out.println("������Ҫɾ������Ʒ��ţ�");
		while(true) {
			Scanner sc=new Scanner(System.in);
			int id=sc.nextInt();
			
			Goods goods=GoodsDemo.SelectGoods(id);
			if(goods==null) {

				System.out.println("δ�ҵ�����Ʒ��");
				System.out.println("����������Ҫɾ������Ʒ��ţ�");
				
			}else {
				GoodsDao usn = new GoodsDao();
				if(usn.delUser(goods)) {
					System.out.println("ɾ����Ʒ�ɹ���");
					break;
				}
			}
		}
	}
}
