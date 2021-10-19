package ltd.newbee.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ltd.newbee.mall.dao.GoodsQAMapper;
import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.service.GoodsQAService;

@Service
public class GoodsQAServiceImpl implements GoodsQAService {

	@Autowired
	private GoodsQAMapper goodsQAMapper;

	@Override
	public long insertGoodsQA(QuestionAndAnswer qa) {
		return goodsQAMapper.insertGoodsQA(qa);
	}
	
	@Override
	public Long getMaxGoodsId(Long goodsId) {
		Long maxGoodsId = goodsQAMapper.getMaxGoodsId(goodsId);
		if(maxGoodsId !=null) {
			return maxGoodsId + 1;
		}else {
			return 1L;
		}
	}

}
