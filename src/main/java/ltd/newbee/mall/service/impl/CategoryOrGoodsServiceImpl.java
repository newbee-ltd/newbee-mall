/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.CategoryOrGoodsMapper;
import ltd.newbee.mall.dao.StudentMapper;
import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.entity.campaign.ApplyGoodsCampaign2;
import ltd.newbee.mall.entity.campaign.BuyGoodsSet;
import ltd.newbee.mall.entity.campaign.Campaign;
import ltd.newbee.mall.service.CategoryOrGoodsService;
import ltd.newbee.mall.service.StudentService;
import ltd.newbee.mall.util.PageInquiryUtil;

@Service
public class CategoryOrGoodsServiceImpl implements CategoryOrGoodsService {

	@Autowired
	private CategoryOrGoodsMapper categoryOrGoodsMapper;

	//
	@Override
	public ArrayList<ApplyCategoryCampaign> getApplyCategory(long parentId) {
		return categoryOrGoodsMapper.getApplyCategory(parentId);
	}
	
	@Override
	public ArrayList<ApplyGoodsCampaign> getApplyGoods(long parentId) {
		return categoryOrGoodsMapper.getApplyGoods(parentId);
	}

	//
	@Override
	public long insertCategoryCampaign(ApplyCategoryCampaign applyCategoryCampaign) {
		return categoryOrGoodsMapper.insertCategoryCampaign(applyCategoryCampaign);
	}
	
	@Override
	public long insertGoodsCampaign(ApplyGoodsCampaign applyGoodsCampaign) {
		return categoryOrGoodsMapper.insertGoodsCampaign(applyGoodsCampaign);
	}


	//
	@Override
	public int updateCategoryDelete(ApplyCategoryCampaign applyCategoryCampaign) {
		return categoryOrGoodsMapper.updateCategoryDelete(applyCategoryCampaign);
	}
	
	@Override
	public int updateGoodsDelete(ApplyGoodsCampaign applyGoodsCampaign) {
		return categoryOrGoodsMapper.updateGoodsDelete(applyGoodsCampaign);
	}
	
	//
	@Override
	public List<Campaign> dropDownList(){
		return categoryOrGoodsMapper.dropDownList();
	}

    //CSV
	@Override
	public long insertGoodsCampaign2(ApplyGoodsCampaign2 agc) {
		return categoryOrGoodsMapper.insertGoodsCampaign2(agc);
	}
	@Override
	public 	List<NewBeeMallGoods> getGoodsIdList(long goodsId){
		return categoryOrGoodsMapper.getGoodsIdList(goodsId);
	}
	@Override
	public List<Campaign> getCampaignIdList(long campaignId){
		return categoryOrGoodsMapper.getCampaignIdList(campaignId);
	}
	
	//
	@Override
	public List<NewBeeMallGoods> getGoodsInfoList(){
		return categoryOrGoodsMapper.getGoodsInfoList();
	}
	@Override
	public long updateBuyGoodsSet(BuyGoodsSet buyGoodsSet) {
		return categoryOrGoodsMapper.updateBuyGoodsSet(buyGoodsSet);
	}
	
}
