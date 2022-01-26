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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
		Map<String,Object>params2=new HashMap<String,Object>();        		
        params2.put("reviewMore", 0);
        params2.put("reviewType", 1);
        params2.put("reviewRate", 5);

		ArrayList<GoodsReview>list=newBeeMallGoodsService.getGoodsReview(params2);
		System.out.println(list);
		
		
		double avg=newBeeMallGoodsService.getRateAvg(10700l);
		System.out.println(avg);
		
		long countReview=newBeeMallGoodsService.getReviewCount(10700l);
		assertEquals(6,countReview);
		
		Long[] myList=newBeeMallGoodsService.getRateCount(10700l);
		String arr=Arrays.toString(myList);
		System.out.println(arr);

}

}

