package ltd.newbee.mall.dao;

import java.util.ArrayList;
import java.util.List;

import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;
import ltd.newbee.mall.entity.Student;
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
	
}
