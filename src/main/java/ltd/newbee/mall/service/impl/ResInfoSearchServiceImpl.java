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

import ltd.newbee.mall.dao.ResInfoSearchMapper;
import ltd.newbee.mall.entity.ResDetailScreen;
import ltd.newbee.mall.entity.ResInfoSearch;
import ltd.newbee.mall.service.ResInfoSearchService;

@Service
public class ResInfoSearchServiceImpl implements ResInfoSearchService {

	@Autowired
	private ResInfoSearchMapper resInfoSearchMapper;

	@Override
	public List<String> getCityName(String cityName) {
		return resInfoSearchMapper.getCityName(cityName);
	}

	@Override
	public List<String> getTownName(String townName) {
		return resInfoSearchMapper.getTownName(townName);
	}

	@Override
	public List<String> getStationName(String stationName) {
		return resInfoSearchMapper.getStationName(stationName);
	}

	@Override
	public List<String> getKeywords(String keywords) {
		return resInfoSearchMapper.getKeywords(keywords);
	}

	@Override
	public List<ResInfoSearch> getReserveInfo() {
		return resInfoSearchMapper.getReserveInfo();
	}

}
