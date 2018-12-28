package com.ZhouLiangKun.shop.register;




import java.util.Scanner;


import com.ZhouLiangKun.shop.pojo.Shopper;
import com.ZhouLiangKun.shop.tool.DoLogin;
import com.ZhouLiangKun.shop.tool.ShopperDao;

public class Join {
	/*
	 * ע���û���Ϣ user s1 s2
	 */
	public static void Join() {

		Shopper user = new Shopper();

		while (true) {

			System.out.println("������Ҫע����û�����");
			@SuppressWarnings("resource")
			Scanner s1 = new Scanner(System.in);
			user.setUname(s1.nextLine());
			String username = user.getUname();

			boolean fiag = true;

			if (username.length() < 3) {
				System.out.println("�û�������С����λ�����������룺");
				continue;

			} else {

				System.out.println("������Ҫע������룺");
				@SuppressWarnings("resource")
				Scanner s2 = new Scanner(System.in);
				user.setUpassword(s2.nextLine());
				String password = user.getUpassword();

				if (password.length() < 6) {
					System.out.println("���벻��С����λ�����������룺");
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
						System.out.println("���벻��ȫΪ��ĸ��ȫΪ���֣����������룺");
						digit = 0;
						letter = 0;
						continue;
					} else {
						System.out.println("���ٴ��������룺");
						String repassword = s2.nextLine();

						if (password.equals(repassword)) {

							ShopperDao us = new ShopperDao();
							if (us.addUser(user)) {

								System.out.println("�����û��ɹ�");
								break;
							} else {
								// System.out.println("�����û�ʧ��");
							}

						} else {
							System.out.println("�����������벻һ�£����������룺");
							continue;
						}

					}

				}
			}

		}
	}

	/*
	 * ��½���� username password flag
	 */

	public static void login() {
		String username = "";
		String password = "";
		boolean flag = false;

		System.out.println("�������û�����");
		while (true) {
			Scanner s1 = new Scanner(System.in);
			username = s1.nextLine();
			System.out.println("���������룺");
			Scanner s2 = new Scanner(System.in);
			password = s2.nextLine();

			DoLogin d=new DoLogin();
			Shopper user = d.findUser(username,password);// ���ò�ѯ�û��ķ���
			/*
			 * ShopperDao sd=new ShopperDao(); Shopper
			 * user=sd.selectUserByUsername(username);
			 */

			if (user != null) {
				System.out.println("��ӭ�㣺" + user.getUname());
				flag = true;

				break;
			} else {
				System.out.println("�û������������");
				System.out.println("*****************************");
				System.out.println("�����������û�����");

			}

		}

	}

}
