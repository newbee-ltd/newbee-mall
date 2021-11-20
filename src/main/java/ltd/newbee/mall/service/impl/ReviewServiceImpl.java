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
import org.springframework.util.CollectionUtils;

import ltd.newbee.mall.controller.vo.ReviewVO;
import ltd.newbee.mall.dao.ReviewMapper;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.entity.ReviewSannkou;
import ltd.newbee.mall.service.ReviewService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageInquiryResult;
import ltd.newbee.mall.util.PageInquiryResult2;
import ltd.newbee.mall.util.PageInquiryUtil;
import ltd.newbee.mall.util.PageInquiryUtil2;

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

	// show more page 2
	@Override
	public PageInquiryResult2 getMoreReview(PageInquiryUtil2 pageUtil) {
		List<Review> ReviewList = reviewMapper.getReviewList(pageUtil);
		int totalReview = reviewMapper.getTotalReview(pageUtil);
		PageInquiryResult2 pageInquiryResult = new PageInquiryResult2(ReviewList, totalReview, pageUtil.getLimit());
		return pageInquiryResult;
	}

	@Override
	public Long getCount(long goodsId) {
		return reviewMapper.getCount(goodsId);
	}

	//
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

	// show more page 1
	@Override
	public List<Review> getGoodsReview(Long goodsId) {
		List<Review> reviewList = reviewMapper.getGoodsReview(goodsId);
		// List<ReviewVO> reviewVOList = BeanUtil.copyList(entityList, ReviewVO.class);
		return reviewList;
	}

	//
	@Override
	public List<ReviewSannkou> getReviewSannkouUserId(ReviewSannkou reviewSannkou) {
		return reviewMapper.getReviewSannkouUserId(reviewSannkou);
	}

	@Override
	public boolean insertHelpNum(ReviewSannkou reviewSannkou) {
		return reviewMapper.insertHelpNum(reviewSannkou);
	}

	@Override
	public boolean updateReviewNum(ReviewSannkou reviewSannkou) {
		return reviewMapper.updateReviewNum(reviewSannkou);
	}

	@Override
	public long getHelpNum(long reviewId, long goodsId) {
		return reviewMapper.getHelpNum(reviewId, goodsId);
	}

	//
	@Override
	public double getAverageStar(Long goodsId) {
		return reviewMapper.getAverageStar(goodsId);
	}

	//
	@Override
	public long getTotalSannkou(Long goodsId, Long reviewId) {
		return reviewMapper.getTotalSannkou(goodsId, reviewId);
	}

	//
	@Override
	public List<Review> getStarNum(long goodsId) {
		return reviewMapper.getStarNum(goodsId);
	}

}
