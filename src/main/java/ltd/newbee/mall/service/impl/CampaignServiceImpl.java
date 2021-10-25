package ltd.newbee.mall.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.CampaignMapper;
import ltd.newbee.mall.entity.CampaignCategory;
import ltd.newbee.mall.entity.CampaignGoods;
import ltd.newbee.mall.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {
	
	@Autowired
	private CampaignMapper campaignMapper;
	
	// campaign查询
	@Override
	public ArrayList<CampaignGoods> getCampaignGoods(CampaignGoods campaignGoods) {
		return campaignMapper.getCampaignGoods(campaignGoods);
	}
	
	@Override
	public ArrayList<CampaignCategory> getCampaignCategory(CampaignCategory campaignCategory) {
		return campaignMapper.getCampaignCategory(campaignCategory);
	}
	
	// キャンペーン適用(商品)
	@Override
	public long insertCampaignGoods(CampaignGoods campaignGoods) {
		long goodsId = campaignMapper.getMaxGoodsId();
		campaignGoods.setGoodsId(goodsId + 1);
		return campaignMapper.insertCampaignGoods(campaignGoods);
	}
		
	// キャンペーン適用(カテゴリー)
	@Override
	public long insertCampaignCategory(CampaignCategory campaignCategory) {
		long categoryId = campaignMapper.getMaxCategoryId();
		campaignCategory.setCategoryId(categoryId + 1);
		return campaignMapper.insertCampaignCategory(campaignCategory);
	}
			
	// キャンペーン削除(商品)
	@Override
	public long updateCampaignGoods(CampaignGoods campaignGoods) {
		long count = campaignMapper.updateCampaignGoods(campaignGoods);
		return count;
	}
	// キャンペーン削除(カテゴリー)
	@Override
	public long updateCampaignCategory(CampaignCategory campaignCategory) {
		long count = campaignMapper.updateCampaignCategory(campaignCategory);
		return count;
	}

}
