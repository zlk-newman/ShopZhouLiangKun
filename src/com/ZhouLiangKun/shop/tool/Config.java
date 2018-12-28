package com.ZhouLiangKun.shop.tool;
import java.io.*;
import java.util.*;

public class Config {
	private static Properties p=null;
	static{
		p=new Properties();
		try {
			p.load(new FileInputStream("config/dbconfig.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getValue(String key) {
		return p.getProperty(key);
	}
	public static void main(String[] args) {
		String url=Config.getValue("url");
		String driver=Config.getValue("driver");
		String username=Config.getValue("username");
		String password=Config.getValue("password");
		System.out.println("url="+url);
		System.out.println("driver="+driver);
		System.out.println("username="+username);
		System.out.println("password="+password);
		
	}

}
