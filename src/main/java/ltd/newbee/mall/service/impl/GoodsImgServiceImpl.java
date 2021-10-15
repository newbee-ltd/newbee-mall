package ltd.newbee.mall.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.GoodsImgMapper;
import ltd.newbee.mall.entity.GoodsImg;
import ltd.newbee.mall.service.GoodsImgService;

@Service
public class GoodsImgServiceImpl implements GoodsImgService {

	@Autowired
	private GoodsImgMapper goodsImgMapper;

	@Override
	public ArrayList<GoodsImg> getGoodsImgList(long goodsId) {
		ArrayList<GoodsImg> GoodsImgList = goodsImgMapper.getGoodsImgList(goodsId);
		return GoodsImgList;
	}

}
