
package ltd.newbee.mall.service;

import java.util.ArrayList;

import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;

public interface CategoryOrGoodsService {
	
	ArrayList<ApplyCategoryCampaign> getApplyCategory(ApplyCategoryCampaign applyCategoryCampaign);
	
	ArrayList<ApplyGoodsCampaign> getApplyGoods(ApplyGoodsCampaign applyGoodsCampaign);

}
