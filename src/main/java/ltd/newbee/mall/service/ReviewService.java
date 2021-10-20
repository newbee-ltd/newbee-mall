package ltd.newbee.mall.service;

import java.util.List;
import java.util.Map;

import ltd.newbee.mall.controller.vo.ReviewVO;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.util.PageInquiryResult;
import ltd.newbee.mall.util.PageInquiryUtil;

public interface ReviewService {

	PageInquiryResult getReviewPage(PageInquiryUtil pageUtil);

	long insertReview(Review review);

	Long getMaxReviewId(Long reviewId);

	
	List<ReviewVO> getGoodsReviews(Long goodsId);

}
