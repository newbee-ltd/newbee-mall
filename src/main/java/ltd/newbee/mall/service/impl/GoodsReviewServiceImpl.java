package ltd.newbee.mall.service.impl;

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
	public boolean insertHelpNum(GoodsReview goodsReviewHelpNum) {
		long maxHelpNum = goodsReviewMapper.getMaxHelpNum();
		goodsReviewHelpNum.setHelpNum(maxHelpNum + 1);
		return goodsReviewMapper.insertHelpNum(goodsReviewHelpNum);
	}
	
	@Override
	public boolean updateReivewNum(GoodsReview goodsReviewHelpNum) {
		boolean count = goodsReviewMapper.updateReivewNum(goodsReviewHelpNum);
    	return count;
	}
	
	public long getHelpNum(long goodsReviewHelpNum) {
		long count = goodsReviewMapper.getHelpNum(goodsReviewHelpNum);
    	return count;
	}
	
}
