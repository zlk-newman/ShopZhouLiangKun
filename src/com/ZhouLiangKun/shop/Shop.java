package com.ZhouLiangKun.shop;
/*���˵�����
 * 
 */


import java.util.Scanner;


import com.ZhouLiangKun.shop.register.AdminLogin;

import com.ZhouLiangKun.shop.register.GoodsDemo;
import com.ZhouLiangKun.shop.register.Join;


public class Shop {
	Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args)  {
		
		Shop shop=new Shop();
		/*boolean go_on=true;*/
		while(true) {
		shop.showMainMenu();
		break;
		}
	}
	
	public void showMainMenu(/*boolean go_on*/)  {
	
		System.out.println("*****��ӭ��������̳�*****");
		System.out.println("\t1.ע��");
		System.out.println("\t2.��¼");
		System.out.println("\t3.����Ա��¼");
		System.out.println("\t4.�鿴�̳�");
		System.out.println("\t0.�˳�ϵͳ");
		System.out.println("***********************");
		System.out.println("��ѡ��˵���");
		
		String choice=sc.next();
		
		boolean r = choice.matches("[0-4]+");//������ʽ
		if(r) {

			int n=Integer.parseInt(choice);
		
		switch(n) {
		case 1:
			System.out.println("��ѡ��Ĳ˵��ǣ�ע��");
			Join.Join();
			System.out.println("****************************************");
			break;
		case 2:
			System.out.println("��ѡ��Ĳ˵��ǣ���¼");
			Join.login();
			if(Join.login) {
			Shop2 s2=new Shop2();
			s2.showMainMenu2();
			}
			System.out.println("****************************************");
			break;
		case 3:
			System.out.println("��ѡ��Ĳ˵��ǣ�����Ա��¼");
			AdminLogin.adminLogin();
			System.out.println("****************************************");
			break;
		case 4:
			System.out.println("��ѡ��Ĳ˵���:�鿴�̳�");
			GoodsDemo.seeGoods();
			System.out.println("�㻹δ��¼�����ȵ�¼���ڹ�����Ʒ��");
			System.out.println("****************************************");
			Shop s1=new Shop();
			s1.showMainMenu();
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
