package ltd.newbee.mall.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.GoodsDetailMapper;

import ltd.newbee.mall.entity.GoodsDetail;
import ltd.newbee.mall.service.GoodsDetailService;
import ltd.newbee.mall.service.GoodsImgService;

@Service
public class GoodsDetailServerImpl implements GoodsDetailService{

	@Autowired
	private GoodsDetailMapper goodsDetailMapper;

	@Override
	public ArrayList<GoodsDetail> getGoodsDetailList(long goodsId) {
		ArrayList<GoodsDetail> goodsDetailList = goodsDetailMapper.getGoodsDetailList(goodsId);
		return goodsDetailList;
	}
	
}
