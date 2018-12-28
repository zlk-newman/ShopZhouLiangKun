package com.ZhouLiangKun.shop;
/*主菜单设置
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
	
		System.out.println("*****欢迎进入电子商城*****");
		System.out.println("\t1.注册");
		System.out.println("\t2.登录");
		System.out.println("\t3.查看商城");
		System.out.println("\t4.查看我的购物车");
		System.out.println("\t5.查看我购买的商品");
		System.out.println("\t6.管理员登录");
		System.out.println("\t0.退出系统");
		System.out.println("***********************");
		System.out.println("请选择菜单：");
		
		String choice=sc.next();
		
		boolean r = choice.matches("[0-6]+");//正则表达式
		if(r) {

			int n=Integer.parseInt(choice);
		
		switch(n) {
		case 1:
			System.out.println("您选择的菜单是：注册");
			Join.Join();
			System.out.println("****************************************");
			break;
		case 2:
			System.out.println("您选择的菜单是：登录");
			Join.login();
			Shop2 s2=new Shop2();
			s2.showMainMenu2();
			System.out.println("****************************************");
			
			break;
		
		case 3:
			System.out.println("您选择的菜单是：查看商城");
			
			System.out.println("****************************************");
			break;
		case 4:
			System.out.println("您选择的菜单是：查看我的购物车");
			
			System.out.println("****************************************");
			break;
		case 5:
			System.out.println("您选择的菜单是：查看我购买的商品");
			System.out.println("****************************************");
			break;
		case 6:
			System.out.println("您选择的菜单是：管理员登录");
			AdminLogin.adminLogin();
			System.out.println("****************************************");
			break;
		case 0:
			System.out.println("谢谢使用！");
			/*go_on=false;*/
			System.exit(0);//循环终止
			break;
			
		default:
			System.out.println("您的输入有误！");
				break;
		
		}
		
		}
		
		

	}
}
