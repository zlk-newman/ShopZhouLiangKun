package com.ZhouLiangKun.shop;
/*���˵�����
 * 
 */


import java.util.Scanner;

import com.ZhouLiangKun.shop.register.AdminLogin;
import com.ZhouLiangKun.shop.register.Join;

public class Shop {
	Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args)  {
		
		Shop shop=new Shop();
		/*boolean go_on=true;*/
		while(true) {
		shop.showMainMenu();
		}
	}
	
	public void showMainMenu(/*boolean go_on*/)  {
	
		System.out.println("*****��ӭ��������̳�*****");
		System.out.println("\t1.ע��");
		System.out.println("\t2.��¼");
		System.out.println("\t3.�鿴�̳�");
		System.out.println("\t4.�鿴�ҵĹ��ﳵ");
		System.out.println("\t5.�鿴�ҹ������Ʒ");
		System.out.println("\t6.����Ա��¼");
		System.out.println("\t0.�˳�ϵͳ");
		System.out.println("***********************");
		System.out.println("��ѡ��˵���");
		
		String choice=sc.next();
		
		boolean r = choice.matches("[0-6]+");//������ʽ
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
			Shop2 s2=new Shop2();
			s2.showMainMenu2();
			System.out.println("****************************************");
			
			break;
		
		case 3:
			System.out.println("��ѡ��Ĳ˵��ǣ��鿴�̳�");
			
			System.out.println("****************************************");
			break;
		case 4:
			System.out.println("��ѡ��Ĳ˵��ǣ��鿴�ҵĹ��ﳵ");
			
			System.out.println("****************************************");
			break;
		case 5:
			System.out.println("��ѡ��Ĳ˵��ǣ��鿴�ҹ������Ʒ");
			System.out.println("****************************************");
			break;
		case 6:
			System.out.println("��ѡ��Ĳ˵��ǣ�����Ա��¼");
			AdminLogin.adminLogin();
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
