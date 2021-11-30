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
import ltd.newbee.mall.entity.ResDetailCourse;
import ltd.newbee.mall.entity.ResDetailFeature;
import ltd.newbee.mall.entity.ResDetailPhoto;
import ltd.newbee.mall.entity.ResDetailScreen;
import ltd.newbee.mall.entity.ResDetailSeat;
import ltd.newbee.mall.service.ResDetailScreenService;

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
	
}
