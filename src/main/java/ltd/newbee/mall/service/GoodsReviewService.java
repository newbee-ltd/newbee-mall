package ltd.newbee.mall.service;

import java.util.Map;

import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.util.GoodsReviewUtil;
import ltd.newbee.mall.util.PageResult;

public interface GoodsReviewService {
	
	// review查询部分
	PageResult getGoodsReview(GoodsReviewUtil goodsReview);

	long getCount(Map map);
	
	// insert
	long insertGoodsReview(GoodsReview goodsReview);
	
	// 参考になった
	boolean insertHelpNum(GoodsReview goodsReviewHelpNum);
	boolean updateReivewNum(GoodsReview goodsReviewHelpNum);
	long getHelpNum(long goodsReviewHelpNum);
	
}
