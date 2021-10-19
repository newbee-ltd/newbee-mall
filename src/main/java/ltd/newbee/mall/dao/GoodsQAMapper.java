package ltd.newbee.mall.dao;


import ltd.newbee.mall.entity.QuestionAndAnswer;

public interface GoodsQAMapper {

	long insertGoodsQA(QuestionAndAnswer qa);
	Long getMaxGoodsId(Long goodsId);
}
