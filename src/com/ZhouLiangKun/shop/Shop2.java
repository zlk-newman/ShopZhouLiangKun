package com.ZhouLiangKun.shop;

/*登陆后菜单设置
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
		System.out.println("*****欢迎进入电子商城*****");
		System.out.println("\t1.返回上一层");
		System.out.println("\t2.查看商城");
		System.out.println("\t3.查看我的购物车");
		System.out.println("\t4.查看我购买的商品");
		System.out.println("\t5.修改我的密码");
		System.out.println("\t0.退出系统");
		System.out.println("***********************");
		System.out.println("请选择菜单：");
	
		String choice=sc.next();
		boolean r = choice.matches("[0-5]+");//正则表达式
		if(r) {

			int n=Integer.parseInt(choice);
		
		switch(n) {
		case 1:
			System.out.println("您选择的菜单是：返回上一层");
			Shop s1=new Shop();
			s1.showMainMenu();
			System.out.println("****************************************");
			break;
		case 2:
			System.out.println("您选择的菜单是：查看商城");
			GoodsDemo.seeGoods();
			System.out.println("****************************************");
			break;
		case 3:
			System.out.println("您选择的菜单是：查看我的购物车");
			
			System.out.println("****************************************");
			break;
		case 4:
			System.out.println("您选择的菜单是：查看我购买的商品");
			
			System.out.println("****************************************");
			break;
		case 5:
			System.out.println("您选择的菜单是：修改我的密码");
			Join.updateShopper();
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