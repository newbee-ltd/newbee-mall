package ltd.newbee.mall.service;

import java.util.ArrayList;

import ltd.newbee.mall.entity.GoodsDetail;

public interface GoodsDetailService {

	ArrayList<GoodsDetail> getGoodsDetailList(long goodsId);
	
}
