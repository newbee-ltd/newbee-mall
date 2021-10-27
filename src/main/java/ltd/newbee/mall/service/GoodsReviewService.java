package ltd.newbee.mall.service;

import java.util.ArrayList;
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
	ArrayList<GoodsReview> getSankouUserId(GoodsReview goodsReviewHelpNum);
	boolean insertHelpNum(GoodsReview goodsReviewHelpNum);
	boolean updateReviewNum(GoodsReview goodsReviewHelpNum);
	long getHelpNum(long reviewId);
	
//	long insertHelpNum(GoodsReview goodsReviewHelpNum);
//    long getHelpNumTwice(long reviewId);
    
    // レビュー平均評価x.xの情報
	double getAverageStarByGoodsId(long goodsId);
//	public ArrayList<GoodsReview> getAverageStarByGoodsId(long goodsId);
	
	// 参考になったを押下した後、「参考になった（125人）」人数を計算
	long getReviewHelpNum(long goodsId, long reviewId);
//	ArrayList<GoodsReview> getReviewHelpNum(long goodsId, long reviewId);
	
}
