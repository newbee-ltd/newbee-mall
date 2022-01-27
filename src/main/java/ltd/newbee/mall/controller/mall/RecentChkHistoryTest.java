/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.InsertSearchHistoryEntity;
import ltd.newbee.mall.entity.RecentChkHistory;
import ltd.newbee.mall.service.NewBeeMallGoodsService;



@SpringBootTest
public class RecentChkHistoryTest {
	
	//在controller里导入service
	@Resource
	NewBeeMallGoodsService newBeeMallGoodsService;
	
	@Test
	public void TestSearchHistory() {	
	//显示检索履历
	ArrayList<RecentChkHistory> history=newBeeMallGoodsService.getRecentChkHistory();
	ArrayList<RecentChkHistory>test=new ArrayList<>();
	
	RecentChkHistory e1=new RecentChkHistory();
	RecentChkHistory e2=new RecentChkHistory();
	RecentChkHistory e3=new RecentChkHistory();
	RecentChkHistory e4=new RecentChkHistory();
	e1.setGoodsName("无印良品 MUJI 基础润肤化妆水");
	e1.setGoodsCoverImg("/goods-img/87446ec4-e534-4b49-9f7d-9bea34665284.jpg");
	e1.setOriginalPrice(100);
	e1.setSellingPrice(100);
	
	e2.setGoodsName("无印良品 MUJI 基础润肤乳液");
	e2.setGoodsCoverImg("/goods-img/7614ce78-0ebc-4275-a7cc-d16ad5f5f6ed.jpg");
	e2.setOriginalPrice(83);
	e2.setSellingPrice(83);
	
	e3.setGoodsName("无印良品 MUJI 柔和洁面泡沫");
	e3.setGoodsCoverImg("/goods-img/45854bdd-2ca5-423c-a609-3d336d9322b4.jpg");
	e3.setOriginalPrice(45);
	e3.setSellingPrice(45);
	
	e4.setGoodsName("无印良品 MUJI 基础润肤乳液");
	e4.setGoodsCoverImg("/goods-img/ef75879d-3d3e-4bab-888d-1e4036491e11.jpg");
	e4.setOriginalPrice(100);
	e4.setSellingPrice(100);
	
	test.add(e1);
	test.add(e2);
	test.add(e3);
	test.add(e4);
	
	String historyStr=String.valueOf(history);
	String testStr=String.valueOf(test);
	System.out.println("检索履历为"+history);
	assertEquals(testStr,historyStr);
	
  
	
	}
}
   




