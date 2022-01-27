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
import ltd.newbee.mall.service.NewBeeMallGoodsService;



@SpringBootTest
public class SearchHistoryTest {
	
	//在controller里导入service
	@Resource
	NewBeeMallGoodsService newBeeMallGoodsService;
	
	@Test
	public void TestSearchHistory() {	
	//显示检索履历
	ArrayList<String> history=newBeeMallGoodsService.getSearchHistory();
	ArrayList<String> testHistory=new ArrayList<String>();
	testHistory.add("iphone7");
	testHistory.add("iphone");
	testHistory.add("iphone10");
	testHistory.add("iphon13");
	String historyStr=String.valueOf(history);
	String testHistoryStr=String.valueOf(testHistory);
	System.out.println("检索履历为"+history);
	assertEquals(testHistoryStr,historyStr);
	
    //保存检索
	InsertSearchHistoryEntity e=new InsertSearchHistoryEntity();
	e.setUserId(1001);
	Date date= new Date();
	e.setDateTime(date);
	e.setKeyword("iphone7");
	
	int insertResult=newBeeMallGoodsService.insertSearchHistory(e);
	System.out.println("输入到第"+insertResult+"行");
	
	
	//显示关键字的关联词
	String keyword="iPhone";
	ArrayList<String> result=newBeeMallGoodsService.getGoodsName(keyword);
	ArrayList<String> test=new ArrayList<String>();
	test.add("Apple iPhone 11 (A2223)");
	test.add("Apple iPhone XR (A2108)");
	test.add("Apple iPhone 11 Pro");
	test.add("Apple iPhone 7 (A1660)");
	test.add("Apple iPhone XS Max");
	String resultStr=String.valueOf(result);
	String testStr=String.valueOf(test);
	System.out.println(keyword+"的关联词为"+result);
	assertEquals(testStr,resultStr);
	
	}
}
   




