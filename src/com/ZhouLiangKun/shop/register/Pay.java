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
			
			System.out.println("�Ƿ��������Y/N");
			Scanner sc1=new Scanner(System.in);
			is_continue=sc1.nextLine();
		}

		System.out.println("�����������ι��ﳵ�е�ȫ����Ʒ��Ϣ��Ϣ��");
		System.out.println("��Ʒ���\t��Ʒ��\t��������\t��Ʒ�ܼ�");
		for(Goods go:BuyDemo.list) {
		
		System.out.println(go.getId()+"\t"+go.getDname()+"\t"+go.getNumber()+"\t"+go.getPrice());
		
		}
		
		Double total=new Double("0.0");
		
		for(Goods goods1:BuyDemo.list) {
			
			Double price=new Double(goods1.getPrice());
			
			total=total+price;
			
		}
		
		
		
		System.out.println("�ܼ۸�Ϊ��"+total); 
		
		/*System.out.println("�������̳ǵĹ������Ϊ��������ﳵ�е���Ʒδ֧����ϵͳ��������Ĺ��ﳵ��\t");*/
		System.out.println("��ѡ���Ƿ����֧����Y/N");
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
			System.out.println("******��Ʒ����ɹ���******");
			Shop2 s3=new Shop2();
			s3.showMainMenu2();
			
		}else {
			System.out.println("���Ĺ��ﳵ��Ʒ�����������������Ĺ��ﳵ��");
			System.out.println(BuyDemo.list);
			System.out.println("ע�⣺���Ĺ��ﳵ�е���Ʒ���˳�ϵͳʱ����գ��������������Ĺ��ﳵ������");
			System.out.println("֧��ʧ�ܣ�ϵͳ����������½��Ľ��� "+"\t"+" Loading......");
			Shop2 s4=new Shop2();
			s4.showMainMenu2();
			
		}
		
		
		
	}

}
