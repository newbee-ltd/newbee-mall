package ltd.newbee.mall.dao;

import java.util.ArrayList;

import ltd.newbee.mall.entity.CampaignCategory;
import ltd.newbee.mall.entity.CampaignGoods;

public interface CampaignMapper {
	
	// campaign查询
	public ArrayList<CampaignGoods> getCampaignGoods(CampaignGoods campaignGoods);
	public ArrayList<CampaignCategory> getCampaignCategory(CampaignCategory campaignCategory);
	
	// キャンペーン適用(商品)
	long insertCampaignGoods(CampaignGoods campaignGoods);
	long getMaxGoodsId();
	
	// キャンペーン適用(カテゴリー)
	long insertCampaignCategory(CampaignCategory campaignCategory);
	long getMaxCategoryId();
	
	// キャンペーン削除(商品)
	long updateCampaignGoods(CampaignGoods campaignGoods);
	
	// キャンペーン削除(カテゴリー)
	long updateCampaignCategory(CampaignCategory campaignCategory);
	
}