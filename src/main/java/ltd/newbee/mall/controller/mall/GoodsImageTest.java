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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import ltd.newbee.mall.entity.GoodsImageEntity;
import ltd.newbee.mall.entity.GoodsInfo;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.util.SearchPageParams;


@SpringBootTest
public class GoodsImageTest {
	//在controller里导入service
	@Resource
	NewBeeMallGoodsService newBeeMallGoodsService;
	@Test
	public void testGoodsImage() {
		long id =10700;
		List<GoodsImageEntity> list = newBeeMallGoodsService.getGoodsImageByPk(id);
			assertEquals(3,list.size());
	}
	
	@Test
	public void testGoodsPage() {	
		Map<String,Object>params2=new HashMap<String,Object>();        
		
        params2.put("keyword", "iPhone");
        params2.put("pageNo", 1);
        params2.put("categoryId", 46);
        params2.put("orderBy", "");
        SearchPageParams paraMap=new SearchPageParams(params2);

		ArrayList<NewBeeMallGoods>list=newBeeMallGoodsService.getGoodsPage(paraMap);
		
		if(!CollectionUtils.isEmpty(list)) {
			assertEquals(3,list.size());
			assertTrue(checkGoodsIdInList(list,10278l));
			assertTrue(checkCategoryIdInList(list,46));
		}
		
	} 
	
	private boolean checkGoodsIdInList(ArrayList<NewBeeMallGoods>list,Long goodsId) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getGoodsId()==goodsId) {
			return true;
		}
		}
			return false;
	
	
	}
	private boolean checkCategoryIdInList(ArrayList<NewBeeMallGoods>list,int categoryId) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getGoodsCategoryId()==categoryId) {
			return true;
		}
		}
			return false;
	
	
	}

   

}


