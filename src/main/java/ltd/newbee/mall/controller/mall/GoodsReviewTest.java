/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.PropertySource;
import org.springframework.util.CollectionUtils;

import ltd.newbee.mall.entity.GoodsImageEntity;
import ltd.newbee.mall.entity.GoodsInfo;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.SearchPageParams;






@SpringBootTest

public class GoodsReviewTest {
	//在controller里导入service
	@Resource
	NewBeeMallGoodsService newBeeMallGoodsService;
	
	@Test
	public void testGoodsReview() {	

		
		//显示商品10700的五星评价的前三条
		Map<String,Object>paramsResult1=new HashMap<String,Object>();        		
		paramsResult1.put("reviewMore", 0);//显示前三条
		paramsResult1.put("reviewType", 1);//显示某一星级>显示某一星级的前三条
		paramsResult1.put("reviewRate", 5);
		paramsResult1.put("goodsId", 10700);
		
		ArrayList<GoodsReview>list1=newBeeMallGoodsService.getGoodsReview(paramsResult1);
		System.out.println("list1为"+list1);
		ArrayList<GoodsReview>testList1=new ArrayList<GoodsReview>();
		GoodsReview e1=new GoodsReview();
		GoodsReview e3=new GoodsReview();
		GoodsReview e4=new GoodsReview();
		e1.setStar(5);
		e1.setUserId("xiaoxu");
		e1.setReviewDate("2022/1/17");
		e1.setGoodsId(10700);
		e1.setReviewTitle("title5");
		e1.setReview("review5");
		e1.setImage("/goods-img/558422d1-640e-442d-a073-2b2bdd95c4ed.jpg");
		
		e4.setStar(5);
		e4.setUserId("xiaoliang");
		e4.setReviewDate("2021/12/23");
		e4.setGoodsId(10700);
		e4.setReviewTitle("title22");
		e4.setReview("review22");
		e4.setImage("/goods-img/b7bfcc28-98c2-4cb4-8ce3-afe4c482b674.jpg");
		
		e3.setStar(5);
		e3.setUserId("xiaogou");
		e3.setReviewDate("2021/12/22");
		e3.setGoodsId(10700);
		e3.setReviewTitle("title21");
		e3.setReview("review21");
		e3.setImage("/goods-img/7031c07e-a70f-4f6d-9e2d-d0af31e3393a.jpg");
		testList1.add(e1);
		testList1.add(e3);
		testList1.add(e4);
		String L1=String.valueOf(list1);
		String T1=String.valueOf(testList1);
		System.out.println("L1为"+L1);
		System.out.println("T1为"+T1);
		assertEquals(T1,L1);
		
		
		//显示商品10700的所有星评价的前三条
		Map<String,Object>paramsResult2=new HashMap<String,Object>();        		
		paramsResult2.put("reviewMore", 0);//显示前三条
		paramsResult2.put("reviewType", 0);//显示全部星级的前三条
		paramsResult2.put("reviewRate", 5); 
		paramsResult2.put("goodsId", 10700);
		
		ArrayList<GoodsReview>list2=newBeeMallGoodsService.getGoodsReview(paramsResult2);
		System.out.println("list2为"+list2);
		ArrayList<GoodsReview>testList2=new ArrayList<GoodsReview>();
		GoodsReview e2=new GoodsReview();
		e2.setStar(5);
		e2.setUserId("xiaoxu");
		e2.setReviewDate("2022/1/17");
		e2.setGoodsId(10700);
		e2.setReviewTitle("title5");
		e2.setReview("review5");
		e2.setImage("/goods-img/558422d1-640e-442d-a073-2b2bdd95c4ed.jpg");
		
		testList2.add(e2);
		testList2.add(e3);
		testList2.add(e4);
		String L2=String.valueOf(list2);
		String T2=String.valueOf(testList2);
		System.out.println("L2为"+L2);
		System.out.println("T2为"+T2);
		assertEquals(T2,L2); 
		
		
		//显示商品10700的五星评论的第三条之后的全部
		Map<String,Object>paramsResult3=new HashMap<String,Object>();        		
		paramsResult3.put("reviewMore", 1);//显示4~的所有条
		paramsResult3.put("reviewType", 1);//显示某一星级>显示某一星级的4~的所有条
		paramsResult3.put("reviewRate", 5);
		paramsResult3.put("goodsId", 10700);
	
		ArrayList<GoodsReview>list3=newBeeMallGoodsService.getGoodsReview(paramsResult3);
		System.out.println("list3为"+list3);
		ArrayList<GoodsReview>testList3=new ArrayList<GoodsReview>();
		GoodsReview e5=new GoodsReview();
		e5.setStar(5);
		e5.setUserId("xiaoa");
		e5.setReviewDate("2021/12/26");
		e5.setGoodsId(10700);
		e5.setReviewTitle("title23");
		e5.setReview("review23");
		e5.setImage("/goods-img/6a160b96-9b4a-4844-b335-feb31b1f5d8c.jpg");
		testList3.add(e5);
		String L3=String.valueOf(list3);
		String T3=String.valueOf(testList3);
		System.out.println("L3为"+L3);
		System.out.println("T3为"+T3);
		assertEquals(T3,L3);
		
		
		//显示商品10701的全部星级评论的4~评论
		Map<String,Object>paramsResult4=new HashMap<String,Object>();        		
		paramsResult4.put("reviewMore", 1);//显示4~的所有条
		paramsResult4.put("reviewType", 0);//显示全部星级~的所有条
		paramsResult4.put("reviewRate", 5);
		paramsResult4.put("goodsId", 10701);
		
		ArrayList<GoodsReview>list4=newBeeMallGoodsService.getGoodsReview(paramsResult4);
		System.out.println("list4为"+list4);
		ArrayList<GoodsReview>testList4=new ArrayList<GoodsReview>();
		GoodsReview e6=new GoodsReview();
		e6.setStar(1);
		e6.setUserId("xiaoc");
		e6.setReviewDate("2021/12/28");
		e6.setGoodsId(10701);
		e6.setReviewTitle("title21");
		e6.setReview("review21");
		e6.setImage("/goods-img/8ccc13ec-96fe-4488-a604-526601548c9e.jpg");
		testList4.add(e6);
		String L4=String.valueOf(list4);
		String T4=String.valueOf(testList4);
		System.out.println("L4为"+L4);
		System.out.println("T4为"+T4);
		assertEquals(T4,L4);
		
		
		

		
		
		
		
		double avg=newBeeMallGoodsService.getRateAvg(10700l);
		System.out.println("平均评分为"+avg);
		
		long countReview=newBeeMallGoodsService.getReviewCount(10700l);
	    assertEquals(9,countReview);
		
		Long[] myList=newBeeMallGoodsService.getRateCount(10700l);
		String arr=Arrays.toString(myList);
		System.out.println("评分为5，4，3，2，1的人数分别为"+arr);

		Map<String,Object>params2=new HashMap<String,Object>();        		
        params2.put("reviewMore", 0);
        params2.put("reviewType", 1);
        params2.put("reviewRate", 5);

		ArrayList<GoodsReview>list=newBeeMallGoodsService.getGoodsReview(params2);
		System.out.println(list);
		
		
//		double avg=newBeeMallGoodsService.getRateAvg(10700l);
//		System.out.println(avg);
//		
//		long countReview=newBeeMallGoodsService.getReviewCount(10700l);
//		assertEquals(6,countReview);
//		
//		Long[] myList=newBeeMallGoodsService.getRateCount(10700l);
//		String arr=Arrays.toString(myList);
		System.out.println(arr);


}

}

