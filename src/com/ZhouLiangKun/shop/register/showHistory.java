package com.ZhouLiangKun.shop.register;

import java.util.ArrayList;
import java.util.List;

import com.ZhouLiangKun.shop.Shop2;
import com.ZhouLiangKun.shop.dao.HistoryDao;
import com.ZhouLiangKun.shop.pojo.History;

public class showHistory {
	public static void showHis() {
		
		System.out.println("您购买过的商品如下：");
		History his=new History();
        
        List<History> list=new ArrayList<>();
		HistoryDao h=new HistoryDao();
		list=h.selectAllUser();
		
		
		for(History history:list) {
	
			System.out.println(history);
			
			break;
		}
		Shop2 s2=new Shop2();
		s2.showMainMenu2();
	}
		
	}

