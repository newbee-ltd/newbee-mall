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
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.CollectionUtils;

import ltd.newbee.mall.entity.GoodsImageEntity;
import ltd.newbee.mall.entity.GoodsInfo;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.entity.InsertGoodsReview;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.SearchPageParams;

@SpringBootTest


public class InsertGoodsReviewTest {
	//在controller里导入service
	@Resource
	NewBeeMallGoodsService newBeeMallGoodsService;
	
	@Test
	public void InsertGoodsReviewTest() {	
		InsertGoodsReview e = new InsertGoodsReview(); 
		e.setStar(2);
	    e.setUser_id("xiaomao"); 
	    e.setReview_date("2021/12/21"); 
	    e.setGoods_id(10704);
	    e.setReview_title("title20");
	    e.setReview("review20");
	    e.setImage("/goods-img/cf19de8b-e94e-4513-aecd-a0b5c976b738.jpg"); 
	    
	    int cnt = newBeeMallGoodsService.insertGoodsReview(e); 
	    System.out.println(cnt);

}

}

