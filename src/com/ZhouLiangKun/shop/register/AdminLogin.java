package com.ZhouLiangKun.shop.register;

/*
����Ա��½
*/
import java.util.Scanner;

import com.ZhouLiangKun.shop.Shop;


public class AdminLogin {
	
		public static void adminLogin() {
			
			Scanner sc=new Scanner(System.in);
			String admin_name="";
			String admin_p="";
			
			System.out.println("���������Ա���û���");	
			
			while (true ) {
				admin_name=sc.next();
				System.out.println("���������Ա������");
				admin_p=sc.next();
				
				//�ж�������û����������Ƿ���ȷ
				if(admin_name.equals("admin")&&admin_p.equals("12345")) {
					System.out.println("����Ա��½�ɹ�");
					//�˵�ѭ����ʾflag
					boolean go_on=true;
					while(go_on) {
						//��ʾ����Ա�˵�
						int choice=showAdminMenu();
						go_on=chooseAdminMenu(choice,go_on);
					}
					break;
				}else {
					System.out.println("��½ʧ�ܣ����������룡");
					
					System.out.println("�������������Ա�û���");
				}
			}
		
		}
		
		public static int showAdminMenu() {
			System.out.println("*****����Ա�˵�*****");
			System.out.println("\t1.�����Ʒ");
			System.out.println("\t2.�޸���Ʒ");
			System.out.println("\t3.ɾ����Ʒ");
			System.out.println("\t4.�鿴��Ʒ�б�");
			System.out.println("\t5.������һ��");
			System.out.println("**********************");
			System.out.println("��ѡ��˵���");
			
			//ѡ��Ĺ���Ա�˵�
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			return choice;
		}
		public static boolean chooseAdminMenu(int choice,boolean go_on) {
			
			switch(choice) {
			
			case 1:
				System.out.println("��ѡ��Ĳ˵��ǣ������Ʒ��");
				GoodsDemo.addGood();
				break;
			case 2:
				System.out.println("��ѡ��Ĳ˵��ǣ��޸���Ʒ��");
				GoodsDemo.updateGoods();
				
				break;
			case 3:
				System.out.println("��ѡ��Ĳ˵��ǣ�ɾ����Ʒ��");
				GoodsDemo1.deleteGoods();
				break;
			case 4:
				System.out.println("��ѡ��Ĳ˵��ǣ��鿴��Ʒ�б�");
				GoodsDemo.seeGoods();
				
				break;
			
			case 5:
				System.out.println("��л����ʹ�ã��ټ���");
				Shop s1=new Shop();
				s1.showMainMenu();
				
				
			default:
				System.out.println("����������");
				
				break;
			}
			return go_on;
			
			
		}
		
		
	

}
