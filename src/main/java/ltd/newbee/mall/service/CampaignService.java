package ltd.newbee.mall.service;

import java.util.ArrayList;

import ltd.newbee.mall.entity.CampaignCategory;
import ltd.newbee.mall.entity.CampaignGoods;

public interface CampaignService {
	
	// campaign查询
	ArrayList<CampaignGoods> getCampaignGoods(long parentId);
	ArrayList<CampaignCategory> getCampaignCategory(long parentId);
	
	// キャンペーン適用(商品)
	long insertCampaignGoods(CampaignGoods campaignGoods);
	
	// キャンペーン適用(カテゴリー)
	long insertCampaignCategory(CampaignCategory campaignCategory);
		
	// キャンペーン削除(商品)
    long updateCampaignGoods(CampaignGoods campaignGoods);
	
	// キャンペーン削除(カテゴリー)
	long updateCampaignCategory(CampaignCategory campaignCategory);	
	
	// キャンペーン情報のdropDownListのAPI
	ArrayList<CampaignGoods> getGoodsDropDownList(String campaignName);
	ArrayList<CampaignCategory> getCategoryDropDownList(String campaignName);
	
}
