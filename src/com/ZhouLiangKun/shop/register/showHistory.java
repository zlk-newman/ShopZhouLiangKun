package com.ZhouLiangKun.shop.register;

import java.util.ArrayList;
import java.util.List;

import com.ZhouLiangKun.shop.Shop2;
import com.ZhouLiangKun.shop.dao.HistoryDao;
import com.ZhouLiangKun.shop.pojo.History;

public class showHistory {
	public static void showHis() {
		
		System.out.println("您购买过的商品如下：");
        List<History> list=new ArrayList<>();
        List<History> list1=new ArrayList<>();
		HistoryDao h=new HistoryDao();
		list=h.selectAllUser();
		
		
		for(History history:list) {
			
			if(history.getUname().equals(Join.Duser.getUname())) {
				list1.add(history);
				
			}else {
				continue;
			}
			
		}
		
		if(list1.isEmpty()) {
			System.out.println("您还未购买商品！");
		}else {
			System.out.println("订单号\t用户名\t商品编号\t商品名\t购买数量\t已付款\n");
			for(History his:list1) {
			
			System.out.println(his.getDid()+"\t"+his.getUname()+"\t"+his.getGid()+"\t"+his.getGname()+"\t"+his.getGnumber()+"\t"+his.getGprice()+"\n");
			
			}
		}
		Shop2 s2=new Shop2();
		s2.showMainMenu2();
	}
		
	}

