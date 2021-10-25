
package ltd.newbee.mall.service;

import java.util.ArrayList;

import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;

public interface CategoryOrGoodsService {
	
	ArrayList<ApplyCategoryCampaign> getApplyCategory(ApplyCategoryCampaign applyCategoryCampaign);
	
	ArrayList<ApplyGoodsCampaign> getApplyGoods(ApplyGoodsCampaign applyGoodsCampaign);
	
	long insertCategoryCampaign(ApplyCategoryCampaign applyCategoryCampaign);
	Long getMaxCategoryId(Long categoryId);
	
	long insertGoodsCampaign(ApplyGoodsCampaign applyGoodsCampaign);
	Long getMaxGoodsId(Long GoodsId);
	
	int updateCategoryDelete(ApplyCategoryCampaign applyCategoryCampaign);
	int updateGoodsDelete(ApplyGoodsCampaign applyGoodsCampaign);

}
