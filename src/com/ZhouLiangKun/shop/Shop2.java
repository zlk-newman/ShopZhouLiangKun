package com.ZhouLiangKun.shop;

/*��½��˵�����
 * 
 */
import java.util.Scanner;

import com.ZhouLiangKun.shop.register.GoodsDemo;
import com.ZhouLiangKun.shop.register.Join;


public class Shop2 {
	Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args)  {
		
		Shop shop=new Shop();
		/*boolean go_on=true;*/
		while(true) {
		shop.showMainMenu();
		break;
		}
	}
	
	public void showMainMenu2(/*boolean go_on*/)  {
		System.out.println("*****��ӭ��������̳�*****");
		System.out.println("\t1.������һ��");
		System.out.println("\t2.�鿴�̳�");
		System.out.println("\t3.�鿴�ҵĹ��ﳵ");
		System.out.println("\t4.�鿴�ҹ������Ʒ");
		System.out.println("\t5.�޸��ҵ�����");
		System.out.println("\t0.�˳�ϵͳ");
		System.out.println("***********************");
		System.out.println("��ѡ��˵���");
	
		String choice=sc.next();
		boolean r = choice.matches("[0-5]+");//������ʽ
		if(r) {

			int n=Integer.parseInt(choice);
		
		switch(n) {
		case 1:
			System.out.println("��ѡ��Ĳ˵��ǣ�������һ��");
			Shop s1=new Shop();
			s1.showMainMenu();
			System.out.println("****************************************");
			break;
		case 2:
			System.out.println("��ѡ��Ĳ˵��ǣ��鿴�̳�");
			GoodsDemo.seeGoods();
			System.out.println("****************************************");
			break;
		case 3:
			System.out.println("��ѡ��Ĳ˵��ǣ��鿴�ҵĹ��ﳵ");
			
			System.out.println("****************************************");
			break;
		case 4:
			System.out.println("��ѡ��Ĳ˵��ǣ��鿴�ҹ������Ʒ");
			
			System.out.println("****************************************");
			break;
		case 5:
			System.out.println("��ѡ��Ĳ˵��ǣ��޸��ҵ�����");
			Join.updateShopper();
			System.out.println("****************************************");
			break;
		case 0:
			System.out.println("ллʹ�ã�");
			/*go_on=false;*/
			System.exit(0);//ѭ����ֹ
			break;
			
		default:
			System.out.println("������������");
				break;
		
		}
		
		}
		
	

	}
}