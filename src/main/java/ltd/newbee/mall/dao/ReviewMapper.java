package ltd.newbee.mall.dao;

import java.util.List;
import java.util.Map;

import ltd.newbee.mall.controller.vo.ReviewVO;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.entity.ReviewSannkou;
import ltd.newbee.mall.util.PageInquiryUtil;
import ltd.newbee.mall.util.PageInquiryUtil2;

public interface ReviewMapper {

	//评论分页
	List<Review> findReviewList(PageInquiryUtil pageUtil);
	int getTotalReview(PageInquiryUtil pageUtil);
	
	//show more review 2
	List<Review> getReviewList(PageInquiryUtil2 pageUtil);
	int getTotalReview(PageInquiryUtil2 pageUtil);
	Long getCount(long goodsId);
	
	//普通查找
	long insertReview(Review review);
	Long getMaxReviewId(Long reviewId);
	
	//レビューをもっと見る
	List<Review> getGoodsReview(Long goodsId);
	//List<ReviewVO> getGoodsReviews(Long goodsId);
	
	//参考になったを押下した際、どの商品、どのレビューに対して誰が押したかをDBに記録する必要がある。
	//かつ、押下したことがあるユーザーならば、警告メッセージが提出してください。
	List<ReviewSannkou> getReviewSannkouUserId(ReviewSannkou reviewSannkou);
	boolean insertHelpNum(ReviewSannkou reviewSannkou);
	boolean updateReviewNum(ReviewSannkou reviewSannkou);
	long getHelpNum(long reviewId,long goodsId);
	
	//レビュー平均評価x.xの情報
	double getAverageStar(Long goodsId);
	
	//参考になったを押下した後、「参考になった（125人）」人数を計算
	long getTotalSannkou(Long goodsId, Long reviewId);
	
	// 
	List<Review>  getStarNum(long goodsId);

}
