package com.ZhouLiangKun.shop.register;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ZhouLiangKun.shop.dao.GoodsDao;
import com.ZhouLiangKun.shop.dao.GoodsSelect;
import com.ZhouLiangKun.shop.pojo.Goods;


public class GoodsDemo {

	public static void addGood() {
		Goods goods=new Goods();
		System.out.println("******��ʼ�����Ʒ******");
		System.out.println("��������Ʒ��ţ�");
		Scanner s1=new Scanner(System.in);
		goods.setId(s1.nextInt());
		
		System.out.println("��������Ʒ���ƣ�");
		Scanner s2=new Scanner(System.in);
		goods.setDname(s2.next());
		
		System.out.println("��������Ʒ������");
		Scanner s4=new Scanner(System.in);
		goods.setNumber(s4.next());
		
		System.out.println("��������Ʒ�۸�");
		Scanner s3=new Scanner(System.in);
		goods.setPrice(s3.nextDouble());
		
		GoodsDao us = new GoodsDao();
		if (us.addUser(goods)) {

			System.out.println("�����Ʒ�ɹ���");
			
		}
		
	}
	public static Goods SelectGoods(int id) {
			
			
			GoodsSelect n=new GoodsSelect();
			Goods g1=n.findUser(id);
		
			return g1 ;
			}
	
		public static void updateGoods() {
			System.out.println("******��ʼ�޸���Ʒ******");
			System.out.println("��������Ʒ��ţ�");
			
			while(true) {
				
				Scanner sc=new Scanner(System.in); 
				int id=sc.nextInt();
				
				
				Goods goods=SelectGoods(id);
				
				if(goods==null) {

					System.out.println("δ�ҵ�����Ʒ��");
					System.out.println("����������Ҫ�޸ĵ���Ʒ��ţ�");
				}else {
					System.out.println("����Ʒ��Ϣ���£�");
					System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ�۸�\t��Ʒ����");
					System.out.println(goods.getId()+"\t"+goods.getDname()+"\t"+goods.getNumber()+"\t"+goods.getPrice());
					
					Scanner in=new Scanner(System.in);
					System.out.println("�������޸ĺ����Ʒ���ƣ�");
					String name=in.nextLine();

					System.out.println("�������޸ĺ����Ʒ������");
					String number=in.nextLine();
					
					System.out.println("�������޸ĺ����Ʒ�۸�");
					Double price=in.nextDouble();
					
					goods.setDname(name);
					goods.setNumber(number);
					goods.setPrice(price);
					
					GoodsDao usl = new GoodsDao();
					if(usl.updateUser(goods)) {
						System.out.println("�޸���Ʒ�ɹ���\t");
						System.out.println("�޸ĺ����Ʒ��Ϣ���£�");
						System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ�۸�\t��Ʒ����");
						System.out.println(goods.getId()+"\t"+goods.getDname()+"\t"+goods.getNumber()+"\t"+goods.getPrice());
						break;
					}
				}
				}
			}
		
		
		
		//�鿴�̳�
		public static void seeGoods() {
			System.out.println("��ӭ���������̳ǣ�");
			
            Goods goods=new Goods();
            
            List<Goods> list=new ArrayList<>();
			GoodsDao n=new GoodsDao();
			list=n.selectAllUser();
			
			
			for(Goods g:list) {
		
				System.out.println(g);	
			}
			
		}
		
	
}

