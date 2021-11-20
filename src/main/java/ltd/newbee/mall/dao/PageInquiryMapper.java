package ltd.newbee.mall.dao;

import java.util.List;

import ltd.newbee.mall.entity.QuestionAndAnswer;
import ltd.newbee.mall.entity.QuestionSannkou;
import ltd.newbee.mall.entity.ReviewSannkou;
import ltd.newbee.mall.util.PageInquiryUtil;

public interface PageInquiryMapper {

	List<QuestionAndAnswer> findQAList(PageInquiryUtil pageUtil);

	int getGoodsQACount(PageInquiryUtil pageUtil);

	
	List<QuestionSannkou> getQASannkouUserId(QuestionSannkou questionSannkou);
	boolean insertHelpNum(QuestionSannkou questionSannkou);
	boolean updateHelpNum(QuestionSannkou questionSannkou);
	long getHelpNum(long questionsId,long goodsId);
	
}
