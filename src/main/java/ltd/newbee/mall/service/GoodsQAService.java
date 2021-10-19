package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.QuestionAndAnswer;

public interface GoodsQAService {

	long insertGoodsQA(QuestionAndAnswer qa);
	Long getMaxGoodsId(Long goodsId);
}
