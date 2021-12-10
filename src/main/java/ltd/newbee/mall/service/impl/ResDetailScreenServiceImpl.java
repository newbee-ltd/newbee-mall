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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.ResDetailScreenMapper;
import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.entity.ResDetailCourse;
import ltd.newbee.mall.entity.ResDetailFeature;
import ltd.newbee.mall.entity.ResDetailMenuPhoto;
import ltd.newbee.mall.entity.ResDetailPhoto;
import ltd.newbee.mall.entity.ResDetailReserve;
import ltd.newbee.mall.entity.ResDetailReview;
import ltd.newbee.mall.entity.ResDetailScore;
import ltd.newbee.mall.entity.ResDetailScreen;
import ltd.newbee.mall.entity.ResDetailSeat;
import ltd.newbee.mall.service.ResDetailScreenService;
import ltd.newbee.mall.util.PageInquiryResult;
import ltd.newbee.mall.util.PageInquiryUtil;

@Service
public class ResDetailScreenServiceImpl implements ResDetailScreenService {

	@Autowired
	private ResDetailScreenMapper resDetailScreenMapper;

	@Override
	public long getFollowTotal(long followResId) {
		return resDetailScreenMapper.getFollowTotal(followResId);
	}

	@Override
	public List<ResDetailScreen> getResDetail(long restaurantId) {
		return resDetailScreenMapper.getResDetail(restaurantId);
	}
	@Override
	public List<ResDetailPhoto> getMainphoto(long restaurantId,long photoCode){
		return resDetailScreenMapper.getMainphoto(restaurantId, photoCode);
	}
	
	@Override
	public List<ResDetailPhoto> getCommitphoto(long restaurantId){
		return resDetailScreenMapper.getCommitphoto(restaurantId);
	}
	@Override
	public List<ResDetailCourse> getCourse(long restaurantId){
		return resDetailScreenMapper.getCourse(restaurantId);
	}
	
	@Override
	public List<ResDetailScreen> getBacicInfo(long restaurantId){
		return resDetailScreenMapper.getBacicInfo(restaurantId);
	}
	@Override
	public List<ResDetailSeat> getSeatInfo(long restaurantId){
		return resDetailScreenMapper.getSeatInfo(restaurantId);
	}
	@Override
	public List<ResDetailFeature> getFeaturInfo(long restaurantId){
		return resDetailScreenMapper.getFeaturInfo(restaurantId);
	}
	@Override
	public List<ResDetailReview> getReviewList(long restaurantId){
		return resDetailScreenMapper.getReviewList(restaurantId);
	}

	@Override
	public List<ResDetailReview> getVisitNum(long restaurantId){
		return resDetailScreenMapper.getVisitNum(restaurantId);
	}
	
	@Override
	public List<ResDetailReserve> getReserveInfo(long restaurantId){
		return resDetailScreenMapper.getReserveInfo(restaurantId);
	}

	
	@Override
    public PageInquiryResult getMenuPhoto(PageInquiryUtil pageUtil) {
		List<ResDetailMenuPhoto> menuPhotoList=resDetailScreenMapper.getMenuPhoto(pageUtil);
        int menuPhotoCount = resDetailScreenMapper.getMenuPhotoCount(pageUtil);
        PageInquiryResult pageInquiryResult = new PageInquiryResult(menuPhotoList, menuPhotoCount, pageUtil.getLimit(), pageUtil.getCurrentPage());
        return pageInquiryResult;
    }

	@Override
    public List<ResDetailScore> getScoreDistribute(long restaurantId){
		return resDetailScreenMapper.getScoreDistribute(restaurantId);
	}
	@Override
    public List<ResDetailScore> getItemAvgScore(long restaurantId) {
		return resDetailScreenMapper.getItemAvgScore(restaurantId);
	}
	
}
