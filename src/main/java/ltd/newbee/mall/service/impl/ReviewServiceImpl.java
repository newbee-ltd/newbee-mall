/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.controller.vo.ReviewVO;
import ltd.newbee.mall.dao.ReviewMapper;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.service.ReviewService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageInquiryResult;
import ltd.newbee.mall.util.PageInquiryUtil;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public PageInquiryResult getReviewPage(PageInquiryUtil pageUtil) {
		List<Review> ReviewList = reviewMapper.findReviewList(pageUtil);
		int totalReview = reviewMapper.getTotalReview(pageUtil);
		PageInquiryResult pageInquiryResult = new PageInquiryResult(ReviewList, totalReview, pageUtil.getLimit(),
				pageUtil.getCurrentPage());
		return pageInquiryResult;
	}

	
	@Override
	public long insertReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	@Override
	public Long getMaxReviewId(Long reviewId) {
		Long maxrReviewId = reviewMapper.getMaxReviewId(reviewId);
		if (maxrReviewId != null) {
			return maxrReviewId + 1;
		} else {
			return 1L;
		}
	}
	
	
	@Override
	public List<ReviewVO> getGoodsReviews(Long goodsId) {
		List<Review> entityList = reviewMapper.getGoodsReview(goodsId);
		List<ReviewVO> reviewVOList = BeanUtil.copyList(entityList, ReviewVO.class);
		return reviewVOList;
	}

}
