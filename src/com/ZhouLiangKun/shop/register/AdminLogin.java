package com.ZhouLiangKun.shop.register;

/*
管理员登陆
*/
import java.util.Scanner;

import com.ZhouLiangKun.shop.Shop;


public class AdminLogin {
	
		public static void adminLogin() {
			
			Scanner sc=new Scanner(System.in);
			String admin_name="";
			String admin_p="";
			
			System.out.println("请输入管理员的用户名");	
			
			while (true ) {
				admin_name=sc.next();
				System.out.println("请输入管理员的密码");
				admin_p=sc.next();
				
				//判断输入的用户名，密码是否正确
				if(admin_name.equals("admin")&&admin_p.equals("12345")) {
					System.out.println("管理员登陆成功");
					//菜单循环显示flag
					boolean go_on=true;
					while(go_on) {
						//显示管理员菜单
						int choice=showAdminMenu();
						go_on=chooseAdminMenu(choice,go_on);
					}
					break;
				}else {
					System.out.println("登陆失败，请重新输入！");
					
					System.out.println("请重新输入管理员用户名");
				}
			}
		
		}
		
		public static int showAdminMenu() {
			System.out.println("*****管理员菜单*****");
			System.out.println("\t1.添加商品");
			System.out.println("\t2.修改商品");
			System.out.println("\t3.删除商品");
			System.out.println("\t4.查看商品列表");
			System.out.println("\t5.返回上一层");
			System.out.println("**********************");
			System.out.println("请选择菜单：");
			
			//选择的管理员菜单
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			return choice;
		}
		public static boolean chooseAdminMenu(int choice,boolean go_on) {
			
			switch(choice) {
			
			case 1:
				System.out.println("您选择的菜单是：添加商品。");
				GoodsDemo.addGood();
				break;
			case 2:
				System.out.println("您选择的菜单是：修改商品。");
				GoodsDemo.updateGoods();
				
				break;
			case 3:
				System.out.println("您选择的菜单是：删除商品。");
				GoodsDemo1.deleteGoods();
				break;
			case 4:
				System.out.println("您选择的菜单是：查看商品列表。");
				GoodsDemo.seeGoods();
				
				break;
			
			case 5:
				System.out.println("感谢您的使用，再见！");
				Shop s1=new Shop();
				s1.showMainMenu();
				
				
			default:
				System.out.println("您输入有误");
				
				break;
			}
			return go_on;
			
			
		}
		
		
	

}
