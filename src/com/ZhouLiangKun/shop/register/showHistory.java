package com.ZhouLiangKun.shop.register;

import java.util.ArrayList;
import java.util.List;

import com.ZhouLiangKun.shop.Shop2;
import com.ZhouLiangKun.shop.dao.HistoryDao;
import com.ZhouLiangKun.shop.pojo.History;

public class showHistory {
	public static void showHis() {
		
		System.out.println("�����������Ʒ���£�");
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
			System.out.println("����δ������Ʒ��");
		}else {
			System.out.println("������\t�û���\t��Ʒ���\t��Ʒ��\t��������\t�Ѹ���\n");
			for(History his:list1) {
			
			System.out.println(his.getDid()+"\t"+his.getUname()+"\t"+his.getGid()+"\t"+his.getGname()+"\t"+his.getGnumber()+"\t"+his.getGprice()+"\n");
			
			}
		}
		Shop2 s2=new Shop2();
		s2.showMainMenu2();
	}
		
	}

