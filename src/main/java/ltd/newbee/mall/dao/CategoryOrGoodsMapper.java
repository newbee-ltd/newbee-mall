package ltd.newbee.mall.dao;

import java.util.ArrayList;
import java.util.List;

import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.campaign.ApplyGoodsCampaign2;
import ltd.newbee.mall.entity.campaign.Campaign;


public interface CategoryOrGoodsMapper {

	//
	ArrayList<ApplyCategoryCampaign> getApplyCategory(long parentId);
	ArrayList<ApplyGoodsCampaign> getApplyGoods(long parentId);
	
	//
	long insertCategoryCampaign(ApplyCategoryCampaign applyCategoryCampaign);
	long insertGoodsCampaign(ApplyGoodsCampaign applyGoodsCampaign);

	//
	int updateCategoryDelete(ApplyCategoryCampaign applyCategoryCampaign);
	int updateGoodsDelete(ApplyGoodsCampaign applyGoodsCampaign);
	
	//キャンペーン情報のdropDownListのAPI
	List<Campaign> dropDownList();
	
	//CSV
	long insertGoodsCampaign2(ApplyGoodsCampaign2 agc);
	List<NewBeeMallGoods> getGoodsIdList(long goodsId);
	List<Campaign> getCampaignIdList(long campaignId);
	//ArrayList<String> msgList();
	
	// modal
	List<NewBeeMallGoods> getGoodsInfoList();
	
}
