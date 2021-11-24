
package ltd.newbee.mall.service;

import java.util.ArrayList;
import java.util.List;

import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.campaign.ApplyGoodsCampaign2;
import ltd.newbee.mall.entity.campaign.Campaign;

public interface CategoryOrGoodsService {

	ArrayList<ApplyCategoryCampaign> getApplyCategory(long parentId);

	ArrayList<ApplyGoodsCampaign> getApplyGoods(long parentId);

	long insertCategoryCampaign(ApplyCategoryCampaign applyCategoryCampaign);

	long insertGoodsCampaign(ApplyGoodsCampaign applyGoodsCampaign);

	int updateCategoryDelete(ApplyCategoryCampaign applyCategoryCampaign);

	int updateGoodsDelete(ApplyGoodsCampaign applyGoodsCampaign);

	List<Campaign> dropDownList();

	// CSV
	long insertGoodsCampaign2(ApplyGoodsCampaign2 agc);

	List<NewBeeMallGoods> getGoodsIdList(long goodsId);

	List<Campaign> getCampaignIdList(long campaignId);

    // modal
	List<NewBeeMallGoods> getGoodsInfoList();

}
