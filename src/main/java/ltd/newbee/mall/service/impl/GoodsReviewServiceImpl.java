package ltd.newbee.mall.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.GoodsReviewMapper;
import ltd.newbee.mall.entity.GoodsReview;
import ltd.newbee.mall.service.GoodsReviewService;
import ltd.newbee.mall.util.GoodsReviewUtil;
import ltd.newbee.mall.util.PageResult;

@Service
public class GoodsReviewServiceImpl implements GoodsReviewService {
	
	@Autowired
	private GoodsReviewMapper goodsReviewMapper;
	
	// review查询部分
	@Override
	public PageResult getGoodsReview(GoodsReviewUtil goodsReview) {
		List<GoodsReview> list = goodsReviewMapper.findGoodsReviewList(goodsReview);
		int total = goodsReviewMapper.getTotalGoodsReview(goodsReview);
		PageResult  goodsReviewList = new PageResult(list, total, goodsReview.getLimit(), goodsReview.getStart());
		return goodsReviewList;
	}
	
	@Override
	public long getCount(Map map) {
		return goodsReviewMapper.getCount(map);
	}
	
	// insert
	@Override
	public long insertGoodsReview(GoodsReview goodsReview) {
		long maxGoodsReviewId = goodsReviewMapper.getMaxGoodsReviewId();
		goodsReview.setReviewId(maxGoodsReviewId + 1);
		return goodsReviewMapper.insertGoodsReview(goodsReview);
	}
	
	// 参考になった
	@Override
	public ArrayList<GoodsReview> getSankouUserId(GoodsReview goodsReviewHelpNum) {
		return goodsReviewMapper.getSankouUserId(goodsReviewHelpNum);
	}
	
	@Override
	public boolean insertHelpNum(GoodsReview goodsReviewHelpNum) {
		return goodsReviewMapper.insertHelpNum(goodsReviewHelpNum);
	}
	
	@Override
	public boolean updateReviewNum(GoodsReview goodsReviewHelpNum) {
		return goodsReviewMapper.updateReviewNum(goodsReviewHelpNum);
	}
	
	@Override
	public long getHelpNum(long reviewId) {
		return goodsReviewMapper.getHelpNum(reviewId);
	}
	
//	@Override
//	public long insertHelpNum(GoodsReview goodsReviewHelpNum) {
//		long maxHelpNum = goodsReviewMapper.getMaxHelpNum();
//		goodsReviewHelpNum.setHelpNum(maxHelpNum + 1);
//		return goodsReviewMapper.insertHelpNum(goodsReviewHelpNum);
//	}
//	
//	@Override
//	public long getHelpNumTwice(long reviewId) {
//		return goodsReviewMapper.getHelpNumTwice(reviewId);
//	}
	
	// レビュー平均評価x.xの情報
	@Override
	public double getAverageStarByGoodsId(long goodsId) {
		return goodsReviewMapper.getAverageStarByGoodsId(goodsId);
	}
//	@Override
//	public ArrayList<GoodsReview> getAverageStarByGoodsId(long goodsId) {
//		return goodsReviewMapper.getAverageStarByGoodsId(goodsId);
//	}
	
	// 参考になったを押下した後、「参考になった（125人）」人数を計算
	@Override
	public long getReviewHelpNum(long goodsId, long reviewId) {
		return goodsReviewMapper.getReviewHelpNum(goodsId, reviewId);
	}
//	@Override
//	public ArrayList<GoodsReview> getReviewHelpNum(long goodsId, long reviewId) {
//		return goodsReviewMapper.getReviewHelpNum(goodsId, reviewId);
//	}
	
}
