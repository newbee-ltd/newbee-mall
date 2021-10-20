package ltd.newbee.mall.dao;

import java.util.List;

import ltd.newbee.mall.controller.vo.ReviewVO;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.util.PageInquiryUtil;

public interface ReviewMapper {

	//评论分页
	List<Review> findReviewList(PageInquiryUtil pageUtil);
	int getTotalReview(PageInquiryUtil pageUtil);
	
	//普通查找
	long insertReview(Review review);
	Long getMaxReviewId(Long reviewId);
	
	//レビューをもっと見る
	List<Review> getGoodsReview(Long goodsId);
	List<ReviewVO> getGoodsReviews(Long goodsId);
	
	
}
