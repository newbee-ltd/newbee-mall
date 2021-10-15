package ltd.newbee.mall.dao;

import java.util.ArrayList;
import ltd.newbee.mall.entity.GoodsImg;

public interface GoodsImgMapper {
	
	  ArrayList<GoodsImg> getGoodsImgList(long goodsId);
	  
}
