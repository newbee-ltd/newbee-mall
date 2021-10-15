package ltd.newbee.mall.service;

import java.util.ArrayList;

import ltd.newbee.mall.entity.GoodsImg;

public interface GoodsImgService {

	ArrayList<GoodsImg> getGoodsImgList(long goodsId);
	
}
