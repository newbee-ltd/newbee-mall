package ltd.newbee.mall.dao;

import java.util.List;

import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.util.PageInquiryUtil;

public interface ReviewMapper {

	List<Review> findReviewList(PageInquiryUtil pageUtil);
	int getTotalReview(PageInquiryUtil pageUtil);
	
}
