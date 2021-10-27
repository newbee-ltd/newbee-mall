package ltd.newbee.mall.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.util.GoodsReviewUtil;

public interface GoodsReviewMapper {
    
	// review查询部分
	List<GoodsReview> findGoodsReviewList(GoodsReviewUtil goodsReview);
	
	int getTotalGoodsReview(GoodsReviewUtil goodsReview);
	
	long getCount(Map map);
	
	// insert
	long insertGoodsReview(GoodsReview goodsReview);
	long getMaxGoodsReviewId();
	
	/*
	 *  参考になったを押下した際、どの商品、どのレビューに対して誰が押したかをDBに記録する必要がある。
	 *  かつ、押下したことがあるユーザーならば、警告メッセージが提出してください。「押下したことがありますので、押下できません。
	 *  分页的sql有错误，应该是goods_qa left join help_num_tbl 。
	 *  因为会有qa没有人点参考になった，如果是join的话，没有被点参加になった的不会被抽出。
	 */
	 public ArrayList<GoodsReview> getSankouUserId(GoodsReview goodsReviewHelpNum);
	 boolean insertHelpNum(GoodsReview goodsReviewHelpNum);
	 boolean updateReviewNum(GoodsReview goodsReviewHelpNum);
	 long getHelpNum(long reviewId);
	 
//	 long insertHelpNum(GoodsReview goodsReviewHelpNum);
//	 long getMaxHelpNum();
//	 long getHelpNumTwice(long reviewId);
	 
	 // レビュー平均評価x.xの情報
	 double getAverageStarByGoodsId(long goodsId);
//	 public ArrayList<GoodsReview> getAverageStarByGoodsId(long goodsId);
	 
	 // 参考になったを押下した後、「参考になった（125人）」人数を計算
	 long getReviewHelpNum(long goodsId, long reviewId);
//	 public ArrayList<GoodsReview> getReviewHelpNum(long goodsId, long reviewId);
	 
}