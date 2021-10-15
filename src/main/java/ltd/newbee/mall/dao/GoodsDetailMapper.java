package ltd.newbee.mall.dao;

import java.util.ArrayList;

import ltd.newbee.mall.entity.GoodsDetail;

public interface GoodsDetailMapper {

	ArrayList<GoodsDetail> getGoodsDetailList(long goodsId);
	
}
