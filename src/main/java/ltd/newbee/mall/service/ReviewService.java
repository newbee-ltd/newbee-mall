package ltd.newbee.mall.service;

import java.util.List;
import java.util.Map;

import ltd.newbee.mall.controller.vo.ReviewVO;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.entity.ReviewSannkou;
import ltd.newbee.mall.util.PageInquiryResult;
import ltd.newbee.mall.util.PageInquiryResult2;
import ltd.newbee.mall.util.PageInquiryUtil;
import ltd.newbee.mall.util.PageInquiryUtil2;

public interface ReviewService {

	PageInquiryResult getReviewPage(PageInquiryUtil pageUtil);
	
	
	PageInquiryResult2 getMoreReview(PageInquiryUtil2 pageUtil);
	Long getCount (Map map);

	long insertReview(Review review);
	Long getMaxReviewId(Long reviewId);

	
	List<ReviewVO> getGoodsReviews(Long goodsId);

	
	List<ReviewSannkou> getReviewSannkouUserId(ReviewSannkou reviewSannkou);
	boolean insertHelpNum(ReviewSannkou reviewSannkou);
    boolean updateReviewNum(ReviewSannkou reviewSannkou);
    long getHelpNum(long reviewId); 


    List<Review> getAverageStar(Long goodsId);
    
    List<Review> getTotalSannkou(Long goodsId, Long reviewId);
	
}
