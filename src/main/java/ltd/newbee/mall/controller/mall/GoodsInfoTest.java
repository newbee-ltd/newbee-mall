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

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ltd.newbee.mall.entity.GoodsInfo;
import ltd.newbee.mall.service.NewBeeMallGoodsService;


@SpringBootTest
public class GoodsInfoTest {
	//在controller里导入service
	@Resource
	NewBeeMallGoodsService newBeeMallGoodsService;
	@Test
	public void testGoodsInfo() {
		GoodsInfo info = newBeeMallGoodsService.getGoodsInfoByPK(5651205l);
		assertEquals("nature",info.getName());
		assertEquals("98×200×23.5(cm)",info.getSize());
	}

   

}


