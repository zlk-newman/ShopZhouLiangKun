package com.ZhouLiangKun.shop.register;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ZhouLiangKun.shop.dao.GoodsDao;
import com.ZhouLiangKun.shop.pojo.Goods;

public class BuyDemo {
	public static List<Goods> list=new ArrayList<Goods>();
	public static Goods  goods=new Goods();
	public static void buy() {
		System.out.println("��������Ҫ�������Ʒ��ţ�");
		
		while(true) {
			Scanner sc1=new Scanner(System.in);
			int id=sc1.nextInt();
			
			goods=GoodsDemo.SelectGoods(id);
			if(goods==null) {
				System.out.println("δ�ҵ�����Ʒ��");
				System.out.println("������������Ҫ�������Ʒ��ţ�");
			}else {
				System.out.println("����Ҫ�������Ʒ��Ϣ���£�");
				System.out.println(goods);
				break;
				
			}
			
		}
		System.out.println("��������Ҫ�������Ʒ������");
		while(true) {
			Scanner sc2=new Scanner(System.in);
			int num=sc2.nextInt();
			
			
			if(num>goods.getNumber()) {
				System.out.println("��治�㣡");
				System.out.println("������������Ҫ�������Ʒ������");
			}else {
				Goods mygood=new Goods();
				
				try {
					mygood=goods.clone();
					mygood.setNumber(num);
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				list.add(mygood);
				
				
				
					System.out.println("���������Ĺ��ﳵ��Ϣ��");
					System.out.println(list);
				
			
				
			}
			break;	
		}
	}

}
