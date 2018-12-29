package com.ZhouLiangKun.shop.register;




import java.util.Scanner;

import com.ZhouLiangKun.shop.Shop;
import com.ZhouLiangKun.shop.dao.GoodsDao;
import com.ZhouLiangKun.shop.dao.ShopperDao;
import com.ZhouLiangKun.shop.pojo.Goods;
import com.ZhouLiangKun.shop.pojo.Shopper;
import com.ZhouLiangKun.shop.tool.DoLogin;
import com.ZhouLiangKun.shop.tool.GoodsSelect;

public class Join {
	/*
	 * 注册用户信息 user s1 s2
	 */
	public static boolean login=false;
	public static void Join() {

		Shopper user = new Shopper();

		while (true) {

			System.out.println("请输入要注册的用户名：");
			@SuppressWarnings("resource")
			Scanner s1 = new Scanner(System.in);
			user.setUname(s1.nextLine());
			String username = user.getUname();

			boolean fiag = true;

			if (username.length() < 3) {
				System.out.println("用户名不得小于三位！请重新输入：");
				continue;

			} else {

				System.out.println("请输入要注册的密码：");
				@SuppressWarnings("resource")
				Scanner s2 = new Scanner(System.in);
				user.setUpassword(s2.nextLine());
				String password = user.getUpassword();

				if (password.length() < 6) {
					System.out.println("密码不得小于六位，请重新输入：");
					continue;
				} else {

					char ch;
					int digit = 0;
					int letter = 0;
					for (int i = 0; i < password.length(); i++) {
						ch = password.charAt(i);

						if (Character.isDigit(ch)) {
							digit = digit + 1;
						}
						if (Character.isLetter(ch)) {
							letter = letter + 1;
						}
					}
					if (digit == 0 || letter == 0) {
						System.out.println("密码不能全为字母或全为数字！请重新输入：");
						digit = 0;
						letter = 0;
						continue;
					} else {
						System.out.println("请再次输入密码：");
						String repassword = s2.nextLine();

						if (password.equals(repassword)) {

							ShopperDao us = new ShopperDao();
							if (us.addUser(user)) {

								System.out.println("添加用户成功");
								break;
							} else {
								// System.out.println("添加用户失败");
							}

						} else {
							System.out.println("两次密码输入不一致！请重新输入：");
							continue;
						}

					}

				}
			}

			break;
		}
	}

	/*
	 * 登陆设置 username password flag
	 */

	public static void login() {
		String username = "";
		String password = "";
		boolean flag = false;

		System.out.println("请输入用户名：");
		while (true) {
			Scanner s1 = new Scanner(System.in);
			username = s1.nextLine();
			System.out.println("请输入密码：");
			Scanner s2 = new Scanner(System.in);
			password = s2.nextLine();

			DoLogin d=new DoLogin();
			Shopper user = d.findUser(username);// 调用查询用户的方法
			/*
			 * ShopperDao sd=new ShopperDao(); Shopper
			 * user=sd.selectUserByUsername(username);
			 */

			if (user != null) {
				System.out.println("欢迎你：" + user.getUname());
				flag = true;
				login=true;

				break;
			} else {
				System.out.println("用户名或密码错误！");
				System.out.println("*****************************");
				System.out.println("请重新输入用户名：");

			}

			break;
		}

	}
	//修改用户密码
	public static Shopper SelectGoods(String name) {
		
		
		DoLogin n=new DoLogin();
		Shopper g1=n.findUser(name);
	
		return g1 ;
		}

	public static void updateShopper() {
		System.out.println("******开始修改密码******");
		System.out.println("请输入用户名：");
		
		while(true) {
			
			Scanner sc=new Scanner(System.in); 
			String name=sc.nextLine();
			
			
			Shopper shopper=SelectGoods(name);
			
			if(shopper==null) {

				System.out.println("未找到该用户！");
				System.out.println("请重新输入用户名：");
			}else {
				
				
				Scanner in=new Scanner(System.in);
				System.out.println("请输入修改后的密码：");
				String password=in.nextLine();

				
				
				shopper.setUpassword(password);;
				
				ShopperDao usl = new ShopperDao();
				if(usl.updateUser(shopper)) {
					System.out.println("修改密码成功\t");
					Shop s1=new Shop();
					s1.showMainMenu();
					break;
				}
			}
			}
		}

}

