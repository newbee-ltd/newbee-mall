package ltd.newbee.mall.dao;

import java.util.ArrayList;
import java.util.Date;

import ltd.newbee.mall.entity.CampaignCategory;
import ltd.newbee.mall.entity.CampaignGoods;

public interface CampaignMapper {
	
	// campaign查询
	public ArrayList<CampaignGoods> getCampaignGoods(long parentId);
	public ArrayList<CampaignCategory> getCampaignCategory(long parentId);
	
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
	
	// キャンペーン情報のdropDownListのAPI
	public ArrayList<CampaignGoods> getGoodsDropDownList(String campaignName);
	public ArrayList<CampaignCategory> getCategoryDropDownList(String campaignName);
	
	// goods_idは商品マスタに存在するかどうかをチェック
	public ArrayList<CampaignGoods> getCampaignGoodsId(long goodsId);
	
}